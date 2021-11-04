package com.alan.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * good
 * @author 
 */
@Data
public class Good implements Serializable {
    private Integer id;

    private String name;

    private BigDecimal price;

    /**
     * 规格
     */
    private String sku;

    private Integer cid;

    private static final long serialVersionUID = 1L;
}