package ch06;

import java.util.Scanner;

// 버블 정렬 (ver1) - Q2.
// 왼쪽부터 비교-교환 과정 출력

public class Q2 {
	
	private static int no1 = 0; // 비교 횟수
	private static int no2 = 0; // 교환 횟수
	
	// a[idx1]과 a[idx2]의 값을 바꿔줌! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
		no2++;
	} // 이 swap 메소드 안에서 값의 이동이 3번 일어남!!

	
	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		
		for (int i=0; i < n-1; i++) { // 패스는 총  n-1번 발생해야 하지! // 패스 발생 횟수  = 이미 정렬된 element 개수
			System.out.println("");
			System.out.println("패스 " + i + " :");
		
			for (int j = n-1; j > i ; j--) {// 페어 비교를 맨 뒤에서부터 할꺼니까 이렇게 설정!!
				no1++;
				
				if (a[j-1] > a[j]) {// 교환이 필요한가? check
					
					for (int z=0; z < n; z++) {
						if (z!= j-1) 
							System.out.print(a[z]);
						else if (z == j-1)
							System.out.print(a[z]+"+");
					}
					System.out.println("");
			
					swap(a, j-1, j);
				}
					
				else {
					for (int z=0; z < n; z++)
						if (z!= j-1) 
							System.out.print(a[z]);
						else if (z == j-1)
							System.out.print(a[z]+"-");
					System.out.println("");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Bubble Sort - Q2.");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x, nx); // 배열 x를 버블정렬 합니다. // 내역 출력과 함께!!
		
		System.out.println("비교를 "+ no1 +"회 했습니다.");
		System.out.println("교환을 "+ no2 +"회 했습니다.");

	}
}
