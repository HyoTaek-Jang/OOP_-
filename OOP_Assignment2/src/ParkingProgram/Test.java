package ParkingProgram;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		run();
	}

	static void run() {
		Scanner scanner = new Scanner(System.in);
		ParkingLot parkingLot = new ParkingLot();
		CreateCar createCar = new CreateCar();
		int checkNum;
		System.out.println("������ ���� ���α׷��� ����ƽ��ϴ�.");
		parkingLot.setParkingLotSize();

		while (true) {
			System.out.println("");
			System.out.println("���ϴ� ����� �����ϼ���!");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. �������� ����");
			System.out.println("4. �� ���� ����");
			System.out.println("5. ����");

			checkNum = scanner.nextInt();

			switch (checkNum) {
			case 1:
				Car curCar = createCar.create();
				parkingLot.entryCar(curCar);
				break;
			case 2:
				parkingLot.exitCar();
				break;
			case 3:
				parkingLot.showParkingLot();
				break;
			case 4:
				parkingLot.showIncome();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(1);
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}

		}
	}

}
