package ParkingProgram;

import java.text.ParseException;

public class ElectronicPassengerCar extends PassengerCar {
	final int MAXCAPACITY = 60;
	double currentCapacity = 0;
	int chargingFee = 0;

	public ElectronicPassengerCar(int currentCapacity, String kindOfCar, String carNumber, String entryTime) throws ParseException {
		super(kindOfCar, carNumber, entryTime);
		this.currentCapacity = currentCapacity;
	}

	public int calculateChargingFee(long parkingTime) {
		while (parkingTime > 0 && currentCapacity < MAXCAPACITY) {
			parkingTime--;
			currentCapacity += 0.2;
			chargingFee += 60;

		}
		return chargingFee;
	}

}
