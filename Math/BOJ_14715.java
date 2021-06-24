package 백준문제;
//K를 소인수분해 했을 때 소인수의 개수가 중요
//소인수의 개수를 count에 저장
//거기다 log₂count의 ceil(소수점 이하 올림)값이 답
import java.util.*;
public class BOJ_14715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int K=input.nextInt();
		int [] arr=new int[1010];
		for(int i=2;i<=1000;i++)
			arr[i]=1;
		for(int i=2;i<=1000;i++) {
			for(int j=2;j<=1000;j++)
				if(arr[j]!=i&&arr[j]%i==0)
					arr[j]=0;
		}
		int count=0;
		int i=2;
		while(true) {
			if(K==1) break;
			if(K%i==0) {
				count++;
				K/=i;
			}
			else i++;
		}
		int ans=(int) Math.ceil(Math.log10(count)/Math.log10(2));
		System.out.println(ans);
	}

}
