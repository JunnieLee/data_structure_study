package ch05;

// �� ���� ���� 1������  ��ġ�ϴ� ������ ��������� ������!!
// ��������

public class QueenB {
	static int[] pos = new int[8]; // �� ���� ���� ��ġ�� pos �迭�� ������ ����!
	
	// �� ���� ���� ��ġ�� ����� ����.
	static void print() {
		for (int i = 0; i <8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	// i���� ���� ��������!
	static void set(int i) { // i�� ��, j�� ��
		for (int j=0; j < 8; j++) {
			pos[i]=j; //���� j�࿡ ��ġ
			
			if (i==7) // 7�������� ��� ��ġ�� �Ϸ�� ���¶��, �� ���¸� �״�� ���!
				print();
			else // ���� ��� ��ġ�� �Ϸ�� ���°� �ƴ϶��,
				set(i+1); // ���� (i+1)��° ���� �� ���� ��ġ�ϴ� ���� ����
		}
	}
	
	public static void main(String[] args) {
		set(0); // 0���� ���� ��ġ�ϴ� ������ ��ü ���μ����� ����!
				// i=7�� �ɶ� �� ��� ���μ����� ���� ������!!!
	}
}
