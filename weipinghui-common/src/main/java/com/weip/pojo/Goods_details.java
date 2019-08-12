package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/30 16:37
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Goods_details implements Serializable
{
 private int flat_card_id;//id
 private String the_fuselage_memory;
 private String the_screen_size;
 private int goods_id;//外键对应手机的ID
}
