package ParkingProgram;

public class Bus extends Car {

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

		return parkingFee;
	}

	@Override
	public int calculateStandardTime() {
		int parkingTime = (int) this.getParkingTime();

		if (parkingTime < 60)
			parkingTime = 60;
		else if (parkingTime % 30 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 30) + 1) * 30;
		return standardParkingTime;

	}


}
