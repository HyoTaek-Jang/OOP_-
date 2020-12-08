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
			System.out.println("���� : ��¥ ���Ŀ� ���� ���� �Է� ���Դϴ�.");
		}
		
		return curCar;
	}
//
//			case 2:
//				try {
//					parkingLot.exitCar();
//				} catch (ParseException parseException) {
//					System.out.printf("%nException: %s%n", parseException);
//					System.out.println("���� : ��¥ ���Ŀ� ���� ���� �Է� ���Դϴ�.");
//				} catch (IllegalArgumentException illegalArgumentException) {
//					System.out.printf("%nException: %s%n", illegalArgumentException);
//				} catch (ArithmeticException arithmeticException) {
//					System.out.printf("%nException: %s%n", arithmeticException);
//				}
//				break;
//
//			case 3:
//				parkingLot.showParkingLot();
//				break;
//			case 4:
//				parkingLot.showIncome();
//				break;
//			case 5:
//				System.out.println("���α׷��� �����մϴ�.");
//				System.exit(1);
//			default:
//				System.out.println("���� : �޴��� �������� �ʴ� ��ȣ�Դϴ�.");
//			}
//

}
