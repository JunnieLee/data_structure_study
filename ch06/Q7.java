package ch06;
import java.util.Scanner;

// 문제 해결 X (미완성)

// 단순삽입정렬 메소드 수정.
// 배열의 첫번째 요소 대신 두번째 요소부터 데이터 저장.
// 배열의 첫번째 요소를 보초로 하여 삽입을 마치는 조건을 줄일 수 있음!

public class Q7 {
	
	// a[idx1]과 a[idx2]의 값을 바꿔줌! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // 이 swap 메소드 안에서 값의 이동이 3번 일어남!!
	
	
	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for (int i=1; i<n; i++) { // i-1번 삽입 과정 반복
			int j;
			int tmp = a[i]; // 정렬되지 않은 부분중 맨 앞에 있는 애 (삽입 차례인 애)
			for (j=i; j>0 && a[j-1] > tmp; j--) // 정렬 된 애들 사이에 삽입 ㄱㄱ
				a[j] = a[j-1]; // 현재 삽입대상인 애보다 그 앞에 애가 더 크다면
								// 계속해서 바로 오른쪽 값을 그 앞에 애 값으로 만들며 앞으로 나아감
			// 현재 삽입대상인 애보다 그 앞에 애가 더 작거나 같으면 for loop를 빠져나와!
			a[j] = tmp; // 그 자리에 tmp (현재 삽입 대상인 애) 대입
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("단순 삽입 정렬: ");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		insertionSort(x, nx); // 배열 x를 단순삽입정렬 합니다.
		
		System.out.println("오름차순으로 정리했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}

