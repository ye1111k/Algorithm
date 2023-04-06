package 백준문제;

import java.util.*;
class FireBall{
	private int r;
	private int c;
	private int m;
	private int s;
	private int d;
	
	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
	
	public int getR() {
		return this.r;
	}
	
	public int getC() {
		return this.c;
	}
	
	public int getM() {
		return this.m;
	}
	
	public int getS() {
		return this.s;
	}
	
	public int getD() {
		return this.d;
	}
	
	public void setR(int newR) {
		this.r = newR;
	}
	
	public void setC(int newC) {
		this.c = newC;
	}

	public void setM(int newM) {
		this.m = newM;
	}
	
	public void setS(int newS) {
		this.s = newS;
	}
	
	public void setD(int newD) {
		this.d = newD;
	}
}


public class BOJ_20056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int [] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int N = input.nextInt();
		int M = input.nextInt();
		int K = input.nextInt();
		
		int [][] square = new int[N+1][N+1];
		
		ArrayList<FireBall> fireBalls = new ArrayList<FireBall>();
		
		int r, c, m, s, d;
		
		for(int i=0;i<M;i++) {
			r = input.nextInt();
			c = input.nextInt();
			m = input.nextInt();
			s = input.nextInt();
			d = input.nextInt();
		
			fireBalls.add(new FireBall(r,c,m,s,d));
		}
		
		FireBall temp;
		int tempR, tempC, tempM, tempS, tempD, count, newM, newS;
		
		int a;
		
		boolean ckD;
		ArrayList<Integer> rem;
		
		for(int k=0;k<K;k++) {
			square = new int[N+1][N+1]; //격자 초기화
			
			//파이어볼 이동(1번 과정)
			for(FireBall f:fireBalls) {
				r = f.getR();
				c = f.getC();
				m = f.getM();
				s = f.getS();
				d = f.getD();
				
				tempR = r;
				tempC = c;
				
				for(int j=0;j<s;j++) {
					tempR += dr[d];
					tempC += dc[d];
					
					if(tempR==0) tempR = N;
					if(tempC==0) tempC = N;
					if(tempR==N+1) tempR = 1;
					if(tempC==N+1) tempC = 1;
				}
				
				f.setR(tempR);
				f.setC(tempC);
				
				square[tempR][tempC]++; //칸별 파이어볼 개수 카운트
			}
			
			//2번 과정
			for(int x=1;x<=N;x++) {
				for(int y=1;y<=N;y++) {
					if(square[x][y]>=2) { //2개 이상의 파이어볼이 있는 칸일 경우
						tempM = 0;
						tempS = 0;
						tempD = 0;
						count = 0;
						ckD = true;
						
						rem = new ArrayList<Integer>(); //합칠 파이어볼 정보 저장할 리스트
						
						for(int i=0;i<fireBalls.size();i++) {
							temp = fireBalls.get(i);
							
							r = temp.getR();
							c = temp.getC();
							
							if(r==x && c==y) {
								count++;
								tempM += temp.getM();
								tempS += temp.getS();
								if(count != 1) {
									if(tempD%2 != temp.getD()%2) ckD = false; //합쳐지는 파이어볼의 방향이 모두 홀수거나 짝수인지 체크
								}
								tempD = temp.getD();
								
								rem.add(i);
							}
						}
						
						
						
						for(int i=rem.size()-1;i>=0;i--) { //뒤부터 지우기
							a = rem.get(i);
							
							fireBalls.remove(a);
						}
							
						newM = tempM/5;
						newS = tempS/count;
						
						if(newM==0) continue; //질량이 0인 파이어볼이 되었을 경우
						
						
						//파이어볼 나누기
						if(ckD) { //합쳐지는 파이어볼의 방향이 모두 홀수거나 짝수였을 경우
							fireBalls.add(new FireBall(x, y, newM, newS, 0));
							fireBalls.add(new FireBall(x, y, newM, newS, 2));
							fireBalls.add(new FireBall(x, y, newM, newS, 4));
							fireBalls.add(new FireBall(x, y, newM, newS, 6));
						}
						else { //아닌 경우
							fireBalls.add(new FireBall(x, y, newM, newS, 1));
							fireBalls.add(new FireBall(x, y, newM, newS, 3));
							fireBalls.add(new FireBall(x, y, newM, newS, 5));
							fireBalls.add(new FireBall(x, y, newM, newS, 7));							
						}
						
					}
				}
			}
			
		}
		
		int answer = 0;
		
		for(FireBall f:fireBalls) 
			answer += f.getM();
			
		System.out.println(answer);
	}

}
