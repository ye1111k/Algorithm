import java.util.Scanner;

public class CF_71A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		String s,temp;
		
		for(int i=0;i<N;i++) {
			s=input.next();
			if(s.length()>10) {
				temp=Character.toString(s.charAt(0));
				temp+=Integer.toString(s.length()-2);
				temp+=Character.toString(s.charAt(s.length()-1));
				System.out.println(temp);
			}
			else System.out.println(s);
		}
	}

}
