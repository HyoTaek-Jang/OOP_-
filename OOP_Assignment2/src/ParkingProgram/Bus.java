package ParkingProgram;

public class Bus extends Car {

	private int standardParkingTime = 0;
	private int parkingFee = 0;
	private kindsOfSize mySize;

	enum kindsOfSize {
		����, ����, ����
	}

	public Bus(int capacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);

		if (capacity < 24)
			mySize = kindsOfSize.����;
		else if (capacity < 40)
			mySize = kindsOfSize.����;
		else
			mySize = kindsOfSize.����;
	}

	@Override
	public int calculateParkingFee() {
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

		while (standardParkingTime > 0) {
			standardParkingTime -= 30;
			switch (mySize) {
			case ����:
				parkingFee += 2000;
				break;
			case ����:
				parkingFee += 1500;
				break;
			case ����:
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
