package ch06;
import java.util.Scanner;

public class QuickSort {
	
	// �迭��� a[idx1]�� a[idx2]�� ���� �ٲߴϴ�.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}
	
	// �� ����
	static void quickSort(int[] a, int left, int right) {
		// left = ���� ������ ù��° ����� index
		// right = ���� ������ ������ ����� index
		int pl = left; // ���� Ŀ��
		int pr = right; // ������ Ŀ��
		int x = a[(pl+pr)/2]; // �ǹ�
		
		
		// �迭 a�� �ǹ� x�� �������� �����ϴ�.
		do {
			while (a[pl] <x) pl++; // x���� ���� �ְ� ���ʿ� ���� --> no swaps
			while (a[pr] >x) pr--; // x���� ū �ְ�  �����ʿ� ���� --> just keep moving on
					
			if (pl <= pr) // x���� ū �ְ� pl��, x���� �����ְ� pr�� �ִٸ�.. swap!
				swap(a, pl++, pr--);
		} while (pl <= pr); // �������� ���� �����϶�
		
		
		// ����Լ� ȣ��!!
		if (left < pr) quickSort(a, left, pr); // �ٷ� ���� �ǹ����� �� ���� ������ �� ����~
		if (pl < right) quickSort(a, pl, right); // �ٷ� ���� �ǹ����� �� ū ������ �� ����~
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ���� :");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		quickSort(x, 0, nx-1); // �迭 x�� ������
		
		System.out.println("������������ �����߽��ϴ�.");
		for (int i=0; i < nx; i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}
