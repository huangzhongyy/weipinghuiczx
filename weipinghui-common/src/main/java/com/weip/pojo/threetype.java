package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:52
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class threetype implements Serializable
{
   private int three_tid;//三级分类id
   private String three_tname;//名字
   private int three_two_tid;//所属的二级分类
}
