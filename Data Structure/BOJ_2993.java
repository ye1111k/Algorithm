package 백준문제;
import java.util.*;
public class BOJ_2993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String str=input.next();
		
		String answer="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		String temp;
		
		
		int len=str.length();
		
		for(int i=0;i<len-2;i++) {
			for(int j=i+1;j<len-1;j++) {
				temp="";
				for(int k=i;k>=0;k--)
					temp+=str.charAt(k);
				for(int k=j;k>i;k--) 
					temp+=str.charAt(k);
				for(int k=len-1;k>j;k--)
					temp+=str.charAt(k);
				if(temp.compareTo(answer)<0) answer=temp; 
			}
		}
		System.out.println(answer);
	}

}
