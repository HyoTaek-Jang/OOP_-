package ParkingProgram;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParkingLot {

	private ArrayList<Car> currentParkingLot = new ArrayList<>();
	private ArrayList<String> keyOfParkingLot = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	private int income;
	private int parkingLotSize = 0;
	private CreateCar createCar = new CreateCar();

	void printExitInformation(int standardTime, int parkingFee) {
		int hour = 0, min = 0;
		
		if (standardTime / 60 != 0)
			hour = standardTime / 60;
		min = standardTime % 60;
		
		System.out.println("주차시간은 " + hour + "시간 " + min + "분입니다.");
		System.out.println("주차요금은 " + parkingFee + "원입니다.");
	}

	void entryCar(){
		Car curCar = createCar.create();
		
		if (!(parkingLotSize > currentParkingLot.size()))
			throw new IndexOutOfBoundsException("오류 : 주차장에 자리가 없습니다.");
		// 여기서 차량을 더 추가하면 내가 정한 주차장의 크기를 넘어감으로 아웃오브바운드 익셉션으로 함.
		
		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
	}

	void exitCar() throws ParseException {
		int totalFee = 0;
		long parkingTime;
		int standardParkingTime;

		System.out.println("출차할 차량번호를 입력하세요!");
		String searchCarNumber = scanner.nextLine();

		int indexOfCar = keyOfParkingLot.indexOf(searchCarNumber);
		if (indexOfCar == -1)
			throw new IllegalArgumentException("오류 : 출차번호가 존재하지 않습니다.");
		// 인덱스 찾아야하는데 잘못된 매개변수를 넘겨줬으니 일리걸아규먼트로 ㅇㅇ
		Car curCar = currentParkingLot.get(indexOfCar);
		
		parkingTime = curCar.calculateParkingTime();
		standardParkingTime = curCar.calculateStandardTime();

		if (curCar.getClass().getName().equals("ParkingProgram.ElectronicPassengerCar")) {
			ElectronicPassengerCar carE = (ElectronicPassengerCar) curCar;
			totalFee = carE.calculateParkingFee() + carE.calculateChargingFee(parkingTime);
		} else {
			totalFee = curCar.calculateParkingFee();
		}

		addIncome(totalFee);
		printExitInformation(standardParkingTime, totalFee);

		keyOfParkingLot.remove(indexOfCar);
		currentParkingLot.remove(indexOfCar);
	}

	void showParkingLot() {
		ArrayList<Car> cloneParkingLot = (ArrayList<Car>) currentParkingLot.clone();
		
		Collections.sort(cloneParkingLot);
		for (Car c : cloneParkingLot) {
			System.out.println(c);
		}
	}

	void addIncome(int parkingFee) {
		income += parkingFee;
	}

	void showIncome() {
		System.out.println("총 수입은 " + income + "원입니다");
	}

	void setParkingLotSize() {
		System.out.printf("주차장의 주차 최대 차량 수를 입력해주세요. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
	}

}