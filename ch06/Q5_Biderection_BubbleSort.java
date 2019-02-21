package ch06;
import java.util.Scanner;

//어떤 시점 이후 교환이 수행되지 않는다면
//그보다 앞쪽의 요소는 이미 정렬을 마친 상태로 간주하고 그 앞 애들은 pass~
// + bidirectional
// 홀수 번 째 패스에선 가장 작은 요소를 맨 앞으로
// 짝수 번 째 패스에선 가장 큰 요소를 맨 뒤로

public class Q5_Biderection_BubbleSort {
	
	// a[idx1]과 a[idx2]의 값을 바꿔줌! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // 이 swap 메소드 안에서 값의 이동이 3번 일어남!!
	
	
	// bidirectional bubble sort (shaker sort / cocktail sort)
	static void bubbleSort(int[] a, int n) {
		
		int k = 0; // a[k]보다 앞쪽은 정렬을 다 마친 상태
		int bk = n-1; // a[bk]보다 뒤쪽은 정렬을 다 마친 상태
		
		int cnt = 1; // 현재 몇번째 패스인지 count
		
		// [1] cnt가 홀수일 때는  가장 작은 요소를 맨 앞으로
		if (cnt%2 != 0) {
			while (k < n-1){
				int last = n-1;	// 마지막으로 요소를 교환한 위치 --> n-1부터 시작
				for (int j = n-1; j > k; j--) // 페어 비교를 맨 뒤에서부터 할꺼니까 이렇게 설정!!
					if (a[j-1] > a[j]) {// 교환이 필요한가? check
						swap(a, j-1, j);
						last = j;
					}
				k = last;
			}	
		}
		
		// [2] cnt가 짝수일때는 가장 큰 요소를 맨 뒤로
		else {
			while (bk > 0){
				int last = 1;	// 마지막으로 요소를 교환한 위치 (오른쪽) --> 1부터 시작
				for (int j = 1; j < bk; j++) // 페어 비교를 맨 뒤에서부터 할꺼니까 이렇게 설정!!
					if (a[j-1] > a[j]) {// 교환이 필요한가? check
						swap(a, j-1, j);
						last = j;
					}
				bk = last;
			}			
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Biderection_BubbleSort");
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

