
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int caseCount = 0;
		Scanner sc = new Scanner(System.in);

		caseCount = sc.nextInt();
		int[] arrA = new int[caseCount];
		int[] arrB = new int[caseCount];

		for (int i = 0; i < caseCount; i++) {
			try {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (0 >= a || b >= 10)
					throw new Exception();

				arrA[i] = a;
				arrB[i] = b;
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력됨");
				i = i - 1; // 재실행
			}

		}

		// 출력
		for (int cnt = 0; cnt < caseCount; cnt++) {
			System.out.println(arrA[cnt] + arrB[cnt]);
		}

	}

}
