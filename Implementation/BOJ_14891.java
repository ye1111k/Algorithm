package 백준문제;

import java.util.*;

public class BOJ_14891 {
	public static int solution(String w1, String w2, String w3, String w4, int K, int [][] arr) {
		int answer = 0;
		
		LinkedList<Integer> wheel1 = new LinkedList<Integer>();
		LinkedList<Integer> wheel2 = new LinkedList<Integer>();
		LinkedList<Integer> wheel3 = new LinkedList<Integer>();
		LinkedList<Integer> wheel4 = new LinkedList<Integer>();
		
		for(int i=0;i<8;i++) {
			wheel1.addLast(w1.charAt(i)-'0');
			wheel2.addLast(w2.charAt(i)-'0');
			wheel3.addLast(w3.charAt(i)-'0');
			wheel4.addLast(w4.charAt(i)-'0');
		}
		
		for(int i=0;i<K;i++) {
			if(arr[i][0]==1) {
				if(arr[i][1]==1) {
					if(wheel1.get(2)!=wheel2.get(6)) {
						if(wheel2.get(2)!=wheel3.get(6)) {
							if(wheel3.get(2)!=wheel4.get(6)) {
								wheel4.addLast(wheel4.removeFirst()); //반시계 방향
							}
							wheel3.addFirst(wheel3.removeLast()); //시계 방향
						}
						wheel2.addLast(wheel2.removeFirst()); //반시계 방향
					}
					wheel1.addFirst(wheel1.removeLast()); //시계 방향
				}
				else {
					if(wheel1.get(2)!=wheel2.get(6)) {
						if(wheel2.get(2)!=wheel3.get(6)) {
							if(wheel3.get(2)!=wheel4.get(6)) {
								wheel4.addFirst(wheel4.removeLast()); //시계 방향
							}
							wheel3.addLast(wheel3.removeFirst()); //반시계 방향
						}
						wheel2.addFirst(wheel2.removeLast()); //시계 방향
					}
					wheel1.addLast(wheel1.removeFirst()); //반시계 방향
				}
			}
			else if(arr[i][0]==2) {
				if(arr[i][1]==1) {
					if(wheel2.get(6)!=wheel1.get(2)) wheel1.addLast(wheel1.removeFirst()); //반시계 방향
					if(wheel2.get(2)!=wheel3.get(6)) {
						if(wheel3.get(2)!=wheel4.get(6)) wheel4.addFirst(wheel4.removeLast()); //시계 방향
						wheel3.addLast(wheel3.removeFirst()); //반시계 방향
					}
					wheel2.addFirst(wheel2.removeLast()); //시계 방향
				}
				else {
					if(wheel2.get(6)!=wheel1.get(2)) wheel1.addFirst(wheel1.removeLast()); //시계 방향
					if(wheel2.get(2)!=wheel3.get(6)) {
						if(wheel3.get(2)!=wheel4.get(6)) wheel4.addLast(wheel4.removeFirst()); //반시계 방향
						wheel3.addFirst(wheel3.removeLast()); //시계 방향
					}
					wheel2.addLast(wheel2.removeFirst()); //반시계 방향
				}
			}
			else if(arr[i][0]==3) {
				if(arr[i][1]==1) {
					if(wheel3.get(2)!=wheel4.get(6)) wheel4.addLast(wheel4.removeFirst()); //반시계 방향
					if(wheel3.get(6)!=wheel2.get(2)) {
						if(wheel2.get(6)!=wheel1.get(2)) wheel1.addFirst(wheel1.removeLast()); //시계 방향
						wheel2.addLast(wheel2.removeFirst()); //반시계 방향
					}
					wheel3.addFirst(wheel3.removeLast()); //시계 방향
				}
				else {
					if(wheel3.get(2)!=wheel4.get(6)) wheel4.addFirst(wheel4.removeLast()); //시계 방향
					if(wheel3.get(6)!=wheel2.get(2)) {
						if(wheel2.get(6)!=wheel1.get(2)) wheel1.addLast(wheel1.removeFirst()); //반시계 방향
						wheel2.addFirst(wheel2.removeLast()); //시계 방향
					}
					wheel3.addLast(wheel3.removeFirst()); //반시계 방향
				}
			}
			else {
				if(arr[i][1]==1) {
					if(wheel4.get(6)!=wheel3.get(2)) {
						if(wheel3.get(6)!=wheel2.get(2)) {
							if(wheel2.get(6)!=wheel1.get(2)) {
								wheel1.addLast(wheel1.removeFirst()); //반시계 방향
							}
							wheel2.addFirst(wheel2.removeLast()); //시계 방향
						}
						wheel3.addLast(wheel3.removeFirst()); //반시계 방향
					}
					wheel4.addFirst(wheel4.removeLast()); //시계 방향
				}
				else {
					if(wheel4.get(6)!=wheel3.get(2)) {
						if(wheel3.get(6)!=wheel2.get(2)) {
							if(wheel2.get(6)!=wheel1.get(2)) {
								wheel1.addFirst(wheel1.removeLast()); //시계 방향
							}
							wheel2.addLast(wheel2.removeFirst()); //반시계 방향
						}
						wheel3.addFirst(wheel3.removeLast()); //시계 방향
					}
					wheel4.addLast(wheel4.removeFirst()); //반시계 방향
				}
			}
		}
		
		if(wheel1.getFirst()==1) answer += 1;
		if(wheel2.getFirst()==1) answer += 2;
		if(wheel3.getFirst()==1) answer += 4;
		if(wheel4.getFirst()==1) answer += 8;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String w1 = input.nextLine();
		String w2 = input.nextLine();
		String w3 = input.nextLine();
		String w4 = input.nextLine();
		
		int K = Integer.parseInt(input.nextLine());
		
		int [][] arr = new int[K][2];
		
		StringTokenizer st;
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(input.nextLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(w1, w2, w3, w4, K, arr));
		
	}

}
