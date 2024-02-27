import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;

		while (a + b == 0) {
			try {
				Scanner sc = new Scanner(System.in);
				a = sc.nextInt();
				b = sc.nextInt();

				if (0 >= a || b >= 10) {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("입력값이 유효하지 않음. 다시 입력해주세요.[ a: " + a + "/b :" + b);
				// 초기화
				a = 0;
				b = 0;
			}
		}

		System.out.println(a + b);
	}

}