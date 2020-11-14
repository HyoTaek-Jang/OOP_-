package ParkingProgram;

public class ElectronicPassengerCar extends PassengerCar {
	
	int currentCapacity;
	
	public ElectronicPassengerCar(int currentCapacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
		this.currentCapacity = currentCapacity;
	}
	//충전량, 충전금액 계산 이런것만 추가하면 될듯.
}
