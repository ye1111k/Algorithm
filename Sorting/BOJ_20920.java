package 백준문제;
import java.io.*;
import java.util.*;

class Word{
	String s;
	int n;
	
	Word(String s,int n){
		this.s=s;
		this.n=n;
	}
	
	public void update() {
		this.n++;
	}
}

public class BOJ_20920 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		ArrayList<Word> list=new ArrayList<Word>(); 
		ArrayList<String> used=new ArrayList<String>();
		
		Word temp;
		int j;
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			if(s.length()<M) continue;
			used.add(s);
		}
		
		Collections.sort(used, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		j=0;
		
		temp=new Word(used.get(0),1);
		list.add(temp);
		
		for(int i=1;i<used.size();i++) {
			s=used.get(i);
			if(s.equals(list.get(j).s))
				list.get(j).update();
			else {
				temp=new Word(s,1);
				j++;
				list.add(temp);
			}
		}
		
		Collections.sort(list,new Comparator<Word>() {
			public int compare(Word o1, Word o2) {
				int a=o1.n;
				int b=o2.n;
				String x=o1.s;
				String y=o2.s;
				if(a!=b) return b-a;
				else {
					if(x.length()!=y.length()) return y.length()-x.length();
					else {
						return x.compareTo(y);
					}
				}
			}
		});
		
		for(int i=0;i<list.size();i++)
			bw.write(list.get(i).s+"\n");
		
		bw.flush();
		bw.close();
	}
	
}
