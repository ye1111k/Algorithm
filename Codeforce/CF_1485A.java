import java.util.*;
import java.io.*;

public class CF_1485A {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int T=Integer.parseInt(s);
		ArrayList<int []> queue;
		int [] temp;
		int [] temp1;
		int ans=0;
		int i=0;
		
		for(int t=0;t<T;t++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			temp=new int[3];
			
			temp[0]=Integer.parseInt(st.nextToken());
			temp[1]=Integer.parseInt(st.nextToken());
			temp[2]=0;
			
			queue=new ArrayList<int []>();
			queue.add(temp);
			i=0;
			while(i<queue.size()) {
				temp=queue.get(i);
				if(temp[0]==0) {
					ans=temp[2];
					break;
				}
				temp1=new int[3];
				temp1[0]=Math.floorDiv(temp[0],temp[1]);
				temp1[1]=temp[1];
				temp1[2]=temp[2]+1;
				queue.add(temp1);
				
				temp1=new int[3];
				temp1[0]=temp[0];
				temp1[1]=temp[1]+1;
				temp1[2]=temp[2]+1;
				queue.add(temp1);
				i++;
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
	}

}
