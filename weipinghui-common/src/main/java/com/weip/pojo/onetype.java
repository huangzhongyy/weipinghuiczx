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
 * @Date: 2019/7/11 19:42
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class onetype implements Serializable
{
   private int one_tid;//一级分类ID
   private String one_tname;//分类名称
   private String one_tdescription;//具体描述
   private List<twotype> twotypeList;//对应的二级分类
}
