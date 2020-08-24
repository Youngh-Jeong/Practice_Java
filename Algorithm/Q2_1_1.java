class Q2_1_1{
	public static void main(String[] args) {
		// 랜덤 사람수, 랜덤키 세팅 후 최대값 출력
		System.out.println("키의 최댓값을 구합니다.");
		int num = (int)(Math.random()*100)+1;
		System.out.println("사람 수 : " + num);
		int[] height = new int[num];
		for (int i = 0; i<height.length;i++) {
			height[i] = 100 + (int)(Math.random()*60+30);
			System.out.println("height[" + i + "] : " + height[i]);
		}
		System.out.println("최대값은 " + MaxOfArrayRand(height));

	}
	public static int MaxOfArrayRand(int[] a) { // 최대키 메소드
		int max = a[0];
		for (int i = 1; i<a.length;i++) {
			if (max<a[i]) {
				max = a[i];
			}
		}
		return max;
	}
}
