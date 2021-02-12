import java.util.Scanner;

public class CF_4A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int w=input.nextInt();
		if((w-2)%2==0&&w>2) System.out.println("YES");
		else System.out.println("NO");
	}

}
