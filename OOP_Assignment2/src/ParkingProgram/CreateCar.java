package ParkingProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateCar {

	private String carNumber;
	private String entryTime;
	private String awnser;
	Scanner scanner = new Scanner(System.in);

	public Car create(){
		System.out.println("���� ���� �� �뷮�� �Է��ϼ���! �¿���(c), Ʈ��(t), ����(b)");
		awnser = scanner.nextLine();
		String processedAwnser[] = awnser.split(" ");

		String kindOfCar = processedAwnser[0];
		int capacity = Integer.parseInt(processedAwnser[1]);

		if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))&& (capacity > 0 || capacity == 0))) {
			throw new InputMismatchException("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
		} //��ĳ�ʷ� ���� ��ǲ�� ���İ� ���� ������ ��ǲ�̽���ġ�� ��.

		System.out.println("���� ��ȣ�� �Է��ϼ���!(4�ڸ� ����)");
		carNumber = scanner.nextLine();
		
		if (carNumber.length() != 4)
			throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
		
		for (int i = 0; i < 4; i++) {
			if (!Character.isDigit(carNumber.charAt(i)))
				throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
		}

		System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
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
