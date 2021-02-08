package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1893 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		int T=Integer.parseInt(s);
		
		String A,W,S;
		int cnt,j;
		int [] f;
		ArrayList<Integer> answer;
		
		int [] SS;
		int [] WS;
		
		for(int t=0;t<T;t++) {
			cnt=0;
			answer=new ArrayList<Integer>();
			
			A=br.readLine();
			W=br.readLine();
			S=br.readLine();
			WS=new int[W.length()];
			SS=new int[S.length()];
			
			for(int i=0;i<W.length();i++) {
				for(int a=0;a<A.length();a++)
					if(W.charAt(i)==A.charAt(a))
						WS[i]=a;
			}
			
			for(int i=0;i<S.length();i++) {
				for(int a=0;a<A.length();a++)
					if(S.charAt(i)==A.charAt(a))
						SS[i]=a;
			}
			
			for(int a=0;a<A.length();a++) {
				cnt=0;
				
				if(a!=0) {
					for(int i=0;i<W.length();i++) {
						WS[i]++;
						if(WS[i]==A.length()) WS[i]=0;
					}
				}
				
				f=new int[W.length()];
				
				j=0;
				for(int i=1;i<W.length();i++) {
					while(j>0&&WS[i]!=WS[j])
						j=f[j-1];
					if(WS[i]==WS[j])
						f[i]=++j;
				}
				
				j=0;
				for(int i=0;i<S.length();i++) {
					while(j>0&&SS[i]!=WS[j])
						j=f[j-1];
					if(SS[i]==WS[j])
						j++;
					if(j==W.length()) {
						cnt++;
						j=f[j-1];
					}
				}
				
				if(cnt==1) answer.add(a);
			}
			if(answer.size()==0) bw.write("no solution\n");
			else if(answer.size()==1) bw.write("unique: "+answer.get(0)+"\n");
			else {
				bw.write("ambiguous:");
				for(int i=0;i<answer.size();i++)
					bw.write(" "+answer.get(i));
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
