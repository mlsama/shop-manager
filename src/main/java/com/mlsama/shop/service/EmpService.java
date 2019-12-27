package com.mlsama.shop.service;

import com.mlsama.shop.pojo.Emp;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/12/25 17:24
 */
public interface EmpService {

    void insert(Emp emp);
    void update(int dept,int eId);
    public void test(Emp emp,int dept, int eId);
}
