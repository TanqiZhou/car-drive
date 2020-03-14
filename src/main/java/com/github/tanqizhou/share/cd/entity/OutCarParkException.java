package com.github.tanqizhou.share.cd.entity;

/**
 * @Auther: TanqiZhou
 * @Date: 2020/03/15/2:32
 * @Description:
 */
public class OutCarParkException extends RuntimeException{

    public OutCarParkException() {
        super("the car is out of reach！！！！！");
    }
}
