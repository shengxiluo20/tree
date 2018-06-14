package com.join.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chi  2018-06-14 12:35
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TargetClass {

    private String id;

    private String name;

    private String pId;

    private List<TargetClass> child = new ArrayList<>();

    public static TargetClass covert(SourceClass sourceClass) {
        TargetClass targetClass = new TargetClass();
        targetClass.id = sourceClass.getId();
        targetClass.name = sourceClass.getName();
        return targetClass;
    }


}
