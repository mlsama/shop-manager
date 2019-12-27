package com.mlsama.shop.service.impl;

import com.mlsama.shop.mapper.EmpMapper;
import com.mlsama.shop.pojo.Emp;
import com.mlsama.shop.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/12/25 17:28
 */
@Service
@Slf4j

public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void update(int dept, int eId) {
        empMapper.update(dept, eId);
        int i = 1/0;
    }

    public void test(Emp emp,int dept, int eId){
        empMapper.insert(emp);
        empMapper.update(dept, eId);
    }
}
