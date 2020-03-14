package com.github.tanqizhou.share.cd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import static com.github.tanqizhou.share.cd.entity.CarDirection.NORTH;

/**
 * @Auther: TanqiZhou
 * @Date: 2020/03/15/1:17
 * @Description: Car Position
 */
@Data
@ToString
@AllArgsConstructor
public class CarPosition {

    private int positionX;

    private int PositionY;

    private String orientation;

    public void clockWiseTurn(){
        switch (CarDirection.valueOf(getOrientation())) {
            case NORTH:
                orientation = CarDirection.EAST.getDirection();
                break;
            case EAST:
                orientation = CarDirection.SOUTH.getDirection();
                break;
            case SOUTH:
                orientation = CarDirection.WEST.getDirection();
                break;
            case WEST:
                orientation = CarDirection.NORTH.getDirection();
                break;
        }
    }
}
