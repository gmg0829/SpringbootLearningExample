package com.gmg.web;

import com.gmg.domain.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.catalina.servlet4preview.http.PushBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by gmg on on 2017-11-27 15:22.
 */
@Controller
public class PoiExportController {
    //多sheet导出
    @RequestMapping("/multiplyexcelAnno")
    public void multiplyexcelAnno(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        Map<String, Object> map1 = getTestMap("统计一","画布一");
        Map<String, Object> map2 = getTestMap("统计二","画布二");
        List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
        list1.add(map1);
        list1.add(map2);
        Workbook workbook = PoiUtil.exportExcel(list1, ExcelType.HSSF);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String filedisplay = "product.xls";
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //对象导出
    @RequestMapping("/excelObjectAnno")
    public void exportObject(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        StudentEntity studentEntity1=new StudentEntity();
        StudentEntity studentEntity2=new StudentEntity();
        List<StudentEntity> list=new ArrayList<>();
        studentEntity1.setName("gmg");
        studentEntity1.setSex(1);
        studentEntity2.setName("yr");
        studentEntity2.setSex(2);
        list.add(studentEntity1);
        list.add(studentEntity2);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity.class, list);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String filedisplay = "student.xls";
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //集合导出
    @RequestMapping("/excelListAnno")
    public void exportList(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        //学生
        StudentEntity studentEntity1=new StudentEntity();
      //  StudentEntity studentEntity2=new StudentEntity();
        studentEntity1.setName("gmg");
        studentEntity1.setSex(1);
       /* studentEntity2.setName("yr");
        studentEntity2.setSex(2);*/
        List<StudentEntity> listStudent=new ArrayList<>();
        listStudent.add(studentEntity1);
      //  listStudent.add(studentEntity2);

        //老师
        TeacherEntity teacherEntity=new TeacherEntity();
        teacherEntity.setName("高老师");
        //课程
        List<CourseEntity> listCourse=new ArrayList<>();
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setName("数学");
        courseEntity.setMathTeacher(teacherEntity);
        courseEntity.setStudents(listStudent);
        listCourse.add(courseEntity);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("课程", null, "测试"),
                CourseEntity.class, listCourse);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String filedisplay = "course.xls";
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //图片导出
    @RequestMapping("/exportImage")
    public void exportImage(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        CompanyImg companyImg1=new CompanyImg();
        CompanyImg companyImg2=new CompanyImg();
        List<CompanyImg> list=new ArrayList<>();
        companyImg1.setCompanyLogo("img/100.jpg");
        companyImg2.setCompanyLogo("img/101.jpg");
        list.add(companyImg1);
        list.add(companyImg2);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("图片","图片"),
                CompanyImg.class, list);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String filedisplay = "img.xls";
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //图片导出
    @RequestMapping("/exportTemplate")
    public void exportTemplate(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        TemplateExportParams params = new TemplateExportParams(
                "WEB-INF/doc/专项支出用款申请书_map.xls");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");
        map.put("money", 2000000.00);
        map.put("upperMoney", "贰佰万");
        map.put("company", "执笔潜行科技有限公司");
        map.put("bureau", "财政局");
        map.put("person", "JueYue");
        map.put("phone", "1879740****");
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("zijin", i * 10000 + "");
            lm.put("bianma", "A001");
            lm.put("mingcheng", "设计");
            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
            lm.put("quancheng", "开源项目");
            lm.put("sqje", i * 10000 + "");
            lm.put("hdje", i * 10000 + "");

            listMap.add(lm);
        }
        map.put("maplist", listMap);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String filedisplay = "img.xls";
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getTestMap(String title,String sheetName) {
        Map<String,Object> map1  = new LinkedHashMap<String,Object>();
        List<User> list = getUser();
        map1.put(NormalExcelConstants.CLASS, User.class);
        //设置title和sheet名称
        ExportParams ep = new ExportParams(title, sheetName);
        map1.put(NormalExcelConstants.PARAMS, ep);
        map1.put(NormalExcelConstants.DATA_LIST, list);
        return map1;
    }


    public static  List<User> getUser(){
        //商品
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setId(1);
        p1.setName("apple");
        p1.setPrice(10);
        p1.setTime(new Date());

        p2.setId(2);
        p2.setName("pear");
        p2.setPrice(30);
        p2.setTime(new Date());
        //用户1
        User u1 = new User();
        u1.setAge(21);
        u1.setId(Long.parseLong("1"));
        u1.setName("cyf");
        u1.setProduct(p1);
        u1.setSex(1);
        List<Product> products = new ArrayList<Product>();
        products.add(p2);
        products.add(p1);
        u1.setProducts(products);
        u1.setTime(new Date());
        //用户2
        User u2 = new User();
        u2.setAge(23);
        u2.setId(Long.parseLong("2"));
        u2.setName("cy");
        u2.setProduct(p2);
        u2.setSex(0);
        u2.setProducts(products);
        u2.setTime(new Date());

        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);

        return users;
    }
}
