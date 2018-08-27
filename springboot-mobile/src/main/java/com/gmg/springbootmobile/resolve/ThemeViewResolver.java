package com.gmg.springbootmobile.resolve;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.util.ResolverUtils;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.util.ClassLoaderUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Locale;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/8/20  13:48
 */
@Component
public class ThemeViewResolver extends LiteDeviceDelegatingViewResolver {
    // PC端默认主题目录
    private static final String DEFAULT_NORMAL_THEME = "default/";
    // 手机端默认主题目录
    private static final String DEFAULT_MOBILE_THEME = "mobile/";
    // 平板端默认主题目录
    private static final String DEFAULT_TABLET_THEME = "mobile/";

    // PC端当前主题目录
    private static final String CURRENT_NORMAL_THEME = "default/";
    // 手机端当前主题目录
    private static final String CURRENT_MOBILE_THEME = "mobile/";
    // 平板端当前主题目录
    private static final String CURRENT_TABLET_THEME = "mobile/";

    @Value("${spring.thymeleaf.prefix}")
    private String thymeleafPrefix;

    @Value("${spring.thymeleaf.suffix}")
    private String thymeleafSuffix;

    public ThemeViewResolver(@Qualifier("thymeleafViewResolver") ViewResolver delegate) {
        super(delegate);
    }

    @PostConstruct
    public void init() {
        // 是否支持回退
        // true表示如果找不到移动端视图，则使用PC端默认视图
        this.setEnableFallback(true);
        this.setNormalPrefix(DEFAULT_NORMAL_THEME);
        this.setMobilePrefix(DEFAULT_MOBILE_THEME);
        this.setTabletPrefix(DEFAULT_TABLET_THEME);

        // 设置的优先级要比ThymeleafViewResolver高，要在ThymeleafViewResolver之前解析
        this.setOrder(1);
    }

    /**
     * 检查当前请求使用的设备，然后根据请求设备的不同，返回适合该设备的视图名
     */
    @Override
    protected String getDeviceViewNameInternal(String viewName) {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attrs).getRequest();
        Device device = DeviceUtils.getCurrentDevice(request);
        String resolvedViewName = viewName;
        String currentTheme = this.getNormalPrefix();
        if (ResolverUtils.isNormal(device, null)) {
            currentTheme = StringUtils.isNotEmpty(CURRENT_NORMAL_THEME) ? appendTrailingSlash(CURRENT_NORMAL_THEME) : this.getNormalPrefix();
            resolvedViewName = currentTheme + viewName + this.getNormalSuffix();
        } else if (ResolverUtils.isMobile(device, null)) {
            currentTheme = StringUtils.isNotEmpty(CURRENT_MOBILE_THEME) ? appendTrailingSlash(CURRENT_MOBILE_THEME) : this.getMobilePrefix();
            resolvedViewName = currentTheme + viewName + this.getMobileSuffix();
        } else if (ResolverUtils.isTablet(device, null)) {
            currentTheme = StringUtils.isNotEmpty(CURRENT_TABLET_THEME) ? appendTrailingSlash(CURRENT_TABLET_THEME) : this.getTabletPrefix();
            resolvedViewName = currentTheme + viewName + this.getTabletSuffix();
        }

        return this.stripTrailingSlash(resolvedViewName);
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        // 获取当前设备对应的视图名
        String deviceViewName = this.getDeviceViewName(viewName);
        // 检查设备视图模板是否存在
        boolean deviceViewExisted = checkViewExisted(deviceViewName);
        View view = null;
        if (this.getEnableFallback() && !deviceViewExisted) {
            // 启用回退功能
            // 如果设备视图模板不存在，则返回PC端默认视图
            String normalViewName = this.getNormalPrefix().concat(viewName).concat(this.getNormalSuffix());
            view = this.getViewResolver().resolveViewName(normalViewName, locale);
        } else {
            view = this.getViewResolver().resolveViewName(deviceViewName, locale);
        }

        return view;
    }

    public boolean checkViewExisted(String viewName) {
        String prefix = thymeleafPrefix.replace("classpath:/", StringUtils.EMPTY);
        String fullPath = prefix.concat(viewName).concat(thymeleafSuffix);
        URL url = ClassLoaderUtils.getClassLoader(this.getClass()).getResource(fullPath);

        return url != null;
    }

    private String stripTrailingSlash(String viewName) {
        return viewName.endsWith("//") ? viewName.substring(0, viewName.length() - 1) : viewName;
    }

    private String appendTrailingSlash(String themeName) {
        return themeName.endsWith("/") ? themeName : themeName.concat("/");
    }
}

