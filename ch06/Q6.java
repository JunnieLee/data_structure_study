package ch06;
import java.util.Scanner;

public class Q6 {
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!
	
	
	// �ܼ� ���� ����
	static void selectionSort(int[] a, int n) {
		for (int i=0; i < n-1; i++) { // ��ȯȽ�� ��  n-1��! 
									  // ��ȯȽ�� = ������� ���ĵ� ��� ����
			int min = i; // ���� ���ĵ��� ���� �κп��� ���� ���� ����� index ���
			for (int j = i+1; j < n; j++)
				if (a[j]<a[min])
					min = j;
			
			String text = "";
			
			for (int m=0; m < n; m++) {
				if (m==i)
					text += new String("* ");
				else if (m==min)
					text += new String("+ ");
				else
					text += new String("  ");
			}
			System.out.println();
			System.out.println(text);
			
			for (int m=0; m < n; m++) {
				System.out.print(a[m]+" ");
			}
			
			swap(a, i, min); // ���� ���ĵ��� ���� �κ��� ù ��ҿ� ���� ���� ��Ҹ� ��ȯ!
		}	
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ܼ� ���� ����: ");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		System.out.println("��ȯ������ ����մϴ�.");
		selectionSort(x, nx); // �迭 x�� �ܼ��������� �� �� ������ ��� �մϴ�.
	
	}
}
