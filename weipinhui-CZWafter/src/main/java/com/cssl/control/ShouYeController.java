package com.cssl.control;

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
import java.util.List;

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

 // 大分类
 @RequestMapping("/aftershouye")
 @ResponseBody
 public List<twotype> loadQuanBu(@RequestBody Integer oneid){
   System.out.println("进来了"+oneid);
   return sys.fenLei(oneid);
 }



 @RequestMapping("/after/test")
 @ResponseBody
 public String test(HttpSession session){
  session.getAttribute("flag");
  return "我在测试";
 }
}
