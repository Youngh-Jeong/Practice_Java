import java.util.*;

class HashMapEx{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("test", "1234");
		map.put("abcd", "1111");
		map.put("abcd", "1234");

		Scanner sc = new Scanner(System.in);

		while (true){
			System.out.println("ID와 Password를 입력하세요.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();

			System.out.print("Password : ");
			String pwd = sc.nextLine().trim();
			System.out.println();

			if (!map.containsKey(id)){
			System.out.println("없는 아이디 입니다.");
			continue;
			}
			if (!(map.get(id)).equals(pwd)){
				System.out.println("틀린 비밀번호 입니다.");
				continue;
			}
			System.out.println("로그인에 성공하였습니다.");
		}
	}
}
