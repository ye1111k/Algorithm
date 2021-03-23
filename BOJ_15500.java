package 백준문제;

import java.util.*;

public class BOJ_15500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int K=0,a;
		
		LinkedList<Integer> Stack1=new LinkedList<Integer>();
		LinkedList<Integer> Stack2=new LinkedList<Integer>();
		ArrayList<int []> answer=new ArrayList<int []>();
		
		for(int i=0;i<N;i++) {
			a=input.nextInt();
			Stack1.addLast(a);
		}
		
		int [] temp;
		int now=N;
		
		while(true) {
			if(now==0) break;
			
			if(Stack1.contains(now)) {
				while(true) {
					a=Stack1.removeLast();
					temp=new int[2];
					temp[0]=1;
					K++;
					if(a==now) {
						temp[1]=3;
						answer.add(temp);
						break;
					}
					temp[1]=2;
					answer.add(temp);
					Stack2.addLast(a);
				}
			}
			else {
				while(true) {
					a=Stack2.removeLast();
					temp=new int[2];
					temp[0]=2;
					K++;
					if(a==now) {
						temp[1]=3;
						answer.add(temp);
						break;
					}
					temp[1]=1;
					answer.add(temp);
					Stack1.addLast(a);
				}
			}
			now--;
		}
		System.out.println(K);
		for(int i=0;i<answer.size();i++) {
			temp=answer.get(i);
			System.out.println(temp[0]+" "+temp[1]);
		}
		
	}

}
