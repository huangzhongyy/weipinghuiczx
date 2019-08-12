package com.cssl.control;

import com.cssl.service.GoodsService;
import com.cssl.service.Order_detailService;
import com.cssl.service.ShangJIaService;
import com.cssl.service.ShouYeService;
import com.weip.pojo.Goods;
import com.weip.pojo.shanjia;
import com.weip.pojo.twotype;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:52
 * @Author: Mr.Deng
 * @Description:
 */
@RefreshScope
@Controller
public class ShouYeController {

     @Resource
     private ShouYeService sys;
     @Resource
     private Order_detailService ods;
     @Resource
     private GoodsService gs;
     @Resource
     private ShangJIaService sjs;

     @RequestMapping("/after/login")
     @ResponseBody
     public shanjia afterLogin(@RequestBody shanjia sj){
         return sjs.login(sj);
     }
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
     public Map<String,Object> selectOrderByMap(@RequestBody Map<String,Object> map,HttpSession session){
      Map<String,Object> map2 = new HashMap<>();
      // 商家id
      Integer sid = Integer.parseInt(map.get("sid").toString());

      // session
      System.out.println("sessionId: *****"+session.getId());
      shanjia sj = (shanjia) session.getAttribute("sj");
      System.out.println(sj);
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
   public String updateStatu(Integer status,String od_id){
    System.out.println("进来了");
     int num =  ods.updateOrder_status(status,od_id);
     if(num>0){
        return "成功了";
     }else{
      return "失败了";
     }
   }

 /**
  * 商家对应的商品
  * @param sid
  * @param page
  * @param rows
  * @return
  */
   @RequestMapping("/after/goodsbysid")
   @ResponseBody
   public Map<String, Object> selectGoodsBySid(int sid,int page,int rows){
    Map<String,Object> map = new HashMap<>();
    map.put("total",gs.selectGoodsCount(sid));
    map.put("rows",gs.selectGoodsBysid(sid,page,rows));
    return map;
   }

 /**
  *
  *  增加一个商品
  */
  @RequestMapping("/after/addgood")
  @ResponseBody
  public String addgood(@RequestBody Goods good){  // 接收对象要用requestBody吧
   System.out.println(good.getG_name()+"****");
     int num =   gs.addgood(good);
     if(num > 0){
       return "增加成功";
     }else{
      return "增加成功";
     }
  }
 /**
  *  删除一个商品
  */
  @RequestMapping("/after/destroyRowgoood")
  @ResponseBody
  public String deleteGoodBygid(int gid){
     int num = gs.deleteGoodBygid(gid);
     if(num>0){
       return "删除成功";
     }else{
      return "删除失败";
     }
  }

 /**
  * 查找一个商品
  */
 @RequestMapping("/after/findGoodBygid")
 @ResponseBody
 public Goods findGoodBygid(int gid){
  return gs.selectGoodBygid(gid);
 }

 /**
  * 修改一个商品
  * @param
  * @return
  */
 @RequestMapping("/after/updategood")
 @ResponseBody
  public String updateGood(@RequestBody Goods good){
  int num = gs.updateGood(good);
  if(num>0){
   return  "修改成功";
  }
  return "修改失败";
 }
















 @RequestMapping("/after/test")
     @ResponseBody
     public String test(HttpSession session){
     String user = (String) session.getAttribute("user");
      System.out.println(user);
     return "我在测试";
     }
}
