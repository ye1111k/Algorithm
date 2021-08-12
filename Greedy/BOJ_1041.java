package 백준문제;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long N = Long.parseLong(input.nextLine());
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		long [] dice = new long[6];
		for(int i=0;i<6;i++)
			dice[i] = Long.parseLong(st.nextToken());
		
		long ans = 0;
		long max = 0;
		
		long Three = three(dice);
		long Two = two(dice);
		long One = one(dice);
		
		if(N==1) { //N이 1일 경우
			for(int i=0;i<6;i++) {
				ans += dice[i];
				max = (dice[i]>max)? dice[i]:max;
			}
			ans -= max;
		}
		else {
			ans += 4 * Three;
			ans += ((N - 2) * 4 + (N - 1) * 4) * Two;
			ans += ((N - 2) * (N - 2) + (N - 2) * (N - 1) * 4) * One;
		}
		System.out.println(ans);
		
	}
	public static long one(long [] dice) { //한 면이 노출되는 경우 중 최소
		Arrays.sort(dice);
		return dice[0];
	}
	public static long two(long [] dice){ //두 면이 노출되는 경우 중 최소 - 경우의 수는 모서리의 개수와 동일
		long [] twoside = new long[12];
		twoside[0] = dice[0] + dice[1]; //A와 B
		twoside[1] = dice[0] + dice[2]; //A와 C
		twoside[2] = dice[0] + dice[3]; //A와 D
		twoside[3] = dice[0] + dice[4]; //A와 E
		twoside[4] = dice[1] + dice[2]; //B와 C
		twoside[5] = dice[1] + dice[3]; //B와 D
		twoside[6] = dice[1] + dice[5]; //B와 F
		twoside[7] = dice[2] + dice[4]; //C와 E
		twoside[8] = dice[2] + dice[5]; //C와 F
		twoside[9] = dice[3] + dice[4]; //D와 E
		twoside[10] = dice[3] + dice[5]; //D와 F
		twoside[11] = dice[4] + dice[5]; //E와F
		
		Arrays.sort(twoside);
		return twoside[0];
	}
	public static long three(long [] dice) { //세 면이 노출되는 경우 중 최소 - 경우의 수는 꼭짓점의 개수와 동일
		long [] threeside = new long[8];
		
		threeside[0] = dice[0] + dice[1] + dice[2]; //A와 B,C
		threeside[1] = dice[0] + dice[1] + dice[3]; //A와 B,D
		threeside[2] = dice[0] + dice[2] + dice[4]; //A와 C,E
		threeside[3] = dice[0] + dice[3] + dice[4]; //A와 D,E
		threeside[4] = dice[5] + dice[1] + dice[2]; //F와 B,C
		threeside[5] = dice[5] + dice[1] + dice[3]; //F와 B,D
		threeside[6] = dice[5] + dice[2] + dice[4]; //F와 C,E
		threeside[7] = dice[5] + dice[3] + dice[4]; //F와 D,E
		
		Arrays.sort(threeside);
		return threeside[0];
	}

}
