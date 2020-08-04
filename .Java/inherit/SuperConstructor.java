class Car{
	int gasolineGauge;
	public Car(int gas){
		gasolineGauge = gas;
	}
}

class HybridCar extends Car{
	int electricGauge;
	public HybridCar(int gas, int electric){
		super(gas);
		electricGauge = electric;
	}
}


class WaterCar extends HybridCar{
	int waterGauge;
	public WaterCar(int gas, int electric, int water){
		super(gas, electric);
		waterGauge = water;
	}
	public void showCurrentGauge(){
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}


class  SuperConstructor{
	public static void main(String[] args) 	{
		WaterCar wc1 = new WaterCar(4, 2, 3);
		wc1.showCurrentGauge();
		WaterCar wc2 = new WaterCar(9, 5, 7);
		wc2.showCurrentGauge();
	}
}
