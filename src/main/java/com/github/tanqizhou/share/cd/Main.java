package com.github.tanqizhou.share.cd;

import com.github.tanqizhou.share.cd.entity.CarDirection;
import com.github.tanqizhou.share.cd.entity.CarPark;
import com.github.tanqizhou.share.cd.entity.CarPosition;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("set the height of parking lot:");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int height = 0;
            while (in.hasNext()) {
                try {
					height = Integer.parseInt(in.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("illegal input");
                    System.out.println("please enter integer");
                    continue;
                }
            }

            System.out.println("set the width of parking lot");
            int width = 0;
            while (in.hasNext()) {
                try {
					width = Integer.parseInt(in.next());
                    break;
                } catch (NumberFormatException e) {
					System.out.println("illegal input");
					System.out.println("please enter or integer");
					continue;
                }
            }
			CarPark carPark = new CarPark(height,width);

			String orientation = setOrientation(in);
			int positionX = setPositionX(in, height);
			int positionY = setPositionY(in, width);

			CarPosition car = new CarPosition(positionX, positionY, orientation);
            System.out.println(car.toString());
			moveCommand(in, carPark, car);
        }
    }

	private static void moveCommand(Scanner in, CarPark carPark, CarPosition car) {
		Car service = new DefaultCarImpl(car, carPark);
		System.out.println("input \"TURN\" or integer");

		while (in.hasNext()) {
			String command = in.next().trim();
			try {
				service.move(command);
			} catch (NumberFormatException e) {
				System.out.println("illegal command");
				System.out.println("Please input \"TURN\" or integer");
				continue;
			} catch (RuntimeException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				break;
			}

			System.out.println(car.toString());
			System.out.println("input your command,input \"TURN\" or integer");
		}
	}

	private static int setPositionY(Scanner in, int width) {
		System.out.println("set the the Initial position-Y of car");
		int positionY = 0;
		while (in.hasNext()) {
			try {
				positionY = Integer.parseInt(in.next());
				if (positionY > width || positionY <= 0) {
					System.out.println("illegal input");
					System.out.println("The initialization position cannot exceed the parking area.");
					System.out.println("Please enter again:");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("illegal input");
				System.out.println("please enter or integer");
				continue;
			}
		}
		return positionY;
	}

	private static int setPositionX(Scanner in, int height) {
		System.out.println("set the the Initial position-X of car");
		int positionX = 0;
		while (in.hasNext()) {
			try {
				positionX = Integer.parseInt(in.next());
				if (positionX > height || positionX <= 0) {
					System.out.println("illegal input");
					System.out.println("The initialization position cannot exceed the parking area.");
					System.out.println("Please enter again:");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("illegal input");
				System.out.println("please enter integer");
				continue;
			}
		}
		return positionX;
	}

	private static String setOrientation(Scanner in) {
		String orientation = null;
		System.out.println("please input car of orientation");
		while (in.hasNext()) {
			orientation = in.next().trim().toUpperCase();
			try {
				CarDirection carDirection = CarDirection.valueOf(orientation);
				orientation = carDirection.getDirection();
				return orientation;
			}catch ( IllegalArgumentException e ){
				System.out.println("illegal input");
				System.out.println("please input NORTH,EAST,SOUTH or WEST.");
			}
		}
		return null;
	}

}
