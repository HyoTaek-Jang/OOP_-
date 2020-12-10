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
		System.out.printf("�������� ���� �ִ� ���� ���� �Է����ּ���. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
		System.out.println("�������� �ִ� " + parkingLotSize + "�� ���� �����մϴ�.");
	}

	public Car entryCar(String carInfo, String carNum, Date entryDate) throws ParseException{
		if (!(parkingLotSize > currentParkingLot.size()))
			throw new IndexOutOfBoundsException("���� : �����忡 �ڸ��� �����ϴ�.");

		Car curCar = createCar.create(carInfo, carNum, entryDate);

		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
		System.out.println("������ �Ϸ�ƽ��ϴ�.");
		
		return curCar;
	}

	public String exitCar(String carNum, Date exitDate) throws ParseException {
		int totalFee = 0;
		long parkingTime;
		int standardParkingTime;


		int indexOfCar = keyOfParkingLot.indexOf(carNum);
		if (indexOfCar == -1)
			throw new IllegalArgumentException("���� : ������ȣ�� �������� �ʽ��ϴ�.");
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
		
		System.out.println("������ �Ϸ�ƽ��ϴ�.");

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

		System.out.println("�����ð��� " + hour + "�ð� " + min + "���Դϴ�.");
		System.out.println("��������� " + priceFormat.format(parkingFee) + "���Դϴ�.");
		
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
		System.out.println("�� ������ " + priceFormat.format(income) + "���Դϴ�");
	}

}