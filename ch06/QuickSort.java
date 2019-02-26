package ch06;
import java.util.Scanner;

public class QuickSort {
	
	// 배열요소 a[idx1]와 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}
	
	// 퀵 정렬
	static void quickSort(int[] a, int left, int right) {
		// left = 나눌 구간의 첫번째 요소의 index
		// right = 나눌 구간의 마지막 요소의 index
		int pl = left; // 왼쪽 커서
		int pr = right; // 오른쪽 커서
		int x = a[(pl+pr)/2]; // 피벗
		
		
		// 배열 a를 피벗 x를 기준으로 나눕니다.
		do {
			while (a[pl] <x) pl++; // x보다 작은 애가 왼쪽에 있음 --> no swaps
			while (a[pr] >x) pr--; // x보다 큰 애가  오른쪽에 있음 --> just keep moving on
					
			if (pl <= pr) // x보다 큰 애가 pl에, x보다 작은애가 pr에 있다면.. swap!
				swap(a, pl++, pr--);
		} while (pl <= pr); // 교차되지 않은 상태일때
		
		
		// 재귀함수 호출!!
		if (left < pr) quickSort(a, left, pr); // 바로 직전 피벗보다 더 작은 묶음을 또 나눠~
		if (pl < right) quickSort(a, pl, right); // 바로 직전 피벗보다 더 큰 묶음을 또 나눠~
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("퀵 정렬 :");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		quickSort(x, 0, nx-1); // 배열 x를 퀵정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i=0; i < nx; i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}
