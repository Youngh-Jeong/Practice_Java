import java.util.*;

class  QueueEx{
	static Queue q = new LinkedList();
	// Queue�� �������̽��̹Ƿ� Queue�� ������ Ŭ���� LinkedList�� �̿��Ͽ� �ν��Ͻ� ����
	static final int MAX_SIZE = 5; // ������ ��ɾ��� �ִ� ������ ����

	public static void main(String[] args) {

		System.out.println("Help�� �Է��ϸ� ������ �� �� �ֽ��ϴ�.");

		while (true){
			System.out.println(" >> ");
			try{
				Scanner sc = new Scanner(System.in);
				String cmd = sc.nextLine().trim();
				// ����ڰ� �Է��� ��ɾ��� ���� ������ ���� �� ����
				if (cmd.equals("")) continue;
				// �Է��� ��ɾ ������ �Ʒ����� �������� �ʰ� �ٷ� �������� �ö�
				if (cmd.equalsIgnoreCase("q")){ // 'q'�� �Է�������
				// equalsIgnoreCase() : ���ڿ� �񱳽� ��ҹ��� ���о��� ��
					System.exit(0);
				} else if (cmd.equalsIgnoreCase("help")){
					System.out.println("help - ������ �����ݴϴ�.");
					System.out.println("q �Ǵ� Q - ���α׷��� �����մϴ�.");
					System.out.println("history - �ֱٿ� �Է��� ��ɾ " + MAX_SIZE + "�� �����ݴϴ�.");
				} else if (cmd.equalsIgnoreCase("history")){
					int i = 1;
					save(cmd);
					LinkedList tmp = (LinkedList)q;
					// q�� LinkedList�� ����ȯ
					// q�� ������ Queue�� ������ ������ LinkedList�� �����Ƿ� ����ȯ ����
					ListIterator it = tmp.listIterator();
					// List�������̽��� �޼ҵ��� listIterator()�� �����Ͽ� ListIterator�� ���Ϲ���(������ ������ ����)
					while (it.hasNext()){// ���� �����Ͱ� ������
						System.out.println(i + ". " + it.next());
						// next() : ���� ������ ����
						i++;
					}
				} else {
					save(cmd);
					System.out.println(cmd);
				}
			}
			catch (Exception e){
				System.out.println("�Է¿��� �Դϴ�.");
			}
		}
	}
	public static void save(String cmd){
		if (!cmd.equals("")) q.offer(cmd);
		// q�� �޾ƿ� ��ɾ� cmd�� ����
		if (q.size() > MAX_SIZE) q.remove();
		// q�� ����� ��ɾ��� ������ MAX_SIZE���� ������ ���� ������ ��ɾ �ϳ� ����
	}
}
