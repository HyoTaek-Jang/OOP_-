package ParkingProgram;

public class Truck extends Car {

	private int parkingTime = (int) this.getParkingTime();
	private int standardParkingTime = 0;
	private int parkingFee = 0;
	private kindsOfSize mySize;

	enum kindsOfSize {
		대형, 중형, 소형
	}

	public Truck(int capacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);

		if (capacity < 5)
			mySize = kindsOfSize.소형;
		else if (capacity < 10)
			mySize = kindsOfSize.중형;
		else
			mySize = kindsOfSize.대형;
	}

	@Override
	public int calculateParkingFee() {
		if (parkingTime < 60)
			standardParkingTime = 60;
		else if (parkingTime % 60 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 60) + 1) * 60;

		System.out.println("주차시간은 " + parkingTime / 60 + "시간입니다.");

		while (standardParkingTime > 0) {
			standardParkingTime -= 60;
			switch (mySize) {
			case 대형:
				parkingFee += 4000;
				break;
			case 중형:
				parkingFee += 3000;
				break;
			case 소형:
				parkingFee += 2000;

			}
		}
		System.out.println("주차요금은 " + parkingFee + "원입니다.");
		return parkingFee;
	}

}
