package ParkingProgram;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;

public class CreateCar {

	public Car create(String carInfo, String carNumber, Date entryTime) throws ParseException{

		String processedAwnser[] = carInfo.split(" ");

		String kindOfCar = processedAwnser[0];
		int capacity = Integer.parseInt(processedAwnser[1]);

		
		if (carNumber.length() != 4)
			throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
		
		for (int i = 0; i < 4; i++) {
			if (!Character.isDigit(carNumber.charAt(i)))
				throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
		}


		switch (kindOfCar) {
		case "c":
			if (capacity != 0) {
				ElectronicPassengerCar carOfE = new ElectronicPassengerCar(capacity, kindOfCar, carNumber, entryTime);
				return carOfE;
			}
			PassengerCar carOfP = new PassengerCar(kindOfCar, carNumber, entryTime);
			return carOfP;
		case "b":
			Bus carOfB = new Bus(capacity, kindOfCar, carNumber, entryTime);
			return carOfB;
		case "t":
			Truck carOfT = new Truck(capacity, kindOfCar, carNumber, entryTime);
			return carOfT;

		}

		return null;

	}
}
