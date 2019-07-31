package com.cssl.control;

import com.cssl.service.Order_detailService;
import com.cssl.service.ShouYeService;
import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:52
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class ShouYeController {

     @Resource
     private ShouYeService sys;
     @Resource
     private Order_detailService ods;


     // 大分类
     @RequestMapping("/aftershouye")
     @ResponseBody
     public List<twotype> loadQuanBu(@RequestBody Integer oneid){
       System.out.println("进来了"+oneid);
       return sys.fenLei(oneid);
     }


     /**
      * 通过条件查询订单详情
      * @param map
      * @return list<map>
      */
     @RequestMapping("/after/order")
     @ResponseBody
     public Map<String,Object> selectOrderByMap(@RequestBody Map<String,Object> map){
      Map<String,Object> map2 = new HashMap<>();
      // 商家id
      Integer sid = Integer.parseInt(map.get("sid").toString());
      // 订单id
      String od_id = null;
      Object od_id1 = map.get("od_id");
      if(od_id1!=null && !"".equals(od_id1)){
          od_id = od_id1.toString();
      }
      map2.put("total",sys.selectOrderCountBysid(sid,od_id));
      map2.put("rows",sys.selectOrderByMap(map));
      return map2;
     }


 /**
  * 确认发货,已发货，已签收
  * @param
  * @return
  */
   @RequestMapping("/after/updatestatuss")
   @ResponseBody
   public String updateStatu(@RequestBody Integer status,String od_id){
    System.out.println("进来了");
     int num =  ods.updateOrder_status(status,od_id);
     if(num>0){
        return "成功了";
     }else{
      return "失败了";
     }
   }

     @RequestMapping("/after/test")
     @ResponseBody
     public String test(HttpSession session){
     String user = (String) session.getAttribute("user");
      System.out.println(user);
     return "我在测试";
     }
}
