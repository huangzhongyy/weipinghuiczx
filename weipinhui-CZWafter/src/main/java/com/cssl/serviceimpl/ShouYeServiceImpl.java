package com.cssl.serviceimpl;

import com.cssl.dao.ShouYeDao;
import com.cssl.service.ShouYeService;
import com.weip.pojo.onetype;
import com.weip.pojo.threetype;
import com.weip.pojo.twotype;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 20:14
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class ShouYeServiceImpl implements ShouYeService {

 @Resource
 private ShouYeDao syd;

 @Override
 public List<twotype> fenLei(Integer oneid) {
    //对应的所有二级分类
    List<twotype>  list2 = syd.selectTwo(oneid);

    List<threetype> list3 = null;
    for(twotype ttype:list2){
        //对应的三级分类
        list3 = syd.selectThree(ttype.getTwo_tid());
        ttype.setThreetypeList(list3);
    }


  System.out.println("list2"+list2.size());
  System.out.println("list3"+list3.size());
  return list2;
 }

 @Override
 public List<Map<String, Object>> selectOrderByMap(Map<String, Object> map) {
  return syd.selectOrderByMap(map);
 }

 //总订单数用于分页
 @Override
 public int selectOrderCountBysid(Integer sid,String od_id) {
  return syd.selectOrderCountBysid(sid,od_id);
 }
}
