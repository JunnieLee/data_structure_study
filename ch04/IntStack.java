package ch04;

public class IntStack {
	private int max; // ���� �뷮
	private int ptr; // ���� ������
	private int[] stk; // ���� ��ü
	
	// ����� ����: ������ �������
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { }
	}
	
	// ����� ����: ������ ���� ��
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { }
	}
	
	// ������
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; // ���� ��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // ������ �� ����
			max = 0;
		}
	}
	
	// ���ÿ� x�� Ǫ��
	public int push(int x) throws OverflowIntStackException {
		
	}
}