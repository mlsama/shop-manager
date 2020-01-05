package com.mlsama.shop.controller;

import com.mlsama.shop.pojo.ElementUiTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/11/7 11:37
 */
//允许跨域,origins：允许哪些网站跨域访问，默认*，maxAge：准备响应前的缓存持续的最大时间（以秒为单位）默认1800。
//@CrossOrigin(origins = {"http://localhost:8888"},maxAge=60L)
@Controller
@Slf4j
public class TestController {

    @GetMapping("/tree")
    @ResponseBody
    public List<ElementUiTree> getTree(){
        List<ElementUiTree> treeList = new ArrayList<>();
        List<ElementUiTree> childList = new ArrayList<>();
        ElementUiTree childrenTree = new ElementUiTree("mlsama-service",null);
        childList.add(childrenTree);
        ElementUiTree uiTree = new ElementUiTree("ml-service",childList);
        treeList.add(uiTree);
        return treeList;
    }
    /**
     * 首页跳转,如果部署在Tomcat,启动后会自动打开浏览器
     * @return
     */
    @RequestMapping("/")
    public String index(){
        log.info("进入TestController的index方法111");
        int i = 1/0;
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        log.info("进入TestController的login方法");
        return "login";
    }
    @RequestMapping("/order")
    public void order(){
        log.info("进入TestController的order方法,没有登陆跳转到登陆页面。");
    }


}
