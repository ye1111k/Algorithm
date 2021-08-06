package 백준문제;

import java.util.*;
import java.io.*;
class Flower{
	int startM;
	int startD;
	int endM;
	int endD;
	
	public Flower(int startM, int startD, int endM, int endD) {
		this.startM = startM;
		this.startD = startD;
		this.endM = endM;
		this.endD = endD;
	}
}

public class BOJ_2457 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Flower> arr = new ArrayList<Flower>();
		
		StringTokenizer st;
		
		int sm,sd,em,ed;
		int minsm = 12, minsd = 31;
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			sm = Integer.parseInt(st.nextToken());
			sd = Integer.parseInt(st.nextToken());
			em = Integer.parseInt(st.nextToken());
			ed = Integer.parseInt(st.nextToken());
			
			if((sm<minsm)||((sm==minsm)&&(sd<minsd))) {
				minsm = sm;
				minsd = sd;
			}
			
			if(sm==em&&sd==ed) continue; //피는날이랑 지는 날 같은 꽃은 넘어가기
			
			arr.add(new Flower(sm, sd, em, ed));
		}
		
		Collections.sort(arr, new Comparator<Flower>() { //지는 날짜가 늦은 순으로 정렬, 지는 날짜가 같을 경우 피는 날짜 빠픈 꽃이 앞
			public int compare(Flower o1, Flower o2) {
				if(o1.endM==o2.endM) {
					if(o1.endD==o2.endD) {
						if(o1.startM==o2.startM)
							return o1.startD-o2.startD;
						return o1.startM-o2.startM;
					}
					return o1.endD-o2.endD;
				}
				return o1.endM-o2.endM;
			}
		});
		
		int ans = 0;
		Flower temp1, temp3, temp2 = new Flower(1,1,1,1); //temp1은 현재 보고있는 꽃, temp2는 가장 최근에 선택한 꽃
		
		if(arr.get(arr.size()-1).endM<12 || minsm>3 || (minsm==3 && minsd != 1)) //지는 날짜가 제일 늦는 꽃이 12월보다 빨리 지면 11월 30일까지 꽃이 피어있을 수 없음 , 피는 날짜가 가장 빠른 꽃이 3월보다 늦게 피면 3월 1일부터 꽆이 피어있을 수 없음
			System.out.println(0);
		
		else {
			int f = arr.size();
			arr.add(new Flower(1,1,1,1));
			
			int now = -1;
			
			for(int i=0;i<f;i++)
				if(first(arr.get(i))) now = i;
			
			if(now>=0) {
				ans++;
				temp2 = arr.get(now);
			}
			
			if(temp2.endM==12) System.out.println(1);
			else {
				int temp;
				boolean tf=false;
				while(true) {
					temp=now;
					for(int i=now+1;i<f;i++)
						if(ck(arr.get(i),temp2)) temp = i;
					
					if(temp==now) break;
					
					now = temp;
					temp2 = arr.get(now);
					ans++;
					if(temp2.endM==12) {
						tf = true;
						break;
					}
				}
				if(tf) System.out.println(ans);
				else System.out.println(0);
				
			}
			
			
			
			;
			
			
		}
		
	}
	public static boolean ck(Flower f1, Flower f2) {
		if(f2.endM<f1.endM) {
			if(f1.startM<f2.endM) return true;
			if(f1.startM == f2.endM && f1.startD <= f2.endD) return true; 
				
		}
		if(f2.endM == f1.endM && f2.endD < f1.endD) { 
			if(f1.startM<f2.endM) return true;
			if(f1.startM == f2.endM && f1.startD <= f2.endD) return true;
		}
		return false;
	}
	
	public static boolean first(Flower f) {
		if(f.startM<3) return true;
		if(f.startM==3&&f.startD==1) return true;
		return false;
	}

}
