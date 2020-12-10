package ParkingProgram;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class ParkingLot {

	private ArrayList<Car> currentParkingLot = new ArrayList<>();
	private ArrayList<String> keyOfParkingLot = new ArrayList<>();
	DecimalFormat priceFormat = new DecimalFormat("#,###");
	Scanner scanner = new Scanner(System.in);
	private int income;
	private int parkingLotSize = 30;
	private CreateCar createCar = new CreateCar();

	public void setParkingLotSize() {
		System.out.printf("주차장의 주차 최대 차량 수를 입력해주세요. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
		System.out.println("주차장은 최대 " + parkingLotSize + "대 주차 가능합니다.");
	}

	public Car entryCar(String carInfo, String carNum, Date entryDate) throws ParseException{
		if (!(parkingLotSize > currentParkingLot.size()))
			throw new IndexOutOfBoundsException("오류 : 주차장에 자리가 없습니다.");

		Car curCar = createCar.create(carInfo, carNum, entryDate);

		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
		System.out.println("입차가 완료됐습니다.");
		
		return curCar;
	}

	public String exitCar(String carNum, Date exitDate) throws ParseException {
		int totalFee = 0;
		long parkingTime;
		int standardParkingTime;


		int indexOfCar = keyOfParkingLot.indexOf(carNum);
		if (indexOfCar == -1)
			throw new IllegalArgumentException("오류 : 출차번호가 존재하지 않습니다.");
		Car curCar = currentParkingLot.get(indexOfCar);

		parkingTime = curCar.calculateParkingTime(exitDate);
		standardParkingTime = curCar.calculateStandardTime();

		if (curCar.getClass().getName().equals("ParkingProgram.ElectronicPassengerCar")) {
			ElectronicPassengerCar carE = (ElectronicPassengerCar) curCar;
			totalFee = carE.calculateParkingFee() + carE.calculateChargingFee(parkingTime);
		} else {
			totalFee = curCar.calculateParkingFee();
		}

		addIncome(totalFee);

		keyOfParkingLot.remove(indexOfCar);
		currentParkingLot.remove(indexOfCar);
		
		System.out.println("출차가 완료됐습니다.");

		return calExitInformation(standardParkingTime, totalFee);
	}
	
	public int checkParkingLot(String carNum) {
		return keyOfParkingLot.indexOf(carNum);
	}
	
	public int checkParkingTime(String carNum ,Date exitDate) throws ParseException {
		int indexOfCar = keyOfParkingLot.indexOf(carNum);
		Car curCar = currentParkingLot.get(indexOfCar);
		return (int) curCar.calculateParkingTime(exitDate);
	}

	public String calExitInformation(int standardTime, int parkingFee) {
		int hour = 0, min = 0;

		if (standardTime / 60 != 0)
			hour = standardTime / 60;
		min = standardTime % 60;

		System.out.println("주차시간은 " + hour + "시간 " + min + "분입니다.");
		System.out.println("주차요금은 " + priceFormat.format(parkingFee) + "원입니다.");
		
		return hour+" "+min+" "+priceFormat.format(parkingFee);
	}

	public ArrayList<Car> showParkingLot() {
		ArrayList<Car> cloneParkingLot = (ArrayList<Car>) currentParkingLot.clone();

		return cloneParkingLot;
	}

	public void addIncome(int parkingFee) {
		income += parkingFee;
	}

	public void showIncome() {
		System.out.println("총 수입은 " + priceFormat.format(income) + "원입니다");
	}

}