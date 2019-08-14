package com.cssl.jiantingqi;

import com.weip.pojo.shanjia;
import org.apache.http.protocol.HTTP;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/13 19:39
 * @Author: Mr.Deng
 * @Description:
 */
@WebListener
public class LoginJianTingQi implements ServletContextListener,HttpSessionListener{

 private ServletContext application;

 @Override
 public void contextInitialized(ServletContextEvent sce) {
  System.out.println("application初始化");
  application = sce.getServletContext();
  application.setAttribute("sjs",new ArrayList<shanjia>());
 }

 @Override
 public void contextDestroyed(ServletContextEvent sce) {
  System.out.println("application销毁");
 }





 @Override
 public void sessionCreated(HttpSessionEvent se) {
  HttpSession session = se.getSession();
  session.setMaxInactiveInterval(12); // 是12 秒
  System.out.println("session创建******** "+session.getId());
 }

 @Override
 public void sessionDestroyed(HttpSessionEvent se) {
  HttpSession session = se.getSession();
  System.out.println("销毁session "+session.getId());
  shanjia sj = (shanjia) session.getAttribute("sj");

  // 剔除下线的人
  List<shanjia> list = (List<shanjia>)application.getAttribute("sjs");
  for(shanjia s : list){
     if(sj.getS_id()==s.getS_id()){
        list.remove(s);
     }
  }
  application.setAttribute("sjs",list); // 我觉得要重新加入一下
 }
}
