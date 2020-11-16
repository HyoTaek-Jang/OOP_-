package ParkingProgram;

public class PassengerCar extends Car {

	private int parkingTime = (int) this.getParkingTime();
	private int standardParkingTime;
	private int parkingFee = 0;

	public PassengerCar(String kindOfCar, String carNumber, String entryTime) {
		super(kindOfCar, carNumber, entryTime);
	}

	@Override
	public int calculateParkingFee() {
		if (parkingTime < 30)
			standardParkingTime = 30;
		else if (parkingTime % 10 == 0)
			standardParkingTime = parkingTime;
		else
			standardParkingTime = ((parkingTime / 10) + 1) * 10;

		System.out.println("�����ð��� " + parkingTime / 60 + "�ð� " + parkingTime % 10 + "���Դϴ�.");

		standardParkingTime -= 30;
		parkingFee += 1000;
		while (standardParkingTime > 0) {
			standardParkingTime -= 10;
			parkingFee += 500;
		}
		System.out.println("��������� " + parkingFee + "���Դϴ�.");
		return parkingFee;
	}

//	@Override
//	public String toString() {
//		return "�¿���" + super.toString();
//	}
}
