package 백준문제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10825 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		String [][] student=new String[N][4];
		
		for(int i=0;i<N;i++) {
			student[i][0]=input.next();
			student[i][1]=input.next();
			student[i][2]=input.next();
			student[i][3]=input.next();
		}
		
		Arrays.sort(student,new Comparator<String[]>() {
			public int compare(String [] o1, String [] o2) {
				if(Integer.parseInt(o1[1])<Integer.parseInt(o2[1]))
					return 1;
				else if(o1[1].equals(o2[1])) {
					if (Integer.parseInt(o1[2])>Integer.parseInt(o2[2])) return 1;
					else if(o1[2].equals(o2[2])) {
						if(Integer.parseInt(o1[3])<Integer.parseInt(o2[3])) return 1;
						else if(o1[3].equals(o2[3])) {
							 if(o1[0].compareTo(o2[0])>0) return 1;
						}
					}
				}
				return -1;
			}
		});
		
		for(int i=0;i<N;i++)
			System.out.println(student[i][0]);
		
	}

}
