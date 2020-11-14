package ParkingProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParkingLot {

	private ArrayList<Car> currentParkingLot = new ArrayList<>();
	private ArrayList<String> keyOfParkingLot = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int income;
	private int parkingLotSize = 0;
	private int currentCars = 0;

	void entryCar(Car curCar) {
		if (!(parkingLotSize > currentCars))
			System.out.println("오류");
		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
		currentCars++;
	}

	void exitCar() {
		System.out.println("출차번호 대시오");
		String searchCarNumber = scanner.nextLine();
		int indexOfCar = keyOfParkingLot.indexOf(searchCarNumber);
		Car curCar = currentParkingLot.get(indexOfCar);

		System.out.println("curCar classname : " + curCar.getClass().getTypeName());

		curCar.calculateParkingTime();

		System.out.println("exitCar");
	}

	void showParkingLot() {
		ArrayList<Car> cloneParkingLot = (ArrayList<Car>) currentParkingLot.clone();
		Collections.sort(cloneParkingLot);
		for (Car c : cloneParkingLot) {
			System.out.println(c);

		}
	}

	void showIncome() {
		System.out.println("showIncome");
	}

	void setParkingLotSize() {
		System.out.printf("주차장의 주차 최대 차량 수를 입력해주세요. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
	}

}