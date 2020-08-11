import java.util.*;

class HashSetEx{
	public static void main(String[] args){
		Object[] subArr = {"1",new Integer(1), "2", "2", "3", "3","4","4","4"};
		Set set = new HashSet();
		for (int i = 0;i < subArr.length ;i++ ){
			set.add(subArr[i]);
		}

		System.out.println(set); // [1, 1, 2, 3, 4]
	}
}
