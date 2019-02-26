package ch06;
import java.util.Scanner;

// 셸 정렬 (버전 1)

// 쉘 정렬의 경우, 앞에서 구한 어떠한 간격만큼 떨어진 원소에 대해서 삽입정렬을 먼저 수행하고,
// 그 간격을 점점 줄여 계속 삽입정렬을 하는 방법을 취한다.
// 간격은 결국 1이 될 것이며, 1이 되는 때는 곧, 삽입 정렬을 수행하는 것과 동일하다.
// 하지만 이미 Array가 어느정도 정리 되어 있기 때문에, 삽입 정렬에 소모되는 연산이 줄어드는 것이다.


public class ShellSort {
	// 셸 정렬
	static void shellSort(int[] a, int n) {
		for (int h=n/2; h>0; h/=2) // 간격 h값은 loop 한번씩 돌 떄마다 반토막남~
			for (int i = h; i<n; i++) { // 뒤쪽 반절에 있는 요소 하나하고
				int j;
				int tmp = a[i];
				for (j=i-h; j>=0 && a[j]>tmp ; j -= h) // 앞쪽 반절에 있는 요소중 현재 타겟 요소랑 
					a[j+h]=a[j];					   // h만큼 차이나는 애랑 대소비교해서 정렬~
					// 선택한 요소와 비교하는 요소가 서로 이웃하지 않고 h칸만큼 떨어져있다!
				a[j+h] = tmp; 
			}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("셸 정렬: ");
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
