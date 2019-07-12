package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:54
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class twotype
{
   private int two_tid;//二级分类
   private String two_tname;//分类名称
   private int two_one_tid;//所属一级分类
}
