package com.lab.project.smartoffice.common.space.domain.dto;

import com.lab.project.smartoffice.common.space.domain.SpaceStrategyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-30 11:27
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class SpaceStrategyDTO {
    /**
     * 空间id
     */
    private Long spaceId;

    /**
     * spaceStrategyDTO
     */
    private List<SpaceStrategyEntity> spaceStrategyList;
}
