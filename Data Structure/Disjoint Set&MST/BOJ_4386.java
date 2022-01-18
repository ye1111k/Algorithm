package 백준문제;

import java.io.*;
import java.util.*;

class Edge_4386{
	int start;
	int end;
	double distance;
	
	public Edge_4386(int x, int y, double distance) {
		this.start = x;
		this.end = y;
		this.distance = distance;
	}
}

public class BOJ_4386 {
	public static int [] par;
	public static int find(int A) {
		if(par[A]==A) return A;
		else return par[A] = find(par[A]);
	}
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		//if(x==y) return;
		
		if(x<=y) par[y] = x; //!!!!!!
		else par[x] = y;
	}
	public static double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		par = new int[n];
		for(int i=0;i<n;i++)
			par[i] = i;
		
		double [][] star = new double[n][2];
		StringTokenizer st;
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		ArrayList<Edge_4386> edges = new ArrayList<Edge_4386>();
		double distance;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				distance = distance(star[i][0], star[j][0], star[i][1], star[j][1]);
			
				edges.add(new Edge_4386(i,j,distance));
			}
		}
		
		Collections.sort(edges, new Comparator<Edge_4386>() {
			public int compare(Edge_4386 o1, Edge_4386 o2) {
				if(o1.distance<o2.distance) return -1;
				else return 1;
			}
		});
		
		double answer = 0;
		int a,b;
		
		for(int i=0;i<edges.size();i++) {
			Edge_4386 temp = edges.get(i);
			a = find(temp.start);
			b = find(temp.end);
			
			if(a!=b) {
				answer += temp.distance;
				union(temp.start, temp.end);
			}
			//System.out.println(temp.start+" "+temp.end+" "+temp.distance);
		}
		System.out.printf("%.2f",answer);
	}

}
