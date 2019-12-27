package com.mlsama.shop.mapper;

import com.mlsama.shop.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/12/25 17:29
 */
@Mapper
public interface EmpMapper {

    void insert(Emp emp);

    void update(@Param("deptNo")int dept, @Param("eId")int eId);
}
