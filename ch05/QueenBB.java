package ch05;

// �� ��, ���� ���� 1������  ��ġ�ϴ� ������ ��������� ������!!
// (�� �࿡ ���� 1���� ��ġ)

public class QueenBB {
	static boolean[] flag = new boolean[8]; // �� �࿡ ���� ��ġ�ߴ��� Ȯ��
	static int[] pos = new int[8]; // �� ���� ���� ��ġ ����
	
	// �� ���� ���� ��ġ�� ����� ����.
	static void print() {
		for (int i = 0; i <8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	// i���� �˸��� ��ġ�� ���� ��������!
	static void set(int i) { // i�� ��, j�� �� (set �޼ҵ�� �� �� i�� �������� operate��)
		for (int j=0; j < 8; j++) {
			if (flag[j]==false) { // j�࿡ ���� ��ġ���� ���� ���¶��,
				pos[i]=j; // ���� j�� i���� ��ġ
				
				if (i==7) // 7�������� ��� ��ġ�� �Ϸ�� ���¶��, �� ���¸� �״�� ���!
					print();
				else {// ���� �� ���� ��� ��ġ�� �Ϸ�� ���°� �ƴ϶��,
					flag[j]=true; // �̹� i���� ���ؼ� j���� ��ġ�� �Ϸ�Ǿ�����, true�� ����!
					set(i+1); // ���� (i+1)��° ���� �� ���� ��ġ�ϴ� ���� ����	
					flag[j]=false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		set(0); // 0���� ���� ��ġ�ϴ� ������ ��ü ���μ����� ����!
				// i=7�� �ɶ� �� ��� ���μ����� ���� ������!!!
	}
}

