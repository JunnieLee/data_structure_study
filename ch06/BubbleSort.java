package ch06;
import java.util.Scanner;

// 버블 정렬 (version 1)
public class BubbleSort {
	
	// a[idx1]과 a[idx2]의 값을 바꿔줌! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // 이 swap 메소드 안에서 값의 이동이 3번 일어남!!
	
	
	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		for (int i=0; i < n-1; i++) // 패스는 총  n-1번 발생해야 하지!
			for (int j = n-1; j > i; j--) // 페어 비교를 맨 뒤에서부터 할꺼니까 이렇게 설정!!
				if (a[j-1] > a[j]) // 교환이 필요한가? check
					swap(a, j-1, j);
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("버블정렬 (버전1)");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x, nx); // 배열 x를 버블정렬 합니다.
		
		System.out.println("오름차순으로 정리했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}
