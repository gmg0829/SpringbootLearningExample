package com.gmg.domain;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * Created by gmg on on 2017-12-11 10:57.
 */
public class CompanyImg implements java.io.Serializable {
    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 1)
    private String companyLogo;

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
}
