package ew;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int a = scanner.nextInt();
		final int b = scanner.nextInt();
		final int c = scanner.nextInt();

		if (a == b && b == c) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		scanner.close();

	}

}
