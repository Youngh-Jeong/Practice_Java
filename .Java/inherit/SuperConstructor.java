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
		System.out.println("�ܿ� ���ָ� : " + gasolineGauge);
		System.out.println("�ܿ� ���ⷮ : " + electricGauge);
		System.out.println("�ܿ� ���ͷ� : " + waterGauge);
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
