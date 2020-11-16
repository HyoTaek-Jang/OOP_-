package ParkingProgram;

public class Truck extends Car {

	private int parkingTime = (int) this.getParkingTime();
	private int standardParkingTime = 0;
	private int parkingFee = 0;
	private kindsOfSize mySize;

	enum kindsOfSize {
		����, ����, ����
	}

	public Truck(int capacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);

		if (capacity < 5)
			mySize = kindsOfSize.����;
		else if (capacity < 10)
			mySize = kindsOfSize.����;
		else
			mySize = kindsOfSize.����;
	}

	@Override
	public int calculateParkingFee() {
		if (parkingTime < 60)
			standardParkingTime = 60;
		else if (parkingTime % 60 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 60) + 1) * 60;

		System.out.println("�����ð��� " + parkingTime / 60 + "�ð��Դϴ�.");

		while (standardParkingTime > 0) {
			standardParkingTime -= 60;
			switch (mySize) {
			case ����:
				parkingFee += 4000;
				break;
			case ����:
				parkingFee += 3000;
				break;
			case ����:
				parkingFee += 2000;

			}
		}
		System.out.println("��������� " + parkingFee + "���Դϴ�.");
		return parkingFee;
	}

}
