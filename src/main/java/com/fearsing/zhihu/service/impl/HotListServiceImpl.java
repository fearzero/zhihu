package com.fearsing.zhihu.service.impl;


import com.fearsing.zhihu.mapper.HotListMapper;
import com.fearsing.zhihu.mapper.LoginTokenMapper;
import com.fearsing.zhihu.service.HotListService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

;

@Service
@Repository
public class HotListServiceImpl implements HotListService {
    @Autowired
    HotListMapper mapper;
    @Autowired
    LoginTokenMapper tokenMapper;


    @Override
    public Map<String, Object> insert() {
        HotListServiceImpl testService=new HotListServiceImpl();
        Map<String,Object> map=new HashMap<>();
        map.put("web_name","hot_list");
        Map<String,Object> tokenMap=tokenMapper.selectToken(map);
        String url=tokenMap.get("source_url").toString();
        String cookie=tokenMap.get("token").toString();
        List<Map<String, Object>> list= testService.selectZhiHuPage(url,cookie);
        for(Map<String, Object> map1:list){
            try {
                mapper.insert(map1);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
   public List<Map<String, Object>> selectZhiHuPage(String url,String cookie){
       List<Map<String, Object>> resultList=new ArrayList<>();
       try {
           Document doc= Jsoup.connect(url).header("cookie",cookie).get();

           Elements div=doc.getElementsByClass("HotList-list");
            Date date=new Date();
           SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
           String time =df1.format(date);
           SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmm");
           String time_code=df2.format(date);
           Elements elements =doc.select("section");
           for(Element element:elements){
               String rank= element.select("div.HotItem-rank").text();
               Elements a= element.select("div.HotItem-content > a");
               String href=a.attr("href");
               String title=a.attr("title");
               String num=element.select("div.HotItem-metrics").text();



               Map<String,Object> stp=new HashMap<>();
               stp.put("id",rank);
               stp.put("question",title);
               stp.put("question_url",href);
               stp.put("hot_rank",num);
               stp.put("update_time",time);
               stp.put("time_code",time_code);
               resultList.add(stp);
           }

       } catch (IOException e) {
           e.printStackTrace();
       }


       return resultList;
   }

}
