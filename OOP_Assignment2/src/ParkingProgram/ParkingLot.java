package ParkingProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParkingLot {

	private ArrayList<Car> currentParkingLot = new ArrayList<>();
	private ArrayList<String> keyOfParkingLot = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	private int income;
	private int parkingLotSize = 0;
	private int currentCars = 0;
	
	void printExitInformation(int standardTime, int parkingFee) {
		int hour = 0, min = 0;
		if(standardTime/60!=0) {
			hour = standardTime/60;
			min = standardTime%60;
		}
		
		System.out.println("주차시간은 "+hour+"시간 "+min+"분입니다.");
		System.out.println("주차요금은 "+parkingFee+"원입니다.");
	}

	void entryCar(Car curCar) {
		if (!(parkingLotSize > currentCars))
			System.out.println("오류");
		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
		currentCars++;
	}

	void exitCar() {
		System.out.println("출차할 차량번호를 입력하세요!");
		String searchCarNumber = scanner.nextLine();
		int indexOfCar = keyOfParkingLot.indexOf(searchCarNumber);
		Car curCar = currentParkingLot.get(indexOfCar);
		curCar.calculateParkingTime();
		addIncome(curCar.calculateParkingFee());
		printExitInformation(curCar.calculateStandardTime(), curCar.calculateParkingFee());
		System.out.println("exitCar");
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
		System.out.println("showIncome");
	}

	void setParkingLotSize() {
		System.out.printf("주차장의 주차 최대 차량 수를 입력해주세요. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
	}

}