package com.weip.pojo;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/31 15:24
 * @Author: Mr.Deng
 * @Description:
 */
public class ShopCar implements Serializable
{//购物车对象



 private int number;//商品数量

 private int biaoshi;//标识

 public int getBiaoshi() {
  return biaoshi;
 }

 public void setBiaoshi(int biaoshi) {
  this.biaoshi = biaoshi;
 }

 private double xiaoJi;//(商品数量*单价)

 private int gooid;//商品外键

 public int getGooid() {
  return gooid;
 }

 public void setGooid(int gooid) {
  this.gooid = gooid;
 }


 public int getNumber() {
  return number;
 }

 public void setNumber(int number) {
  this.number = number;
 }

 public double getXiaoJi() {//小计=(商品数量*单价)
 return this.xiaoJi=xiaoJi;
 }

 public void setXiaoJi(double xiaoJi) {
  this.xiaoJi = xiaoJi;
 }
}
