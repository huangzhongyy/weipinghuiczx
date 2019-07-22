package com.cssl.control;

import com.cssl.Service.ShouYeService;
import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Lists;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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

 @RequestMapping("/shouYeFenLei")
 @ResponseBody
 public List<twotype> loadQuanBu(Integer oneid){
   List<twotype> list2=  sys.loadFenLei(oneid);
   System.out.println("*******"+list2);
   return list2;
 }

 @RequestMapping("/testa")
 public String test(Model mm, HttpSession session){
  System.out.println("这里1");
  session.setAttribute("flag","标志");
   sys.test();
   return "login";
 }


}
