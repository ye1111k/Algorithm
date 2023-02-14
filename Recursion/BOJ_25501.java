package 백준문제;

import java.util.*;

public class BOJ_25501 {
	public static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int T = Integer.parseInt(input.nextLine());
		
		String s;
		int a;
		
		for(int i=0;i<T;i++) {
			s = input.nextLine();
			
			n = 0;
			a = isPalindrome(s);
			
			System.out.println(a + " " + n);
		}
	}
	
	public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
        	n++;
        	return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
    	n++;
        return recursion(s, 0, s.length()-1);
    }

}
