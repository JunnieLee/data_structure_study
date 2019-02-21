package ch06;
import java.util.Scanner;

//� ���� ���� ��ȯ�� ������� �ʴ´ٸ�
//�׺��� ������ ��Ҵ� �̹� ������ ��ģ ���·� �����ϰ� �� �� �ֵ��� pass~
// + bidirectional
// Ȧ�� �� ° �н����� ���� ���� ��Ҹ� �� ������
// ¦�� �� ° �н����� ���� ū ��Ҹ� �� �ڷ�

public class Q5_Biderection_BubbleSort {
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!
	
	
	// bidirectional bubble sort (shaker sort / cocktail sort)
	static void bubbleSort(int[] a, int n) {
		
		int k = 0; // a[k]���� ������ ������ �� ��ģ ����
		int bk = n-1; // a[bk]���� ������ ������ �� ��ģ ����
		
		int cnt = 1; // ���� ���° �н����� count
		
		// [1] cnt�� Ȧ���� ����  ���� ���� ��Ҹ� �� ������
		if (cnt%2 != 0) {
			while (k < n-1){
				int last = n-1;	// ���������� ��Ҹ� ��ȯ�� ��ġ --> n-1���� ����
				for (int j = n-1; j > k; j--) // ��� �񱳸� �� �ڿ������� �Ҳ��ϱ� �̷��� ����!!
					if (a[j-1] > a[j]) {// ��ȯ�� �ʿ��Ѱ�? check
						swap(a, j-1, j);
						last = j;
					}
				k = last;
			}	
		}
		
		// [2] cnt�� ¦���϶��� ���� ū ��Ҹ� �� �ڷ�
		else {
			while (bk > 0){
				int last = 1;	// ���������� ��Ҹ� ��ȯ�� ��ġ (������) --> 1���� ����
				for (int j = 1; j < bk; j++) // ��� �񱳸� �� �ڿ������� �Ҳ��ϱ� �̷��� ����!!
					if (a[j-1] > a[j]) {// ��ȯ�� �ʿ��Ѱ�? check
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
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x, nx); // �迭 x�� �������� �մϴ�.
		
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}

