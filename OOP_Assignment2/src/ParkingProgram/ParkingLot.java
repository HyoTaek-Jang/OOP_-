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

	public void printExitInformation(int standardTime, int parkingFee) {
		int hour = 0, min = 0;

		if (standardTime / 60 != 0)
			hour = standardTime / 60;
		min = standardTime % 60;

		System.out.println("�����ð��� " + hour + "�ð� " + min + "���Դϴ�.");
		System.out.println("��������� " + parkingFee + "���Դϴ�.");
	}

	public void entryCar() {
		if (!(parkingLotSize > currentParkingLot.size()))
			throw new IndexOutOfBoundsException("���� : �����忡 �ڸ��� �����ϴ�.");

		Car curCar = createCar.create();


		currentParkingLot.add(curCar);
		keyOfParkingLot.add(curCar.getCarNumber());
	}

	public void exitCar() throws ParseException {
		int totalFee = 0;
		long parkingTime;
		int standardParkingTime;

		System.out.println("������ ������ȣ�� �Է��ϼ���!");
		String searchCarNumber = scanner.nextLine();

		int indexOfCar = keyOfParkingLot.indexOf(searchCarNumber);
		if (indexOfCar == -1)
			throw new IllegalArgumentException("���� : ������ȣ�� �������� �ʽ��ϴ�.");
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

	public void showParkingLot() {
		ArrayList<Car> cloneParkingLot = (ArrayList<Car>) currentParkingLot.clone();

		if (!cloneParkingLot.isEmpty()) {
			Collections.sort(cloneParkingLot);
			for (Car c : cloneParkingLot) {
				System.out.println(c);
			}
		}
		else
			System.out.println("�������� ����ֽ��ϴ�.");
	}

	public void addIncome(int parkingFee) {
		income += parkingFee;
	}

	public void showIncome() {
		System.out.println("�� ������ " + income + "���Դϴ�");
	}

	public void setParkingLotSize() {
		System.out.printf("�������� ���� �ִ� ���� ���� �Է����ּ���. : ");
		parkingLotSize = scanner.nextInt();
		scanner.nextLine();
	}

}