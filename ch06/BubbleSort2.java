package ch06;
import java.util.Scanner;

//���� ���� (version 2) - "����" ����
public class BubbleSort2 {
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!
	
	
	// ���� ���� (version 2) - improved one
	static void bubbleSort(int[] a, int n) {
		for (int i=0; i < n-1; i++) {// �н��� ��  n-1�� �߻��ؾ� ����!
			int exchg = 0; // �н� ��ȯȽ�� ���
			for (int j = n-1; j > i; j--) // ��� �񱳸� �� �ڿ������� �Ҳ��ϱ� �̷��� ����!!
				if (a[j-1] > a[j]) {// ��ȯ�� �ʿ��Ѱ�? check
					swap(a, j-1, j);
					exchg++;
				}
			if (exchg == 0) break; // ��ȯȽ���� 0�̸� ����-����.
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�������� (����2)");
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

