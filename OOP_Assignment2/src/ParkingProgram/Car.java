package ParkingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Car implements Comparable<Car> {

	enum kindsOfCar {
		�¿���, ����, Ʈ��
	}

	Scanner scanner = new Scanner(System.in);
	private kindsOfCar kindOfCar;
	private String carNumber;
	private long parkingTime; // ���� : ��
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");
	private SimpleDateFormat printDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	public Car(String kindOfCar, String carNumber, String entryTime) {
		switch (kindOfCar) {
		case "c":
			this.kindOfCar = kindsOfCar.�¿���;
			break;
		case "b":
			this.kindOfCar = kindsOfCar.����;
			break;
		case "t":
			this.kindOfCar = kindsOfCar.Ʈ��;
			break;
		}

		this.carNumber = carNumber;

		try {
			entryDate = dateFormat.parse(entryTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	abstract int calculateParkingFee();

	abstract int calculateStandardTime();

	public long calculateParkingTime() throws ParseException {
		Date exitDate = null;

			System.out.println("�����ð��� �Է��ϼ���!");
			exitDate = dateFormat.parse(scanner.nextLine());

			parkingTime = (exitDate.getTime() - entryDate.getTime()) / 60 / 1000; // ���̸� ������ ����.

			if (parkingTime < 0)
				throw new ArithmeticException("���� : �����ð��� �����ð����� �����ϴ�.");
			// ������ ������ �ȵǴµ� ���ͼ� ��� �ͼ���

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
