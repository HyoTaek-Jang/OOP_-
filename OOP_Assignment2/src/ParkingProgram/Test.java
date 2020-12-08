package ParkingProgram;

import java.text.ParseException;
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

//			case 3:
//				parkingLot.showParkingLot();
//				break;
//			case 4:
//				parkingLot.showIncome();
//				break;
//			case 5:
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(1);
//			default:
//				System.out.println("오류 : 메뉴에 존재하지 않는 번호입니다.");
//			}
//

}
