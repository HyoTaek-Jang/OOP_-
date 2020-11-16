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

		System.out.println("주차시간은 " + parkingTime / 60 + "시간 " + parkingTime % 10 + "분입니다.");

		standardParkingTime -= 30;
		parkingFee += 1000;
		while (standardParkingTime > 0) {
			standardParkingTime -= 10;
			parkingFee += 500;
		}
		System.out.println("주차요금은 " + parkingFee + "원입니다.");
		return parkingFee;
	}

//	@Override
//	public String toString() {
//		return "승용차" + super.toString();
//	}
}
