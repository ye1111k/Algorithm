package 백준문제;

import java.util.Scanner;

public class BOJ_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
        
        int A=input.nextInt();
        
        int [] a=new int[A];
        int [] b=new int[A];
        
        for(int i=0;i<A;i++){
            int n=1;
            a[i]=input.nextInt();
            for(int j=0;j<i;j++)
                if(a[j]>a[i]&&n<=b[j]) n=b[j]+1;
            b[i]=n;
        }
        
        int max=b[0];
        for(int i=0;i<A;i++)
            if(max<b[i]) max=b[i];
        System.out.println(max);
	}

}
