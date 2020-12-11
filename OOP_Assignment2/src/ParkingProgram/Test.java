package ParkingProgram;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;

public class Test {

	private static ParkingLot parkingLot = new ParkingLot();

	public static Car runEntry(String carInfo, String carNum, Date entryDate) {
		Car curCar = null;
		try {
			curCar = parkingLot.entryCar(carInfo, carNum, entryDate);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			System.out.printf("%nException: %s%n", indexOutOfBoundsException);
		} catch (InputMismatchException inputMismatchException) {
			System.out.printf("%nException: %s%n", inputMismatchException);
		} catch (ParseException parseException) {
			System.out.printf("%nException: %s%n", parseException);
			System.out.println("오류 : 날짜 형식에 맞지 않은 입력 값입니다.");
		}

		return curCar;
	}

	public static int checkParkingLot(String carNum) {
		return parkingLot.checkParkingLot(carNum);
	}

	public static int checkPakingTime(String carNum, Date exitDate) throws ParseException {
		return parkingLot.checkParkingTime(carNum, exitDate);
	}

	public static String runExit(String carNum, Date exitDate) {
		String exitValue = null;
		try {
			exitValue = parkingLot.exitCar(carNum, exitDate);
		} catch (ParseException parseException) {
			System.out.printf("%nException: %s%n", parseException);
			System.out.println("오류 : 날짜 형식에 맞지 않은 입력 값입니다.");
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.printf("%nException: %s%n", illegalArgumentException);
		} catch (ArithmeticException arithmeticException) {
			System.out.printf("%nException: %s%n", arithmeticException);
		}
		return exitValue;
	}

	public static ArrayList<Car> getCloneParkingLot() {
		return parkingLot.showParkingLot();
	}

	public static String showIncome() {
		return parkingLot.showIncome();
	}
	
	public static int currentParkingLot() {
		return parkingLot.currentParkingLot();
	}

}
