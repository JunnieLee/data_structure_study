package ch06;
import java.util.Scanner;

// �迭�� �����ϴ�.
public class Partition {
	
	// �迭 ����� a[idx1]�� a[idx2]�� ���� �ٲߴϴ�.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// �迭�� �����ϴ�.
	static void partition(int[] a, int n) {
		int pl = 0; // ������ Ŀ��
		int pr = n-1; // ���� Ŀ��
		int x = a[n/2]; // �ǹ� (��� ��ġ�� ��)
		
		// �迭 a�� �ǹ� x�� �������� �����ϴ�.
		do {
			while (a[pl] <x) pl++; // x���� ���� �ְ� ���ʿ� ���� --> no swaps
			while (a[pr] >x) pr--; // x���� ū �ְ�  �����ʿ� ���� --> just keep moving on
			
			if (pl <= pr) // x���� ū �ְ� pl��, x���� �����ְ� pr�� �ִٸ�.. swap!
				swap(a, pl++, pr--);
		} while (pl <= pr); // �������� ���� �����϶�
		
		System.out.println("�ǹ��� ���� "+ x + "�Դϴ�.");
		
		System.out.println("�ǹ� ������ �׷� :");
		for (int i=0; i <= pl-1; i++) // a[0] ~ a[pl-1]
			System.out.print(a[i] + " ");
		System.out.println();
		
		if (pl > pr+1) {
			System.out.println("�ǹ��� ��ġ�ϴ� �׷�  :");
			for (int i= pr+1; i <= pl-1; i++) // a[pr+1] ~ a[pl-1]
				System.out.print(a[i] + " ");
			System.out.println();
		}
		
		System.out.println("�ǹ� �̻��� �׷� :");
		for (int i=pr+1; i <= n; i++) // a[pr+1] ~ a[n-1]
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�迭�� �����ϴ�.");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		partition(x, nx); // �迭 x�� �����ϴ�!
	}
	
}
