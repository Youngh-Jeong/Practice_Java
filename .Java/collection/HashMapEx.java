import java.util.*;

class HashMapEx{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("test", "1234");
		map.put("abcd", "1111");
		map.put("abcd", "1234");

		Scanner sc = new Scanner(System.in);

		while (true){
			System.out.println("ID�� Password�� �Է��ϼ���.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();

			System.out.print("Password : ");
			String pwd = sc.nextLine().trim();
			System.out.println();

			if (!map.containsKey(id)){
			System.out.println("���� ���̵� �Դϴ�.");
			continue;
			}
			if (!(map.get(id)).equals(pwd)){
				System.out.println("Ʋ�� ��й�ȣ �Դϴ�.");
				continue;
			}
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		}
	}
}
