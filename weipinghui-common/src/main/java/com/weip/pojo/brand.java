package com.weip.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:28
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class brand implements Serializable
{
   private int b_id;//品牌id
   private String b_name;//品牌名称
   private int b_tid;//品牌类别
   private String b_prictrue;//品牌图片
   private double b_discount;//品牌折扣
   private String b_title;//品牌标题
   private String b_publish;//品牌发布
}
