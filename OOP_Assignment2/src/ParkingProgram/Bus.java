package ParkingProgram;

import ParkingProgram.Truck.kindsOfSize;

public class Bus extends Car {

	private int parkingTime = (int) this.getParkingTime();
	private int standardParkingTime = 0;
	private int parkingFee = 0;
	private kindsOfSize mySize;

	enum kindsOfSize {
		대형, 중형, 소형
	}

	public Bus(int capacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);

		if (capacity < 24)
			mySize = kindsOfSize.소형;
		else if (capacity < 40)
			mySize = kindsOfSize.중형;
		else
			mySize = kindsOfSize.대형;
	}

	@Override
	public int calculateParkingFee() {
		if (parkingTime < 60)
			parkingTime = 60;
		else if (parkingTime % 30 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 30) + 1) * 30;

		System.out.println("주차시간은 " + parkingTime / 60 + "시간 " + parkingTime % 30 + "분입니다.");

		parkingTime -= 60;
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

		while (standardParkingTime > 0) {
			standardParkingTime -= 30;
			switch (mySize) {
			case 대형:
				parkingFee += 2000;
				break;
			case 중형:
				parkingFee += 1500;
				break;
			case 소형:
				parkingFee += 1000;

			}
		}

		System.out.println("주차요금은 " + parkingFee + "원입니다.");

		return parkingFee;
	}

	// 사이즈에 따라 계산 달리.

}
