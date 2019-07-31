package com.cssl.control;

import com.cssl.Service.ShouYeService;
import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Lists;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:49
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class ShouYeControl {

    @Resource
    private ShouYeService sys;


 /**
  * 前台首页三级分类
  * @param oneid
  * @return
  */
 @RequestMapping("/shouYeFenLei")
    @ResponseBody
    public List<twotype> loadQuanBu(Integer oneid){
      List<twotype> list2=  sys.loadFenLei(oneid);
      System.out.println("*******"+list2);
      return list2;
    }


    /**
     * 后台页面的订单查询
     * @param sid
     * @param page
     * @param rows
     * @param od_id
     * @return
     */
    @RequestMapping("/order")
    @ResponseBody
    public Map<String,Object> selectOrderBysid(Integer sid, @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "2") Integer rows,String od_id){
     System.out.println("进来order"+sid+"\t"+page+"\t"+rows+"\t"+od_id);
     Map<String,Object> map = new HashMap<>();
     map.put("sid",sid);              // 商家id
     map.put("qudiao",(page-1)*rows); // 分页第几页
     map.put("xianshi",rows);         // 显示的行数
     map.put("od_id",od_id);          // 订单号
     return sys.selectOrderByMap(map);
    }

 /**
  * 确认发货，已发货,已签收
  * 根据订单更改状态
  */
 @RequestMapping("/updatestatus")
 @ResponseBody
 public String updateStatuaasas(Integer status,String od_id){
   return sys.updateStatue(status,od_id);
 }
















 @RequestMapping("/testa")
    public String test(Model mm, HttpSession session){
     System.out.println("这里1");
     //String user = "session:" + System.currentTimeMillis();
      session.setAttribute("user", "曹志威");
      System.out.println("曹志威");
      sys.test();
      return "login";
    }


   }
