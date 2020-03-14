package com.github.tanqizhou.share.cd;

/**
 * @Auther: TanqiZhou
 * @Date: 2020/03/15/1:23
 * @Description: Car
 */
public interface Car {

    void move(String command);

    int getPositionX();

    int getPositionY();

    String getOrientation();
}

