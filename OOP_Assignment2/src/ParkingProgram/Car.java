package ParkingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Car implements Comparable<Car> {

	enum kindsOfCar {
		승용차, 버스, 트럭
	}

	Scanner scanner = new Scanner(System.in);
	private kindsOfCar kindOfCar;
	private String carNumber;
	private long parkingTime; // 단위 : 분
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");
	private SimpleDateFormat printDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	public Car(String kindOfCar, String carNumber, String entryTime) {
		switch (kindOfCar) {
		case "c":
			this.kindOfCar = kindsOfCar.승용차;
			break;
		case "b":
			this.kindOfCar = kindsOfCar.버스;
			break;
		case "t":
			this.kindOfCar = kindsOfCar.트럭;
			break;
		}

		this.carNumber = carNumber;
		try {
			dateFormat.setLenient(false);
			entryDate = dateFormat.parse(entryTime);
		} catch (ParseException parseException) {
			System.out.printf("%nException: %s%n", parseException);
			System.out.println("오류 : 날짜 형식에 맞지 않은 입력 값입니다.");
		}

	}

	public abstract int calculateParkingFee();

	public abstract int calculateStandardTime();

	public long calculateParkingTime() throws ParseException {
		Date exitDate = null;

		System.out.println("출차시간을 입력하세요!");
		dateFormat.setLenient(false);
		exitDate = dateFormat.parse(scanner.nextLine());

		parkingTime = (exitDate.getTime() - entryDate.getTime()) / 60 / 1000; // 차이를 분으로 만듬.

		if (parkingTime < 0)
			throw new ArithmeticException("오류 : 출차시간이 입차시간보다 빠릅니다.");

		return parkingTime;

	}

	@Override
	public int compareTo(Car car1) {

		if (this.entryDate.getTime() - car1.entryDate.getTime() > 0)
			return 1;
		return -1;

	}

	@Override
	public String toString() {
		String printDate = printDateFormat.format(this.entryDate);
		return this.kindOfCar + " " + this.carNumber + " " + printDate;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public long getParkingTime() {
		return parkingTime;
	}
}
