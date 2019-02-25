package ch06;
import java.util.Scanner;

// ���� �ذ� X (�̿ϼ�)

// �ܼ��������� �޼ҵ� ����.
// �迭�� ù��° ��� ��� �ι�° ��Һ��� ������ ����.
// �迭�� ù��° ��Ҹ� ���ʷ� �Ͽ� ������ ��ġ�� ������ ���� �� ����!

public class Q7 {
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!
	
	
	// �ܼ� ���� ����
	static void insertionSort(int[] a, int n) {
		for (int i=1; i<n; i++) { // i-1�� ���� ���� �ݺ�
			int j;
			int tmp = a[i]; // ���ĵ��� ���� �κ��� �� �տ� �ִ� �� (���� ������ ��)
			for (j=i; j>0 && a[j-1] > tmp; j--) // ���� �� �ֵ� ���̿� ���� ����
				a[j] = a[j-1]; // ���� ���Դ���� �ֺ��� �� �տ� �ְ� �� ũ�ٸ�
								// ����ؼ� �ٷ� ������ ���� �� �տ� �� ������ ����� ������ ���ư�
			// ���� ���Դ���� �ֺ��� �� �տ� �ְ� �� �۰ų� ������ for loop�� ��������!
			a[j] = tmp; // �� �ڸ��� tmp (���� ���� ����� ��) ����
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
		
		insertionSort(x, nx); // �迭 x�� �ܼ��������� �մϴ�.
		
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x["+ i + "] = " + x[i]);
	}
}

