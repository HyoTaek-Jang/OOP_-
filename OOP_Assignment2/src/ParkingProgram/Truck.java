package ParkingProgram;

public class Truck extends Car implements UtilMethods {

	enum kindsOfSize {
		����, ����, ����
	}

	public Truck(int parseInt, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
	}

	// ����� ���� ��� �޸�.
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
//		return "Ʈ��" + super.toString();
//	}
}
