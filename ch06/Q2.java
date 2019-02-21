package ch06;

import java.util.Scanner;

// ���� ���� (ver1) - Q2.
// ���ʺ��� ��-��ȯ ���� ���

public class Q2 {
	
	private static int no1 = 0; // �� Ƚ��
	private static int no2 = 0; // ��ȯ Ƚ��
	
	// a[idx1]�� a[idx2]�� ���� �ٲ���! swap!
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
		no2++;
	} // �� swap �޼ҵ� �ȿ��� ���� �̵��� 3�� �Ͼ!!

	
	// ���� ����
	static void bubbleSort(int[] a, int n) {
		
		for (int i=0; i < n-1; i++) { // �н��� ��  n-1�� �߻��ؾ� ����! // �н� �߻� Ƚ��  = �̹� ���ĵ� element ����
			System.out.println("");
			System.out.println("�н� " + i + " :");
		
			for (int j = n-1; j > i ; j--) {// ��� �񱳸� �� �ڿ������� �Ҳ��ϱ� �̷��� ����!!
				no1++;
				
				if (a[j-1] > a[j]) {// ��ȯ�� �ʿ��Ѱ�? check
					
					for (int z=0; z < n; z++) {
						if (z!= j-1) 
							System.out.print(a[z]);
						else if (z == j-1)
							System.out.print(a[z]+"+");
					}
					System.out.println("");
			
					swap(a, j-1, j);
				}
					
				else {
					for (int z=0; z < n; z++)
						if (z!= j-1) 
							System.out.print(a[z]);
						else if (z == j-1)
							System.out.print(a[z]+"-");
					System.out.println("");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Bubble Sort - Q2.");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i=0; i < nx; i++) {
			System.out.print("x["+ i + "]:");  // �ϴ� �Է¹ް�~!
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x, nx); // �迭 x�� �������� �մϴ�. // ���� ��°� �Բ�!!
		
		System.out.println("�񱳸� "+ no1 +"ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� "+ no2 +"ȸ �߽��ϴ�.");

	}
}
