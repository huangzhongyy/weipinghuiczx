package com.cssl.control;

import com.cssl.Service.ShouYeService;
import com.weip.pojo.Goods;
import com.weip.pojo.shanjia;
import com.weip.pojo.twotype;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;



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
    @Value("${spring.tengxun.accessKey}")
    private String accessKey;
    @Value("${spring.tengxun.secretKey}")
    private String secretKey;
    @Value("${spring.tengxun.bucket}")
    private String bucket;
    @Value("${spring.tengxun.bucketName}")
    private String bucketName;
    @Value("${spring.tengxun.path}")
    private String path;
    @Value("${spring.tengxun.qianzhui}")
    private String qianzui;


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
      //System.out.println("sessionId"+session.getId());
      System.out.println(newSJ+"************");
      session.setAttribute("sj",newSJ);

      System.out.println(session.getAttribute("sj"));
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

   System.out.println("进来了增加。。。。");
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

   // 1 初始化用户身份信息(secretId, secretKey)
   COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
   // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
   ClientConfig clientConfig = new ClientConfig(new Region(bucket));
   // 3 生成cos客户端
   COSClient cosclient = new COSClient(cred, clientConfig);
   // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
   String bucketName = this.bucketName;
   // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
   // 大文件上传请参照 API 文档高级 API 上传
   File localFile = null;

   List<String> types= Arrays.asList("image/jpeg","image/jpg","image/gif","image/png");//限制上传类型
   String oldName = file.getOriginalFilename(); // 旧的文件名字
   String hz = oldName.substring(oldName.lastIndexOf('.')); // 从点的那里开始截取后缀
   String newName = UUID.randomUUID()+hz; // 新名字，避免重复
   String filetype = file.getContentType(); //文件的真实类型，不是后缀名
   try {
    localFile = File.createTempFile("temp",null);
    file.transferTo(localFile);


    if(types.contains(filetype)) {
     // 指定要上传到 COS 上的路径
     String key = "/" + this.qianzui + "/" + newName;
     PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
     PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest); // 完成上传
    }
   } catch (IOException e) {
    e.printStackTrace();
   }finally {
    // 关闭客户端(关闭后台线程)
    cosclient.shutdown();
   }

   String sqlimage = path+"/"+qianzui+"/"+newName;
   // 封装成一个商品对象
   Goods good = new Goods(gname,gdesc,gprice,gdiscount,gnumber,sqlimage,341,sid);

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
     return "aftergoods";
   }

 /**
  * 修改一个商品
  * @return
  */
   @RequestMapping("/updategood")
   @ResponseBody
   public String updateGood(@RequestParam("g_image") MultipartFile file, HttpServletRequest request) throws IOException{
    System.out.println("进来了修改。。。。");
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

    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(bucket));
    // 3 生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    String bucketName = this.bucketName;
    // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
    // 大文件上传请参照 API 文档高级 API 上传
    File localFile = null;

    List<String> types= Arrays.asList("image/jpeg","image/jpg","image/gif","image/png");//限制上传类型

    String oldName = file.getOriginalFilename();                 // 旧的文件名字
    String hz = oldName.substring(oldName.lastIndexOf('.')); // 从点的那里开始截取后缀
    String newName = UUID.randomUUID()+hz;                       // 新名字，避免重复

    try {
     localFile = File.createTempFile("temp",null);
     file.transferTo(localFile);
     String filetype = file.getContentType();                    //文件的真实类型，不是后缀名
     if(types.contains(filetype)) {
      // 指定要上传到 COS 上的路径
      String key = "/" + this.qianzui + "/" + newName;
      PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
      PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest); // 完成上传
     }
    } catch (IOException e) {
     e.printStackTrace();
    }finally {
     // 关闭客户端(关闭后台线程)
     cosclient.shutdown();
    }

    String sqlImage = path+"/"+qianzui+"/"+newName;

    // 封装成一个商品对象
    Goods good = new Goods(gid,gname,gdesc,gprice,gdiscount,gnumber,sqlImage,341,sid);

    // 把数据保存到数据库
    return sys.updateGood(good);

   }

 /**
  * 当个商品的当年每个月销量
  *
  * @return
  */
  @RequestMapping("/xiaoliang")
  @ResponseBody
  public List<Integer> selectXLBygid(Integer gid){
   System.out.println("进来了。。哦啊啊是");
   System.out.println(gid+"111");
   List<Integer> list = new ArrayList<>();
   List<Map<String,Object>> list1 = sys.selectXLbygid(gid);
   System.out.println(list1);
   for (Map<String,Object> map : list1){
     int number = Integer.parseInt(map.get("c").toString());
     list.add(number);
   }
   return list;
  }

 /**
  *   查询今年所有订单的各个商品的销量
  */
 @RequestMapping("/allCount")
 @ResponseBody
 public List<Map<String,Object>> selectAllCount(Model m){
  List<String> listName = new ArrayList<>();
  List<Integer> listCount = new ArrayList<>();
  List<Map<String,Object>> list = sys.selectAllCount();
  for(Map<String,Object> map : list){
     listName.add(map.get("gname").toString());
     int number = Integer.parseInt(map.get("gcount").toString());
     listCount.add(number);
  }
   m.addAttribute("listName",listName);
   m.addAttribute("listCount",listCount);
   //return "bing";
   return list;
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
