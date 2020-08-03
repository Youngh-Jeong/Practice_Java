class BufferBuilder{
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer("AB");
		sb.append(25);
		sb.append('Y').append(true);
		System.out.println(sb); // AB25Ytrue

		sb.insert(2, false);
		sb.insert(sb.length(),'Z');
		System.out.println(sb); // ABfalse25YtrueZ

		sb.reverse();
		System.out.println(sb); // ZeurtY52eslafBA

		String str = "123-45-6789";
		// str�� ���� "123-456789"�� �����Ŵ(StringBuilder ���)
		StringBuilder builder = new StringBuilder(str);
		builder.deleteCharAt(builder.lastIndexOf("-")); //6
		str = builder.toString();
		System.out.println(str); // 
	}
}
