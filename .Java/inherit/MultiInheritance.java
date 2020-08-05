interface TV{
	public void onTV();
}

interface Computer{
	public void dataReceive();
}

class ComputerImpl{
	public void dataReceive() {System.out.println("���� ������ ���� ��");}
}

class TVImpl{
	public static void onTV(){System.out.println("���� ��� ��");}
}

class IPTV implements TV, Computer{
	ComputerImpl com = new ComputerImpl();
	public void onTV() {TVImpl.onTV();}
	public void dataReceive() {com.dataReceive();}
	public void powerOn(){
		dataReceive();
		onTV();
	}
}

class MultiInheritance{
	public static void main(String[] args){
		IPTV iptv = new IPTV();
		iptv.powerOn();

		TV tv = iptv;
		Computer com = iptv;
		
	}
}
