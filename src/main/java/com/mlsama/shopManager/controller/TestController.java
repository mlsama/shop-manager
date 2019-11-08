package com.mlsama.shopManager.controller;

import com.mlsama.shopManager.pojo.ElementUiTree;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/11/7 11:37
 */
//允许跨域,origins：允许哪些网站跨域访问，默认*，maxAge：准备响应前的缓存持续的最大时间（以秒为单位）默认1800。
@CrossOrigin(origins = {"http://localhost:8888"},maxAge=100L)
@RestController
public class TestController {

    @GetMapping("/tree")
    public List<ElementUiTree> getTree(){
        List<ElementUiTree> treeList = new ArrayList<>();
        List<ElementUiTree> childList = new ArrayList<>();
        ElementUiTree childrenTree = new ElementUiTree("mlsama",null);
        childList.add(childrenTree);
        ElementUiTree uiTree = new ElementUiTree("ml",childList);
        treeList.add(uiTree);
        return treeList;
    }

}
