package com.example.demo.bean;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/4/20  16:47
 */
public class MyBean {
    private SolrServer solr;
    @Autowired
    public MyBean(SolrServer solr) {
        this.solr = solr;
    }
}
