package ParkingProgram;

public class ElectronicPassengerCar extends PassengerCar {
	final int MAXCAPACITY = 60;
	double currentCapacity=0;
	int chargingFee=0;
	
	public ElectronicPassengerCar(int currentCapacity, String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
		this.currentCapacity = currentCapacity;
	}
	//������, �����ݾ� ��� �̷��͸� �߰��ϸ� �ɵ�.
	//������ �� ����Ʈ�Ҷ� �ð� �޾Ƽ� �� ���Ϲ����� �����ϰ� �� �ø��� �����ų� �ð� ������ �극��ũ�� �ϴ°� ������
	public int calculateChargingFee(long parkingTime) {
		while(parkingTime>0 &&currentCapacity!=MAXCAPACITY) {
			parkingTime--;
			currentCapacity+=0.2;
			chargingFee += 60;
			
		}
		return chargingFee;
		
	}
	
}
