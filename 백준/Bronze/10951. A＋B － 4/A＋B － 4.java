
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		do {
			try {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (0 >= a || b >= 10)
					throw new Exception();

				listA.add(a);
				listB.add(b);
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력됨");
			}
		} while (sc.hasNext());

		// 출력
		for (int cnt = 0; cnt < listA.size(); cnt++) {
			System.out.println(listA.get(cnt) + listB.get(cnt));
		}

	}

}