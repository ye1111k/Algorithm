package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_3665 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int T=Integer.parseInt(s);
		
		int n,m,a,b,cnt,temp;
		int [] arr;
		int [] grade;
		ArrayList<Integer> [] indegree;
		boolean ck;
		
		for(int t=0;t<T;t++) {
			s=br.readLine();
			n=Integer.parseInt(s);
			
			arr=new int[n+1];
			grade=new int[n+1];
			indegree=new ArrayList[n+1];//i번째 노드로 들어가는 노드를 저장하는 ArrayList
			ck=false;
			
			s=br.readLine();
			st=new StringTokenizer(s);
			
			for(int i=1;i<=n;i++) {//등수 저장
				arr[i]=Integer.parseInt(st.nextToken());
				grade[arr[i]]=i;
				indegree[i]=new ArrayList<Integer>();
			}
			
			for(int i=n;i>1;i--) {
				for(int j=i-1;j>=1;j--) {
					indegree[arr[i]].add(arr[j]);//각 노드의 진입차수 계산
				}
			}
			
			s=br.readLine();
			m=Integer.parseInt(s);
			for(int i=0;i<m;i++) {
				s=br.readLine();
				st=new StringTokenizer(s);
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				
				if(grade[a]>grade[b]) {//작년 a의 등수가 더 낮을 경우
					temp=indegree[a].indexOf(b);
					indegree[a].remove(temp);
					indegree[b].add(a);
				}
				else {//작년 b의 등수가 더 낮을 경우
					temp=indegree[b].indexOf(a);
					indegree[b].remove(temp);
					indegree[a].add(b);
				}
			}
			
			s="";
			for(int i=0;i<n;i++) {
				cnt=0;
				for(int j=1;j<=n;j++) {
					if(indegree[j].size()==i) {
						s+=Integer.toString(j)+" ";
						cnt++;
					}
				}
				if(cnt!=1) ck=true; //cnt가 1이 아니라는 것은 비정상적인 경우
			}
			
			if(ck) System.out.println("IMPOSSIBLE");//비정상적인 경우
			else System.out.println(s);
		}
	}

}
