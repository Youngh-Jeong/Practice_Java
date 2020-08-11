import java.util.*;

class  QueueEx{
	static Queue q = new LinkedList();
	// Queue는 인터페이스이므로 Queue를 구현한 클래스 LinkedList를 이용하여 인스턴스 생성
	static final int MAX_SIZE = 5; // 저장할 명령어의 최대 개수를 지정

	public static void main(String[] args) {

		System.out.println("Help를 입력하면 도움말을 볼 수 있습니다.");

		while (true){
			System.out.println(" >> ");
			try{
				Scanner sc = new Scanner(System.in);
				String cmd = sc.nextLine().trim();
				// 사용자가 입력한 명령어의 양쪽 공백을 없앤 후 받음
				if (cmd.equals("")) continue;
				// 입력한 명령어가 없으면 아래쪽을 실행하지 않고 바로 조건으로 올라감
				if (cmd.equalsIgnoreCase("q")){ // 'q'를 입력했으면
				// equalsIgnoreCase() : 문자열 비교시 대소문자 구분없이 비교
					System.exit(0);
				} else if (cmd.equalsIgnoreCase("help")){
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다.");
					System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				} else if (cmd.equalsIgnoreCase("history")){
					int i = 1;
					save(cmd);
					LinkedList tmp = (LinkedList)q;
					// q를 LinkedList로 형변환
					// q의 선언은 Queue로 했지만 생성은 LinkedList로 했으므로 형변환 가능
					ListIterator it = tmp.listIterator();
					// List인터페이스의 메소드인 listIterator()를 실행하여 ListIterator를 리턴받음(루프를 돌리기 위해)
					while (it.hasNext()){// 다음 데이터가 있으면
						System.out.println(i + ". " + it.next());
						// next() : 다음 데이터 리턴
						i++;
					}
				} else {
					save(cmd);
					System.out.println(cmd);
				}
			}
			catch (Exception e){
				System.out.println("입력오류 입니다.");
			}
		}
	}
	public static void save(String cmd){
		if (!cmd.equals("")) q.offer(cmd);
		// q에 받아온 명령어 cmd를 저장
		if (q.size() > MAX_SIZE) q.remove();
		// q에 저장된 명령어의 개수가 MAX_SIZE보다 많으면 가장 오래된 명령어를 하나 삭제
	}
}
