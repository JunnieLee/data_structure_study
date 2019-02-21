package ch06;

import java.util.Scanner;

// ���� ���� (ver1) - Q1.
// ���ʺ��� ��-��ȯ �����ؼ� ������������ �����ϱ�!
// (�� �н����� ���� ū���� ��Ұ� �� ���������� ������ �Ű�����!)

public class Q1 {
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!
	
	
	// ���� ����
	static void bubbleSort(int[] a, int n) {
		for (int i=0; i < n-1; i++) // �н��� ��  n-1�� �߻��ؾ� ����! // �н� �߻� Ƚ��  = �̹� ���ĵ� element ����
			for (int j = 1; j < n-i; j++) // ��� �񱳸� ���ʿ������� �غ���!
				if (a[j-1] > a[j]) // ��ȯ�� �ʿ��Ѱ�? check
					swap(a, j-1, j);
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�������� (����1)");
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
