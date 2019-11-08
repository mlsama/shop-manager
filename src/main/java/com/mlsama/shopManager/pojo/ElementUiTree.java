package com.mlsama.shopManager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DESC: element-ui的tree数据实体类
 * AUTHOR:mlsama
 * 2019/11/7 10:20
 */
@Data
@AllArgsConstructor
public class ElementUiTree {

    private int id;
    private String label;
    private int parentId;
    private List<ElementUiTree> children;

    public ElementUiTree(String label, List<ElementUiTree> children) {
        this.label = label;
        this.children = children;
    }
}
