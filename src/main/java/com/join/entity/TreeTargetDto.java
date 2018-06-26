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
public class TreeTargetDto {

    private Integer id;

    private String name;

    private Integer pId;

    private List<TreeTargetDto> child = new ArrayList<>();

    /**
     * 类转换,基本属性复制
     * @param treeSource
     * @return
     */
    public static TreeTargetDto covert(TreeSource treeSource) {
        TreeTargetDto treeTargetDto = new TreeTargetDto();
        treeTargetDto.id = treeSource.getId();
        treeTargetDto.name = treeSource.getName();
        return treeTargetDto;
    }


}
