package ch06;
import java.util.Scanner;

// �� ���� (���� 1)

// �� ������ ���, �տ��� ���� ��� ���ݸ�ŭ ������ ���ҿ� ���ؼ� ���������� ���� �����ϰ�,
// �� ������ ���� �ٿ� ��� ���������� �ϴ� ����� ���Ѵ�.
// ������ �ᱹ 1�� �� ���̸�, 1�� �Ǵ� ���� ��, ���� ������ �����ϴ� �Ͱ� �����ϴ�.
// ������ �̹� Array�� ������� ���� �Ǿ� �ֱ� ������, ���� ���Ŀ� �Ҹ�Ǵ� ������ �پ��� ���̴�.


public class ShellSort {
	// �� ����
	static void shellSort(int[] a, int n) {
		for (int h=n/2; h>0; h/=2) // ���� h���� loop �ѹ��� �� ������ ���丷��~
			for (int i = h; i<n; i++) { // ���� ������ �ִ� ��� �ϳ��ϰ�
				int j;
				int tmp = a[i];
				for (j=i-h; j>=0 && a[j]>tmp ; j -= h) // ���� ������ �ִ� ����� ���� Ÿ�� ��Ҷ� 
					a[j+h]=a[j];					   // h��ŭ ���̳��� �ֶ� ��Һ��ؼ� ����~
					// ������ ��ҿ� ���ϴ� ��Ұ� ���� �̿����� �ʰ� hĭ��ŭ �������ִ�!
				a[j+h] = tmp; 
			}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ����: ");
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
