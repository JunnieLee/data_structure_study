package ch05;

import java.util.Scanner;

public class Q6 {
	// no���� ������ x�� ��տ��� y�� ������� �ű�!
	static void move(int no, String start, String mid, String end) {
		if (no>1) // 1. �� ������ ������ ������ ������ ���ݱ׷���� ���� ��տ��� �߰�������� �Űܶ�
			move(no-1, start, mid, mid);
		
		// 2. �� ������ ������ ��ǥ������� �Űܶ�
		System.out.println("����[" + no + "]�� " + start + "��տ��� " + end +"������� �Ű���ϴ�.");
		
		// 3. �� ������ ������ ������ ������ ���ݱ׷���� �߰���տ��� ��ǥ������� �Űܶ�
		if (no>1) 
			move(no-1, mid, mid, end);	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ϳ����� ž!!");
		System.out.print("���� ����:");
		int n = stdIn.nextInt();
		
		System.out.println("���� ��� �̸�");
		String start = stdIn.next();
		
		System.out.println("��� ��� �̸�");
		String mid = stdIn.next();
		
		System.out.println("��ǥ ��� �̸�");
		String end = stdIn.next();
		
		move(n, start, mid, end); // 1�� ��տ� �ִ� n���� ������ 3�� ������� �Űܶ�!!
	}
}

