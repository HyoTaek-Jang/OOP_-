package ParkingProgram;

import java.text.ParseException;

public class PassengerCar extends Car {

	private int standardParkingTime;
	private int parkingFee = 0;

	public PassengerCar(String kindOfCar, String carNumber, String entryTime) throws ParseException {
		super(kindOfCar, carNumber, entryTime);
	}

	@Override
	public int calculateStandardTime() {
		int parkingTime = (int) this.getParkingTime();

		if (parkingTime < 30)
			standardParkingTime = 30;
		else if (parkingTime % 10 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 10) + 1) * 10;
		return standardParkingTime;
	}

	@Override
	public int calculateParkingFee() {
		standardParkingTime -= 30;
		parkingFee += 1000;

		while (standardParkingTime > 0) {
			standardParkingTime -= 10;
			parkingFee += 500;
		}
		return parkingFee;
	}

}
