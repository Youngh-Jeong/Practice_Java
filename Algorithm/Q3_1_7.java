import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q3_1_7{
	public static void main(String[] args) {
		// 내림차순일 때 특정 시력을 가진 사람을 검색하는 프로그램
		Scanner input = new Scanner(System.in);
		PhyscData[] x ={
				new PhyscData("이수민", 175, 2.0),
				new PhyscData("홍준기", 171, 1.5),
				new PhyscData("이호연", 174, 1.2),
				new PhyscData("김한결", 169, 0.8),
				new PhyscData("전서현", 173, 0.7),
				new PhyscData("유지훈", 168, 0.4),
				new PhyscData("이나령", 162, 0.3)
		};
		System.out.println("찾는 시력 : ");
		double vision = input.nextDouble();
		int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.HEIGHT_ORDER);
		if (idx<0) {System.out.println("요소가 없습니다.");}
		else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
	static class PhyscData{
		private String name;
		private int height;
		private double vision;
		public PhyscData(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		}
		public String toString() {
			return name + " " + height + " "+vision;
		}
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision < d2.vision) ? 1 :
					   (d1.vision > d2.vision) ? -1 : 0; 
			}
		}
	}
}
