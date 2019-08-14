package com.cssl.controller;

import com.weip.pojo.Goods;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: vip
 * @Date: 2019/8/13 14:58
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class solrController
{
    @Resource
    private SolrClient client;

    @Resource
    private SolrTemplate template;

    @RequestMapping("/search")
    public String search_goods(String title, Model model) throws Exception
    {
       SolrQuery query=new SolrQuery();
       query.set("q","g_name:"+title);
       //query.set("df","keywords");

       query.setHighlight(true);
       query.addHighlightField("g_name");
       query.setHighlightSimplePre("<span style='color:red'>");
       query.setHighlightSimplePost("</span>");
       QueryResponse queryResponse=client.query(query);
       SolrDocumentList results=queryResponse.getResults();
       long numfound=results.getNumFound();
       System.out.println("总查询出来:"+numfound+"条记录");

       Map<String,Map<String,List<String>>> highlighting=queryResponse.getHighlighting();
       List<Goods> list=new ArrayList<>();
       for (SolrDocument solrDocument: results)
       {
          Goods goods=new Goods();
          goods.setG_id((Integer) (solrDocument.get("g_id")));
          goods.setG_name(String.valueOf(solrDocument.get("g_name")));
          goods.setG_description(String.valueOf(solrDocument.get("g_description")));
          goods.setG_price((Double)solrDocument.get("g_price"));
          goods.setG_discount((Double)solrDocument.get("g_discount"));
          goods.setG_number((Integer)solrDocument.get("g_number"));
          goods.setG_image(String.valueOf(solrDocument.get("g_image")));
          goods.setG_tid(35);
          list.add(goods);

          System.out.println("商品名称 :" + solrDocument.get("g_name"));
          System.out.println("商品详情 :" + solrDocument.get("g_description"));
          System.out.println("商品价格 :" + solrDocument.get("g_price"));
          System.out.println("商品图片 :" + solrDocument.get("g_image"));

          //输出高亮
          /*Map<String, List<String>> map = highlighting.get(solrDocument.get("id"));
          List<String> list = map.get("g_name");
          if(list != null && list.size() > 0)
          {
           System.out.println("hight:"+list.get(0));
          }*/
       }
     System.out.println("list:"+list.size());
      model.addAttribute("map",list);
       return "shangping";
    }
}


/*
 Map<String, List<Goods>> map = new HashMap<>();
 Criteria cri = new Criteria("keywords").contains(title);
 HighlightQuery query = new SimpleHighlightQuery(cri);  //query.addCriteria(cri);

 //高亮选项
 HighlightOptions ho = new HighlightOptions();
       ho.addField("g_name");   //高亮域，可以多个
        ho.setSimplePrefix("<span color='red'>");
        ho.setSimplePostfix("</span>");
        //为查询对象设置高亮选项
        query.setHighlightOptions(ho);

        //返回高亮页对象
        HighlightPage<Goods> hp = template.queryForHighlightPage("mycore",query,Goods.class);
 //此时hp.getContent()还是原生内容，没有高亮
 //高亮入口集合（每条记录的高亮入口）
 List<HighlightEntry<Goods>> list = hp.getHighlighted();
 for (HighlightEntry<Goods> entry : list)
 {
 //获取高亮域列表（高亮域的个数）
 List<HighlightEntry.Highlight> hl = entry.getHighlights();
 if(hl.size()>0 && hl.get(0).getSnipplets().size()>0)
 {
 Goods good = entry.getEntity();
 //假设只一个高亮域
 good.setG_name(hl.get(0).getSnipplets().get(0));
 }
 }
 map.put("rows",hp.getContent());
 mav.addObject("map",map);*/
