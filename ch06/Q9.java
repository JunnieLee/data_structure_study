package ch06;
import java.util.Scanner;

//�� ���� (���� 2) --> �̵�Ƚ�� ���

public class Q9 {
	
	
	// �� ����
	static void shellSort(int[] a, int n) {
		int num=0;
		
		int h;
		for (h=1; h < n/9; h = h*3 +1)
			; // h�� �ʱ갪 ���ϱ�.
			  // �־��� ���� �Ͽ��� ������ ���� ū ���� h�� ����!
		
		for (; h>0; h /=3) // �ݺ��ϴ� �������� h�� ���� 1�� ��.
			for (int i=h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j=i-h; j >=0 && a[j]>tmp; j -= h)
					a[j+h] = a[j];
					num += 1;
				a[j+h] = tmp;
				num += 1;
			}
		System.out.println("����� �̵�Ƚ���� �� "+ num +"�� �Դϴ�.");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ���� (����2): ");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		shellSort(x, nx); // �迭 x�� �� ����
		
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
		
	}
}

