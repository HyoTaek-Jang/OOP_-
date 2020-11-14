package ParkingProgram;

public class Bus extends Car implements UtilMethods {

	enum kindsOfSize {
		대형, 중형, 소형
	}

	public Bus(int parseInt, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
	}

	// 사이즈에 따라 계산 달리.
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
//		return "버스" + super.toString();
//	}
}
