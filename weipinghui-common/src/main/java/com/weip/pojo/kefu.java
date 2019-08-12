package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:40
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class kefu  implements Serializable
{
   private int k_id;//客服ID
   private String k_name;//客服名字
   private String k_type;//客服类型
}
