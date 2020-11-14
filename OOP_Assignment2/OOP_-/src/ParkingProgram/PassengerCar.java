package ParkingProgram;

public class PassengerCar extends Car implements UtilMethods {

	public PassengerCar(String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
	}

	@Override
	public int calculateOnStandard() {
		return 0;
	}

	@Override
	public int calculateParkingFee() {
		return 0;
	}

//	@Override
//	public String toString() {
//		return "½Â¿ëÂ÷" + super.toString();
//	}
}
