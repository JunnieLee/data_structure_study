package ch06;
import java.util.Scanner;

// 미완성

// 이진 삽입 정렬
public class Q8_binary_insertion_sort {
	
	// 이진 삽입 정렬
	static void binaryInsertionSort(int[] a, int n) {
		for (int i=1; i<n; i++) { // i-1번 삽입 과정 반복
			int j;
			int tmp = a[i]; // 정렬되지 않은 부분중 맨 앞에 있는 애 (삽입 차례인 애)
						
			// 이진 검색
			int first = 0; // 검색 범위의 첫 index
			int last = i; // 검색 범위의 끝 index
			int status = 0;	
			
			do {
				int middle = (first + last) / 2; // 중앙 요소의 index
				
				if (a[middle]==tmp) 
					status = 1;
				else if (a[middle] < tmp)
					first = middle+1; //검색 범위를 뒤쪽 절반으로 좁힘
				else 
					last = middle-1; // 검색 밤위를 앞쪽 절반으로 좁힘
			} while (first <= last);
			
			
			int right_place = 0;
			
			// 일치하는 요소가 앞에 있었다면
			if (status == 1)
				right_place = (first + last) / 2 + 1;
			
			// 일치하는 요소가 앞에 없었으면
			else {
				if (first == last) { // 남은게 한 요소
					if (a[first] > tmp)
						right_place = first-1;				
					else 
						right_place = first+1;					
				}
				
				else { // 남은게 두 요소
					if (a[first] > tmp)
						right_place = first-1;
					else if (a[first] < tmp && tmp < a[last])
						right_place = first+1;
					else if (tmp > a[last])
						right_place = last+1;
				}
			}
			
			for (j=i; j> right_place+1; j--) 
				a[j] = a[j-1]; 
			a[right_place] = tmp;
		}
		}
	
	
	public static void main(String[] args) {
		
Scanner stdIn = new Scanner(System.in);
		
		System.out.println("이진 삽입 정렬: ");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // 일단 입력받고~!
			x[i] = stdIn.nextInt();
		}
		
		binaryInsertionSort(x, nx); // 배열 x를 이진삽입정렬 합니다.
		
		System.out.println("오름차순으로 정리했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}

