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
		System.out.println("주차장 관리 프로그램이 실행됐습니다.");
		parkingLot.setParkingLotSize();

		while (true) {
			System.out.println("");
			System.out.println("원하는 기능을 선택하세요!");
			System.out.println("1. 입차");
			System.out.println("2. 출차");
			System.out.println("3. 주차차량 보기");
			System.out.println("4. 총 수입 보기");
			System.out.println("5. 종료");

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
				System.out.println("프로그램을 종료합니다.");
				System.exit(1);
			default:
				System.out.println("잘못된 입력입니다.");
			}

		}
	}

}
