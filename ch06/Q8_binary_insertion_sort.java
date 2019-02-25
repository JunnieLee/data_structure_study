package ch06;
import java.util.Scanner;

// �̿ϼ�

// ���� ���� ����
public class Q8_binary_insertion_sort {
	
	// ���� ���� ����
	static void binaryInsertionSort(int[] a, int n) {
		for (int i=1; i<n; i++) { // i-1�� ���� ���� �ݺ�
			int j;
			int tmp = a[i]; // ���ĵ��� ���� �κ��� �� �տ� �ִ� �� (���� ������ ��)
						
			// ���� �˻�
			int first = 0; // �˻� ������ ù index
			int last = i; // �˻� ������ �� index
			int status = 0;	
			
			do {
				int middle = (first + last) / 2; // �߾� ����� index
				
				if (a[middle]==tmp) 
					status = 1;
				else if (a[middle] < tmp)
					first = middle+1; //�˻� ������ ���� �������� ����
				else 
					last = middle-1; // �˻� ������ ���� �������� ����
			} while (first <= last);
			
			
			int right_place = 0;
			
			// ��ġ�ϴ� ��Ұ� �տ� �־��ٸ�
			if (status == 1)
				right_place = (first + last) / 2 + 1;
			
			// ��ġ�ϴ� ��Ұ� �տ� ��������
			else {
				if (first == last) { // ������ �� ���
					if (a[first] > tmp)
						right_place = first-1;				
					else 
						right_place = first+1;					
				}
				
				else { // ������ �� ���
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
		
		System.out.println("���� ���� ����: ");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		binaryInsertionSort(x, nx); // �迭 x�� ������������ �մϴ�.
		
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}

