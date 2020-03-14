package com.github.tanqizhou.share.cd.entity;

import lombok.Getter;
import lombok.ToString;

/**
 * @Auther: TanqiZhou
 * @Date: 2020/03/15/1:23
 * @Description: Car Direction
 */
@Getter
@ToString
public enum CarDirection {

    NORTH("NORTH"),
    EAST("EAST"),
    SOUTH("SOUTH"),
    WEST("WEST");

    private String direction;

    CarDirection(String direction){
        this.direction = direction;
    }
}
