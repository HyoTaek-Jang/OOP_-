package ParkingProgram;

import java.util.Scanner;

public class CreateCar {

	private String carNumber;
	private String entryTime;
	private String awnser;
	Scanner scanner = new Scanner(System.in);

	public Car create() {
		System.out.println("차량 종류 및 용량을 입력하세요! 승용차(c), 트럭(t), 버스(b)");
		awnser = scanner.nextLine();
		String processedAwnser[] = awnser.split(" ");

		String kindOfCar = processedAwnser[0];
		int capacity = Integer.parseInt(processedAwnser[1]);

		if (!(kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))) {
			System.out.println("에러");
		}

		System.out.println("차량 번호를 입력하세요!(4자리 숫자)");
		carNumber = scanner.nextLine();

		System.out.println("입차시간을 입력하세요! (년 월 일 시 분)");
		entryTime = scanner.nextLine();

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
