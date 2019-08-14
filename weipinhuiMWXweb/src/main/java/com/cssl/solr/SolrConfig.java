package com.cssl.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.SolrJConverter;

import javax.annotation.Resource;

/**
 * Created by tym on 2019/1/15 0015.
 */
@Configuration
public class SolrConfig {

    @Resource
    private SolrClient client;

    /**
     * 配置SolrTemplate
     */
    @Bean
    public SolrTemplate solrTemplate() {
        SolrTemplate template = new SolrTemplate(client);
        template.setSolrConverter(new SolrJConverter());
        return template;
    }
}

