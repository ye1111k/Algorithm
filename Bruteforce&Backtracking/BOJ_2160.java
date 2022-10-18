package 백준문제;

import java.io.*;

public class BOJ_2160 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][][] picture = new int[N+1][5][7];
		
		String s;
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<5;j++) {
				s = br.readLine();
				for(int k=0;k<7;k++) {
					if(s.charAt(k)=='.') picture[i][j][k] = 1;
				}
			}
		}
		
		int ans1=1, ans2=2, diff = 987654321, temp;
		
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				temp=0;
				//i번째 그림과 j번째 그림의 다른 부분 개수 체크
				for(int r=0;r<5;r++) {
					for(int c=0;c<7;c++) {
						if(picture[i][r][c]!=picture[j][r][c]) temp++;
					}
				}
				if(diff>temp) { //새로 비교한 그림들이 더 비슷할 경우 update
					ans1 = i;
					ans2 = j;
					diff = temp;
				}
			}
		}
		
		System.out.println(ans1+" "+ans2);
	}

}
