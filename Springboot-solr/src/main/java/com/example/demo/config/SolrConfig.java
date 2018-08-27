package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/4/20  16:50
 */
@ConfigurationProperties(prefix="spring.solr")
public class SolrConfig {
    private String host;
    private String zkHost;
    private String defaultCollection;

    public String getDefaultCollection() {
        return defaultCollection;
    }

    public void setDefaultCollection(String defaultCollection) {
        this.defaultCollection = defaultCollection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getZkHost() {
        return zkHost;
    }

    public void setZkHost(String zkHost) {
        this.zkHost = zkHost;
    }
}