package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
public class twotype implements Serializable
{
   private int two_tid;//二级分类
   private String two_tname;//分类名称
   private int two_one_tid;//所属一级分类
   private List<threetype> threetypeList;//对应的三级分类集合
}
