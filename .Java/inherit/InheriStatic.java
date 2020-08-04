class Aa{
	static int num = 0;
}

class Bb extends Aa{
	public void showNum(){
		System.out.println("num : " + num);
	}
}

class InheriStatic{
	public static void main(String[] args) {
		Aa.num++;
		Bb.num++;
		Bb b = new Bb();
		b.showNum();
	}
}
