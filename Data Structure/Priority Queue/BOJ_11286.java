package 백준문제;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class BOJ_11286 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int temp;
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		
		for(int i=0;i<N;i++) {
			temp=input.nextInt();
			if(temp==0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.remove());
			}
			else pq.add(temp);
		}
	}

}
