package com.cssl.lanjieqi;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/13 16:29
 * @Author: Mr.Deng
 * @Description:
 */
@Component
public class LoginLanJieQi extends HandlerInterceptorAdapter {

 /**
  * 拦截在请求之前
  * @param request
  * @param response
  * @param handler
  * @return
  * @throws Exception
  */
 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

   String uri = request.getRequestURI();
   //System.out.println(uri);
   Object sj = request.getSession().getAttribute("sj");
   // 如果链接是来登录的  或者他已经登陆了 就可以过去
   if(uri.endsWith("sjLogin.html") || uri.endsWith("/login") || sj!=null){
      return true;
   }else{ // 非法访问
    response.sendRedirect("sjLogin.html");
    return false;
   }


 }


















 /**
  * 请求controller之后要回到页面之前
  * @param request
  * @param response
  * @param handler
  * @param modelAndView
  * @throws Exception
  */
 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
  super.postHandle(request, response, handler, modelAndView);
 }

 /**
  * 到达页面之后在进行渲染
  * @param request
  * @param response
  * @param handler
  * @param ex
  * @throws Exception
  */
 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  super.afterCompletion(request, response, handler, ex);
 }
}
