package ParkingProgram;

public class ElectronicPassengerCar extends PassengerCar {
	
	int currentCapacity;
	
	public ElectronicPassengerCar(int currentCapacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
		this.currentCapacity = currentCapacity;
	}
	//������, �����ݾ� ��� �̷��͸� �߰��ϸ� �ɵ�.
}
