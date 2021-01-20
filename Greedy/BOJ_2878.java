//노가다 코드입니다.
package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2878 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		long answer=0,gap,temp;
		int ck,temp1;
		boolean c;
		long a=(long) Math.pow(2,64); //2^64
		
		long [] candy=new long[N+1];
		
		for(int i=0;i<N;i++) { 
			s=br.readLine();
			candy[i]=Long.parseLong(s);
		}
		
		Arrays.sort(candy);
		
		while(true) {
			if(M==0) break;//더 나눠줄 사탕이 없을 때
			if(candy[N]<=0) break;
			
			
			c=false; //ck==N/2까지 돌았을 경우 체크
			temp=candy[N];//제일 많은 사탕을 원하는 아이
			
			//최대값이 어디까지인지(?) 체크
			for(ck=N-1;ck>=N/2;ck--) {//원래 1까지 가야하는데 반으로 줄임
				if(candy[ck]!=temp) {
					c=true;
					break;
				}
				if(candy[N-ck]==temp) {
					temp1=N-ck-1;
					ck=temp1;
					c=true;
					break;
				}
			}
			if(candy[ck]==0&&c) {//(현재 시점)친구들이 원하는 사탕의 개수가 모두 같을 때
				gap=M/(N-ck);
				temp=candy[N]-gap;
				for(int i=0;i<N-ck;i++)
					candy[N-i]=temp;
				M-=gap*(N-ck);
				for(int i=0;i<M;i++)
					candy[N-i]--;
				M=0;
			}
			else{
				gap=candy[N]-candy[ck];//최대 사탕개수와 그 다음 큰 사탕 개수 차이 계산
				if(gap*(N-ck)>M) gap=M/(N-ck);//조건에 따라 gap 다시 계산
				temp=candy[N]-gap;
				for(int i=0;i<N-ck;i++)
					candy[N-i]=temp;
				M-=gap*(N-ck);
				if(M<=(N-ck)) {//남은 사탕의 개수가 최대 사탕개수 원하는 친구들 수보다 적을 떄
					for(int i=0;i<M;i++)
						candy[N-i]--;
					M=0;
				}
			}
			
		}
		
		for(int i=1;i<=N;i++) {//분노의 합 계산
			if(candy[i]>0) {
				answer+=candy[i]*candy[i];
				answer%=a;
			}
				
		}
		
		System.out.println(answer);//출력~
	}

}
