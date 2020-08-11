package com.fearsing.zhihu.controller;

import com.fearsing.zhihu.service.HotListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController

public class HotListController {
    @Autowired
    HotListService service;
    @RequestMapping(value = "/downloadExcel" ,method = RequestMethod.GET)
    public void downLoadExcel(HttpServletResponse response){
}

}
