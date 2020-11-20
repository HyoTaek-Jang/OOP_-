package ParkingProgram;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		run();
	}

	public static void showMenu() {
		System.out.println("");
		System.out.println("���ϴ� ����� �����ϼ���!");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. �������� ����");
		System.out.println("4. �� ���� ����");
		System.out.println("5. ����");
	}

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ParkingLot parkingLot = new ParkingLot();
		int checkNum;

		System.out.println("������ ���� ���α׷��� ����ƽ��ϴ�.");
		parkingLot.setParkingLotSize();

		while (true) {

			showMenu();

			checkNum = scanner.nextInt();

			switch (checkNum) {
			case 1:
				try {
					parkingLot.entryCar();
				} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
					System.out.printf("%nException: %s%n", indexOutOfBoundsException);
				} catch (InputMismatchException inputMismatchException) {
					System.out.printf("%nException: %s%n", inputMismatchException);
				}
				break;
			case 2:
				try {
					parkingLot.exitCar();
				} catch (ParseException parseException) {
					System.out.printf("%nException: %s%n", parseException);
					System.out.println("���� : ��¥ ���Ŀ� ���� ���� �Է� ���Դϴ�.");
				} catch (IllegalArgumentException illegalArgumentException) {
					System.out.printf("%nException: %s%n", illegalArgumentException);
				} catch (ArithmeticException arithmeticException) {
					System.out.printf("%nException: %s%n", arithmeticException);
				}
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
				System.out.println("���� : �޴��� �������� �ʴ� ��ȣ�Դϴ�.");
			}

		}
	}

}
