package com.github.tanqizhou.share.cd;

import com.github.tanqizhou.share.cd.entity.CarDirection;
import com.github.tanqizhou.share.cd.entity.CarPark;
import com.github.tanqizhou.share.cd.entity.CarPosition;
import com.github.tanqizhou.share.cd.entity.OutCarParkException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: TanqiZhou
 * @Date: 2020/03/15/1:29
 * @Description: default Car's implements
 */
@Slf4j
public class DefaultCarImpl implements Car {

    private CarPosition carPosition;

    private CarPark carPark;

    public DefaultCarImpl(CarPosition carPosition, CarPark carPark) {
        if (carPosition != null && carPark != null) {
            this.carPosition = carPosition;
            this.carPark = carPark;
        } else {
            throw new RuntimeException(" carPosition and carPark not null ");
        }
    }

    @Override
    public void move(String command) {
        if ("TURN".equals(command.toUpperCase())) {
            carPosition.clockWiseTurn();
        } else {
            int distance = Integer.parseInt(command);
            switch (CarDirection.valueOf(getOrientation())) {
                case NORTH:
                    carPosition.setPositionY(getPositionY() + distance);
                    break;
                case EAST:
                    carPosition.setPositionX(getPositionX() + distance);
                    break;
                case WEST:
                    carPosition.setPositionX(getPositionX() - distance);
                    break;
                case SOUTH:
                    carPosition.setPositionY(getPositionY() - distance);
                    break;
            }
            if (outOfBounds()) {
                throw new OutCarParkException();
            }
        }
    }

    @Override
    public int getPositionX() {
        return carPosition.getPositionX();
    }

    @Override
    public int getPositionY() {
        return carPosition.getPositionY();
    }

    @Override
    public String getOrientation() {
        return carPosition.getOrientation();
    }

    private boolean outOfBounds() {
        boolean carX = carPark.getWidth() < getPositionX() || getPositionX() < 0;
        boolean carY = carPark.getHeight() < getPositionY() || getPositionY() < 0;
        if ( carX && carY) {
            log.error("Car X and Y is out of reach");
            return true;
        }
        if (carX) {
            log.error("Car X is out of reach");
            return true;
        }
        if (carY) {
            log.error("Car Y is out of reach");
            return true;
        }
        return false;
    }
}
