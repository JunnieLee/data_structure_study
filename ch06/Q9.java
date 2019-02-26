package ch06;
import java.util.Scanner;

//셸 정렬 (버전 2) --> 이동횟수 계산

public class Q9 {
	
	
	// 셸 정렬
	static void shellSort(int[] a, int n) {
		int num=0;
		
		int h;
		for (h=1; h < n/9; h = h*3 +1)
			; // h의 초깃값 구하기.
			  // 주어진 조건 하에서 가능한 가장 큰 값을 h에 대입!
		
		for (; h>0; h /=3) // 반복하다 마지막에 h의 값은 1이 됨.
			for (int i=h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j=i-h; j >=0 && a[j]>tmp; j -= h)
					a[j+h] = a[j];
					num += 1;
				a[j+h] = tmp;
				num += 1;
			}
		System.out.println("요소의 이동횟수는 총 "+ num +"번 입니다.");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("셸 정렬 (버전2): ");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		shellSort(x, nx); // 배열 x를 셸 정렬
		
		System.out.println("오름차순으로 정리했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
		
	}
}

