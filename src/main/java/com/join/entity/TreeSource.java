package com.join.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 原始类,对应于数据库中的数据
 * @author chi  2018-06-14 12:34
 **/
@Data
@AllArgsConstructor
public class TreeSource {

    private Integer id;

    private String name;

    private Integer pId;
}
