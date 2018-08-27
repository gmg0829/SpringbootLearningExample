package com.example.demo.controller;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/4/20  16:52
 */
@RestController
public class HelloController {

    @Autowired
    private CloudSolrServer solrserver;


    public String hello(){
        return"say hello";
    }
    @RequestMapping("test")
    public void test(){

        ModifiableSolrParams params = new ModifiableSolrParams();
        params.add("q","demo:gmg博客");
        params.add("ws","json");
        params.add("start","0");
        params.add("rows","10");
        QueryResponse response = null;

        try{
            response=solrserver.query(params);
            SolrDocumentList results = response.getResults();
            for (SolrDocument document : results) {
                System.out.println( document.getFieldValue("demo"));
                System.out.println(document.getFieldValue("id"));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        System.out.println(response.toString());
    }
}