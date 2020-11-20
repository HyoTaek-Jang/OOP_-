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
		System.out.println("원하는 기능을 선택하세요!");
		System.out.println("1. 입차");
		System.out.println("2. 출차");
		System.out.println("3. 주차차량 보기");
		System.out.println("4. 총 수입 보기");
		System.out.println("5. 종료");
	}

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ParkingLot parkingLot = new ParkingLot();
		int checkNum;

		System.out.println("주차장 관리 프로그램이 실행됐습니다.");
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
					System.out.println("오류 : 날짜 형식에 맞지 않은 입력 값입니다.");
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(1);
			default:
				System.out.println("오류 : 메뉴에 존재하지 않는 번호입니다.");
			}

		}
	}

}
