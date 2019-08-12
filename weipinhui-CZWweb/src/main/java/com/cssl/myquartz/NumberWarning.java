package com.cssl.myquartz;

import com.alibaba.fastjson.*;
import com.cssl.Service.ShouYeService;
import com.cssl.websocket.MyWebSocket;
import com.weip.pojo.Goods;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/7 10:09
 * @Author: Mr.Deng
 * @Description:
 */
@Component
public class NumberWarning extends QuartzJobBean {

  @Resource
  private ShouYeService sys;

 // job你要做什么事
 @Override
 protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
   // 此商家的所有商品进行库存预警
   int sid = 1;
   //查所有的商品
    Map<String,Object> map = sys.selectGoodsBySid(sid,-1,-1);

   String  json = JSON.toJSONString(map.get("rows"));  // 转成JSON字符串

   List<Goods> list = JSON.parseArray(json, Goods.class);  // 再转成list对象




   for(Goods good : list){
     if(good.getG_number()<5){ // 如果库存少于5的话就推送
      String msg = "您的ID号为"+good.getG_id()+"价格:"+good.getG_price()+"元的商品库存只有"+good.getG_number()+"件了 ! !,请保证货物充足";
      System.out.println(msg);
      MyWebSocket ws = new MyWebSocket();
      try {
      MyWebSocket.sendInfo(msg);
      Thread.sleep(3000); // 休眠一下
      } catch (IOException e) {
       e.printStackTrace();
      } catch (InterruptedException e) {
       e.printStackTrace();
      }
     }
   }

 }
}
