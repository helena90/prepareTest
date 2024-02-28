import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0;
		do {
			try {
				a = sc.nextInt();
				b = sc.nextInt();
				if (0 >= a || b >= 10)
					throw new Exception();

			} catch (Exception e) {
				System.out.println("입력값이 유효하지 않음");
				a = 0;
				b = 0;
			}
		} while (a == 0 && b == 0);
		System.out.print(a + b);
	}

}