package ParkingProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateCar {

	private String carNumber;
	private String entryTime;
	private String awnser;
	Scanner scanner = new Scanner(System.in);

	public Car create(){
		System.out.println("차량 종류 및 용량을 입력하세요! 승용차(c), 트럭(t), 버스(b)");
		awnser = scanner.nextLine();
		String processedAwnser[] = awnser.split(" ");

		String kindOfCar = processedAwnser[0];
		int capacity = Integer.parseInt(processedAwnser[1]);

		if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))&& (capacity > 0 || capacity == 0))) {
			throw new InputMismatchException("오류 : 차량 종류 및 용량이 옳지 않습니다.");
		} //스캐너로 받은 인풋이 형식과 맞지 않으니 인풋미스매치로 함.

		System.out.println("차량 번호를 입력하세요!(4자리 숫자)");
		carNumber = scanner.nextLine();
		
		if (carNumber.length() != 4)
			throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
		
		for (int i = 0; i < 4; i++) {
			if (!Character.isDigit(carNumber.charAt(i)))
				throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
		}

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
