class ClassMember{
	static int clsNum = 0;
	int instNum = 0;
	public ClassMember(){
		clsNum++;
		instNum++;
		System.out.println("clsNum : "+clsNum);	  // 1 2 3 
		System.out.println("instNum : "+instNum); // 1 1 1
	}
}

class  ClassMemberMain{
	public static void main(String[] args){
		ClassMember cm1 = new ClassMember();
		ClassMember cm2 = new ClassMember();
		ClassMember cm3 = new ClassMember();
	}
}
