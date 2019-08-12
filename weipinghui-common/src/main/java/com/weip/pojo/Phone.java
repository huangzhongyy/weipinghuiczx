package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: vip
 * @Date: 2019/8/12 8:42
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Phone implements Serializable
{
 private int p_id;
 private String[] color;
 private int[] memory;
 private int[] run_memory;
}
