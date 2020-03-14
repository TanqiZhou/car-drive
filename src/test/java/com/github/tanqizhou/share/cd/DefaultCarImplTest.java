package com.github.tanqizhou.share.cd;

import com.github.tanqizhou.share.cd.entity.CarDirection;
import com.github.tanqizhou.share.cd.entity.CarPark;
import com.github.tanqizhou.share.cd.entity.CarPosition;
import com.github.tanqizhou.share.cd.entity.OutCarParkException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class DefaultCarImplTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        CarPosition carPosition = new CarPosition(1,1, CarDirection.NORTH.getDirection());
        CarPark carPark = new CarPark(4,4);
        car = new DefaultCarImpl(carPosition, carPark);
    }

    @Test
    public void move() {
        //move forward
        car.move("2");
        assertEquals(car.getPositionX(), 1);
        assertEquals(car.getPositionY(), 3);
        assertEquals(car.getOrientation(), CarDirection.NORTH.getDirection());

        //TURN test
        car.move("TURN");
        car.move("2");
        assertEquals(car.getPositionX(), 3);
        assertEquals(car.getPositionY(), 3);
        assertEquals(car.getOrientation(), CarDirection.EAST.getDirection());

        //OutCarParkException Test
        try {
            car.move("5");
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), new OutCarParkException().getMessage());
        }
    }
}
