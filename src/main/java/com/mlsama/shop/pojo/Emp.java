package com.mlsama.shop.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/12/25 17:25
 */
@Data
public class Emp {
    private int eId;
    private String eName;
    private BigDecimal eSal;

    public Emp() {
    }

    public Emp(int eId, String eName, BigDecimal eSal) {

        this.eId = eId;
        this.eName = eName;
        this.eSal = eSal;
    }
}
