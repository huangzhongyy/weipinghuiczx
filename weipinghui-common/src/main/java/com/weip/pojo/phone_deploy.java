package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: vip
 * @Date: 2019/8/12 19:22
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class phone_deploy implements Serializable
{
    private int g_id;//商品id
    private int uid;//用户id
    private String address;//配送地址
   /* private String color;//颜色
    private int memory;//内存
    private int run_memory;//运行内存*/
}
