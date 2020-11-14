package ParkingProgram;

import java.util.Scanner;

public class CreateCar {

	private String carNumber;
	private String entryTime;
	private String awnser;
	Scanner scanner = new Scanner(System.in);

	public Car create() {
		System.out.println("���� ���� �� �뷮�� �Է��ϼ���! �¿���(c), Ʈ��(t), ����(b)");
		awnser = scanner.nextLine();
		String processedAwnser[] = awnser.split(" ");

		String kindOfCar = processedAwnser[0];
		int capacity = Integer.parseInt(processedAwnser[1]);

		if (!(kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))) {
			System.out.println("����");
		}

		System.out.println("���� ��ȣ�� �Է��ϼ���!(4�ڸ� ����)");
		carNumber = scanner.nextLine();

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
