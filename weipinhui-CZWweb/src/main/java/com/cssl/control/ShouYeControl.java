package com.cssl.control;

import com.cssl.Service.ShouYeService;
import com.weip.pojo.goods;
import com.weip.pojo.shanjia;
import com.weip.pojo.twotype;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:49
 * @Author: Mr.Deng
 * @Description:
 */
@RefreshScope
@Controller
public class ShouYeControl implements ServletContextAware{

    private ServletContext application;//获取全局

    @Resource
    private ShouYeService sys;


   @Override
   public void setServletContext(ServletContext arg0) {
    this.application=arg0;
   }


 /**
  * 后台登陆
  */
  @RequestMapping("/login")
  public String login(String s_name,String s_pwd,Model model,HttpSession session){
   shanjia sj = new shanjia();
   sj.setS_name(s_name);
   sj.setS_pwd(s_pwd);

   shanjia newSJ = sys.afterLogin(sj);
    if(newSJ == null){ // 没有这条数据
      model.addAttribute("msg","帐户名或密码错误,请重新登录");
      return "sjLogin";
    }else{ // 登陆成功
      System.out.println(newSJ+"************");
      session.setAttribute("sj",newSJ);

      System.out.println(      session.getAttribute("sj"));
      return "afterindex";
    }
  }
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
    public Map<String,Object> selectOrderBysid(@RequestParam("sid")Integer sid, @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "2") Integer rows,String od_id){
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
  System.out.println("进来了updatestatu");
  return sys.updateStatue(status,od_id);
 }



 /**
  * 商家对应的商品 分页
  */
 @RequestMapping("/goodsbysid")
 @ResponseBody
 public Map<String,Object> selectGoodsBysid(int sid,int page,int rows){
  System.out.println("进来order"+sid+"\t"+page+"\t"+rows+"\t");

  return sys.selectGoodsBySid(sid,(page-1)*rows,rows);
 }


 /**
  * 增加一个商品
  */
  @RequestMapping("/addRowGood")
  @ResponseBody
  public String addGood(@RequestParam("g_image") MultipartFile file, HttpServletRequest request) throws IOException{
       // 取出要添加商品的信息

       int sid = 1; //到时候从session里面去取
       String gname = request.getParameter("g_name");
       String gdesc = request.getParameter("g_description");
       Double gprice = Double.parseDouble(request.getParameter("g_price"));
       Double gdiscount = Double.parseDouble(request.getParameter("g_discount"));
       int gnumber = Integer.parseInt(request.getParameter("g_number"));

       // 图片上传
       if (file.isEmpty()) {
          return "图片都没有 --!";
       }
       List<String> types= Arrays.asList("image/jpeg","image/jpg","image/gif","image/png");//限制上传类型
       String filePath = "B:\\idea\\weipinghuiczx\\weipinhui-CZWweb\\src\\main\\resources\\upload\\";//项目中upload的路径
       //System.out.println(filePath);

       String newName = UUID.randomUUID()+file.getOriginalFilename(); // 新名字，避免重复
       String filetype = file.getContentType(); //文件的真实类型，不是后缀名
       if(types.contains(filetype)){
        File dest = new File(filePath + newName);
        if (!dest.getParentFile().exists()) {
         //假如文件不存在即重新创建新的文件已防止异常发生
         dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);  // 上传成功
       }

   // 封装成一个商品对象
   goods good = new goods(gname,gdesc,gprice,gdiscount,gnumber,newName,341,sid);

   // 把数据保存到数据库
        return sys.addgood(good);

  }



 /**
  *  删除一个商品
  */
  @RequestMapping("/destroyRowgood")
  @ResponseBody
  public String deleteGoodBygid(int gid){
   System.out.println(gid);
   return sys.destroyRow(gid);
  }


 /**
  * 显示要修改的内容
  */
   @RequestMapping("showContent")
   public String showContent(Model mm,int gid){
     mm.addAttribute("good",sys.findGoodBygid(gid));
     return "updateGood";
   }

 /**
  * 修改一个商品
  * @return
  */
   @RequestMapping("/updategood")
   @ResponseBody
   public String updateGood(@RequestParam("g_image") MultipartFile file, HttpServletRequest request) throws IOException{
    // 取出要添加商品的信息
    int sid = 1;  // 商家ID
    int gid = Integer.parseInt(request.getParameter("g_id"));
    String gname = request.getParameter("g_name");
    String gdesc = request.getParameter("g_description");
    Double gprice = Double.parseDouble(request.getParameter("g_price"));
    Double gdiscount = Double.parseDouble(request.getParameter("g_discount"));
    int gnumber = Integer.parseInt(request.getParameter("g_number"));

    // 图片上传
    if (file.isEmpty()) {
     return "图片都没有 --!";
    }

    List<String> types= Arrays.asList("image/jpeg","image/jpg","image/gif","image/png");//限制上传类型
    String filePath = "B:\\idea\\weipinghuiczx\\weipinhui-CZWweb\\src\\main\\resources\\upload\\";//项目中upload的路径
    String newName = UUID.randomUUID()+file.getOriginalFilename(); // 新名字，避免重复
    String filetype = file.getContentType(); //文件的真实类型，不是后缀名
    if(types.contains(filetype)){
     File dest = new File(filePath + newName);
     if (!dest.getParentFile().exists()) {
      //假如文件不存在即重新创建新的文件已防止异常发生
      dest.getParentFile().mkdirs();
     }
     file.transferTo(dest);  // 上传成功
    }

    // 封装成一个商品对象
    goods good = new goods(gid,gname,gdesc,gprice,gdiscount,gnumber,newName,341,sid);

    // 把数据保存到数据库
    return sys.updateGood(good);

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
