package ch06;
import java.util.Scanner;

// 배열을 나눕니다.
public class Partition {
	
	// 배열 요소인 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// 배열을 나눕니다.
	static void partition(int[] a, int n) {
		int pl = 0; // 오른쪽 커서
		int pr = n-1; // 왼쪽 커서
		int x = a[n/2]; // 피벗 (가운데 위치의 값)
		
		// 배열 a를 피벗 x를 기준으로 나눕니다.
		do {
			while (a[pl] <x) pl++; // x보다 작은 애가 왼쪽에 있음 --> no swaps
			while (a[pr] >x) pr--; // x보다 큰 애가  오른쪽에 있음 --> just keep moving on
			
			if (pl <= pr) // x보다 큰 애가 pl에, x보다 작은애가 pr에 있다면.. swap!
				swap(a, pl++, pr--);
		} while (pl <= pr); // 교차되지 않은 상태일때
		
		System.out.println("피벗의 값은 "+ x + "입니다.");
		
		System.out.println("피벗 이하의 그룹 :");
		for (int i=0; i <= pl-1; i++) // a[0] ~ a[pl-1]
			System.out.print(a[i] + " ");
		System.out.println();
		
		if (pl > pr+1) {
			System.out.println("피벗과 일치하는 그룹  :");
			for (int i= pr+1; i <= pl-1; i++) // a[pr+1] ~ a[pl-1]
				System.out.print(a[i] + " ");
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹 :");
		for (int i=pr+1; i <= n; i++) // a[pr+1] ~ a[n-1]
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("배열을 나눕니다.");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		partition(x, nx); // 배열 x를 나눕니다!
	}
	
}
