package com.fearsing.zhihu;

import com.fearsing.zhihu.mapper.LoginTokenMapper;
import com.fearsing.zhihu.service.HotListService;
import com.fearsing.zhihu.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ZhihuApplicationTests {
    @Autowired
    HotListService service;
    @Autowired
    LoginTokenMapper mapper;
    @Test
    void contextLoads() {
        Map<String,Object> map=new HashMap<>();
        service.insert();
    }
    @Test
    void contextLoad() {
        Map<String,Object> map=new HashMap<>();
        map.put("web_name","hot_list");
        System.out.println(mapper.selectToken(map));
    }
    @Autowired
    SendMailService sendMailService;
    @Test
    void contextLoads3() {
        sendMailService.sendSimpleMail("fearling@outlook.com","lingfei","256364");
    }


}
