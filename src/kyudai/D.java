package kyudai;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner scanner = new Scanner(System.in);
		int cities = scanner.nextInt();
		int go = scanner.nextInt();
		int back = scanner.nextInt();
		
		int costs[] = new int[cities];
		
		for(int i = 0;i<cities;i++) {
			costs[i] = scanner.nextInt();
		}
		
		

	}

}
