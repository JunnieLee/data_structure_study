package ch06;

import java.util.Scanner;

public class SelectionSort {
	
	// a[idx1]과 a[idx2]의 값을 바꿔줌! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // 이 swap 메소드 안에서 값의 이동이 3번 일어남!!
	
	
	// 단순 선택 정렬
	static void selectionSort(int[] a, int n) {
		for (int i=0; i < n-1; i++) { // 교환횟수 총  n-1번! 
									  // 교환횟수 = 현재까지 정렬된 요소 개수
			int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 요소의 index 기록
			for (int j = i+1; j < n; j++)
				if (a[j]<a[min])
					min = j;
			swap(a, i, min); // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환!
		}	
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("단순 선택 정렬: ");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		selectionSort(x, nx); // 배열 x를 단순선택정렬 합니다.
		
		System.out.println("오름차순으로 정리했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}
