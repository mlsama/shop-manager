package com.mlsama.shop.controller;

import com.mlsama.shop.pojo.ElementUiTree;
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
    @GetMapping("/")
    public String index(){
        return "index";
    }


}
