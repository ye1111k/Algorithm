package 백준문제;

import java.util.*;

public class SWEA_5658 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		int N, K, a, index;
		String s, temp;
		
		int[] password;
		
		HashSet<String> set;
		
		for(int t=1;t<=T;t++) {
			N = input.nextInt();
			K = input.nextInt();
			
			s = input.next();
			s += s;
			
			set = new HashSet<String>();
			
			for(int i=0;i<N;i++) {
				temp = "";
				for(int j=i;j<i+N/4;j++) {
					temp += s.charAt(j);
				}
				set.add(temp);
			}
			
			password = new int[set.size()];
			index = 0;
			
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				temp = it.next();
				
				for(int i=N/4-1;i>=0;i--) {
					switch(temp.charAt(i)) {
					case 'A': 
						a = 10;
						break;
					case 'B':
						a = 11;
						break;
					case 'C':
						a = 12;
						break;
					case 'D':
						a = 13;
						break;
					case 'E':
						a = 14;
						break;
					case 'F':
						a = 15;
						break;
					default:
						a = temp.charAt(i)-'0';
						break;
					}
					
					password[index] += a*(int)Math.pow(16, N/4-i-1);
				}
				
				index++;
			}
			
			Arrays.sort(password);
			
			System.out.printf("#%d %d\n", t, password[set.size()-K]);
		}
	}

}
