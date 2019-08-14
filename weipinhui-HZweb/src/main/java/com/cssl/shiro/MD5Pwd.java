package com.cssl.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/13 8:54
 * @Author: Mr.Deng
 * @Description:
 */
public class MD5Pwd {


 public static final String ALGORITHM_NAME = "MD5";  // 基础散列算法
 public static final int HASH_ITERATIONS = 2;  // 自定义散列次数

//MD5加密
  public static String MD5Pwd(String username,String passwrod){
   ByteSource salt=ByteSource.Util.bytes(username); //盐值加密
   String md5Pwd = new SimpleHash(ALGORITHM_NAME, passwrod,
    salt, HASH_ITERATIONS).toHex();
   return md5Pwd;
  }

}
