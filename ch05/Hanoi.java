package ch05;
import java.util.Scanner;

public class Hanoi {
	// no���� ������ x�� ��տ��� y�� ������� �ű�!
	static void move(int no, int x, int y) {
		if (no>1) // 1. �� ������ ������ ������ ������ ���ݱ׷���� ���� ��տ��� �߰�������� �Űܶ�
			move(no-1, x, 6-x-y);
		
		// 2. �� ������ ������ ��ǥ������� �Űܶ�
		System.out.println("����[" + no + "]��" + x + "��տ���" + y +"������� �Ű���ϴ�.");
		
		// 3. �� ������ ������ ������ ������ ���ݱ׷���� �߰���տ��� ��ǥ������� �Űܶ�
		if (no>1) 
			move(no-1, 6-x-y, y);	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ϳ����� ž!!");
		System.out.print("���� ����:");
		int n = stdIn.nextInt();
		
		move(n, 1, 3); // 1�� ��տ� �ִ� n���� ������ 3�� ������� �Űܶ�!!
	}
}
