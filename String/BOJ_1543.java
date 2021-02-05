package 백준문제;

import java.io.*;

public class BOJ_1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String S=br.readLine();
		String P=br.readLine();
		
		int cnt=0;
		boolean ck;
		
		for(int i=0;i<S.length()-P.length()+1;i++) {
			ck=true;
			for(int j=0;j<P.length();j++) {
				if(S.charAt(i+j)!=P.charAt(j)) {
					ck=false;
					break;
				}
			}
			if(ck) {
				i+=(P.length()-1);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		int a=0;
		int b=0;
		System.out.println(a++);
		System.out.println(++b);
	}

}
