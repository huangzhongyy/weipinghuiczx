package com.cssl.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/9 16:50
 * @Author: Mr.Deng
 * @Description:
 *
 *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2018-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *
 *
 */
public class AlipayConfig {


//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

 // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
 public static String app_id = "2016101000654266";

 // 商户私钥，您的PKCS8格式RSA2私钥
 public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZzhglPHmlL4HTaZqzKu5OdQaohoPAdnYXh0cGZnlROyfTV7W+LT3EDs6wXUMaAD4iX/2OBX+9J0cGknNTCMCuP5KHEArAk5r3ySqxoqG8hodqtprzZhswVXTHhaxBqhmEPg2tVBH0AH63lF/MElhvf6ir3piuXU3MVXSHnzGd9GMPOudY3sZOoEZQYKZ8L55oggmST3WVzZhXTn68KipEYB7+six/bJe8FqOPSjgaFNl0tgIBJuGtecj3A2QBNUfAG24VscrTmj9orwja10dH4HWKUHZPUIXyCqdHwPgv9N7+rhqtKP0A0puL9/x5Cbt8InM/aPP+5df48oBOBKHXAgMBAAECggEAZU0t8BCV2mug6bsLjmh/TyObABKg4nnjq/mImTmTPCJnR7bkWF756JEMJ3M1yAFS61cn7IvIp7AgAr8gwBbquZnbi6PQQSi3D+7qdNc2CbLdrDabdibRT5NpeCSd4R4E8mngnkHaFUjiLU3HjuSiZMXDNXhGPcnsfOHn/4+loW+Vu+gaFrwIRPIn+zaLnLeYp7RGM60p/axKg8c1pdFN5ZYZhiDeNT5C0LaPCQkkRV3qAgkj5Le/Omf5JgnMrQzsUiZGVLw8fWA8VcBNykH5YXk7PwuNOXoA4P1cLTbdGgfzIxdRNxpwyFVDOy+Z/OFdxe4T/gGoxP4x8Tq00B7+mQKBgQDotup3lb3FzsY/OcR4GMFDDYsIKHMiY97FCXbH00gfSVJq4Rjmvo5o8X8a7IVc/C8sY5GidFjYmDeCRchiyQ1hlXAv6VidrjVPqBIxkgiGt8yKjNvufVZufZvSfQ8UuPIN+7QgnLyFCUAIQzIQHRoyM087V8R1Qu7TSYKRsXg8fQKBgQCpMeDL6LGFoG05EgE00NWDh0ADbKDM2mTGULuHdS/CyVqhZBVINUL7K6Je5E1wV8Mgl4seHfq5TtDAswELoPFASiVM5jC7va3l6dPT1deAjkJmEyaokElrQY7F7QuhZzGFHCHGsI40CzP4jIDJp9K+n6tt+AmDt9Zbr8V9EZYr4wKBgQDhQt4nL41pAkSoQvTJA71feKaSGQWJzn5+4DBYMU5o6oKa7pU6Fk6nisxsdXKKlZncL+1zAYhW8NEaiw3zgYYwZYUY+5lJ2K3GE3y4+xDBxvx5SOxDKJQXlALXdzK37mZv3qt3vgBGDrQqy1CUhHctDLmvSb/jegzP/SIkgVNPyQKBgQCQGTLjd6L5s9BSMstkOBgglSgnwnSRA8+gN1H/5AZxVxwhKCQYA4SwdlErkDWD4LsHHwoU9GN9P2r7M3lIdiICJyPtgn8u5jUdAzCt0gpgKsjSNq1OEtT0zDjUyTaGmGTMgVEi72utV31DyiZFmPEb+NEAL6eqzv95xxHjmv7TEQKBgAMxWGC20dXVVd23sDMqfA6IeE0i7OzLq9umvHTQ9ByqtgvZeCbu80NrUZVn9Mp2QzVdov3eVRql7gGRqBcwzGbgDobBOMaRKVnHM+3wuqU6WwZyYBEc92jUsLJE8U8egBdsyhPJ/4jUL6pbnFHpc94agTiN2KW9EkohXo3VC2zH";
 // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
 public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmc4YJTx5pS+B02masyruTnUGqIaDwHZ2F4dHBmZ5UTsn01e1vi09xA7OsF1DGgA+Il/9jgV/vSdHBpJzUwjArj+ShxAKwJOa98kqsaKhvIaHaraa82YbMFV0x4WsQaoZhD4NrVQR9AB+t5RfzBJYb3+oq96Yrl1NzFV0h58xnfRjDzrnWN7GTqBGUGCmfC+eaIIJkk91lc2YV05+vCoqRGAe/rIsf2yXvBajj0o4GhTZdLYCASbhrXnI9wNkATVHwBtuFbHK05o/aK8I2tdHR+B1ilB2T1CF8gqnR8D4L/Te/q4arSj9ANKbi/f8eQm7fCJzP2jz/uXX+PKATgSh1wIDAQAB";
 // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 public static String notify_url = "http://127.0.0.1:8081/notify_url";

 // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 //public static String return_url = "http://127.1:8080/ssm/return_url";
 public static String return_url = "http://127.0.0.1:8081/return_url";

 // 签名方式
 public static String sign_type = "RSA2";

 // 字符编码格式
 public static String charset = "utf-8";

 // 支付宝网关
 public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

 // 支付宝网关
 public static String log_path = "E:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

 /**
  * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
  * @param sWord 要写入日志里的文本内容
  */
 public static void logResult(String sWord) {
  FileWriter writer = null;
  try {
   writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
   writer.write(sWord);
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   if (writer != null) {
    try {
     writer.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
  }
 }
}
