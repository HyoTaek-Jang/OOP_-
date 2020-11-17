package ParkingProgram;

public class ElectronicPassengerCar extends PassengerCar {
	final int MAXCAPACITY = 60;
	double currentCapacity=0;
	int chargingFee=0;
	
	public ElectronicPassengerCar(int currentCapacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
		this.currentCapacity = currentCapacity;
	}
	//충전량, 충전금액 계산 이런것만 추가하면 될듯.
	//충전은 그 엑시트할때 시간 받아서 걍 와일문으로 충전하고 돈 올리고 꽉차거나 시간 끝나면 브레이크로 하는게 나을듯
	public int calculateChargingFee(long parkingTime) {
		while(parkingTime>0 &&currentCapacity!=MAXCAPACITY) {
			parkingTime--;
			currentCapacity+=0.2;
			chargingFee += 60;
			
		}
		return chargingFee;
		
	}
	
}
