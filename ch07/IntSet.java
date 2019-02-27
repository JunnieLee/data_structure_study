package ch07;
// int�� ����

public class IntSet {
	private int max; // ������ �ִ� ����
	private int num; // ������ ���� ��� ����
	private int[] set; // ���� ��ü
	
	// ������
	public IntSet(int capacity) {
		num = 0; // �� ó���� ����ִ� ����
		max = capacity;
		try {
			set = new int[max]; // ���� �迭 ����
		}
		catch (OutOfMemoryError e) { // �迭 ���� ����
			max = 0;
		}
	}
	
	// ������ �ִ� ����
	public int capacity() {
		return max;
	}
	
	// ������ ���� ��� ����
	public int size() {
		return num;
	}
	
	
	// ���տ��� n�� �˻��մϴ�. (index ��ȯ)
	public int indexOf(int n) {
		for (int i=0; i < num; i++)
			if (set[i]==n)
				return i; // �˻� ����
		return -1; // �˻� ����
	}
	
	
	// ���տ� n�� �ִ��� ������ Ȯ���մϴ�.
	public boolean contains(int n) {
		return (indexOf(n)!=-1)? true : false;
	}
	
	
	// ���տ� n�� �߰��մϴ�.
	public boolean add(int n) {
		if (num>=max || contains(n)==true) // ���� á�ų� �̹� n�� �����ϴ� ���
			return false;
		else {
			set[num++] = n; // ���� ������ �ڸ��� �߰��մϴ�.
			return true;
		}
	}
	
	// ���տ��� n�� �����մϴ�
	public boolean remove(int n) {
		int idx; // n�� ����� ����� index
		
		if (num <= 0 || (idx=indexOf(n))==-1) // ����ְų� n�� �������� �ʽ��ϴ�.
			return false;
		else {
			set[idx] = set[--num]; // ������ ��Ҹ� ������ ������ �ű�ϴ�.
			return true;
		}
	}
	
	// ���� s�� �����մϴ�.
	public void copyTo(IntSet s) {
		int n = (s.max < num)? s.max:num; // ������ ��� ���� (�� �� �� �����ɷ�)
		for (int i=0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	// ���� s�� �����մϴ�.
	public void copyFrom(IntSet s) {
		int n = (max < s.num)? max:s.num; // ������ ��� ���� (�� �� �� �����ɷ�)
		for (int i=0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	// ���� s�� ������ Ȯ���մϴ�.
	public boolean equalTo(IntSet s) {
		if (num != s.num) // ��� ������ ���� ������
			return false;
		
		// ����� ������ ���� ���
		for (int i=0; i<num; i++) { 
			int j = 0;
			for (; j<s.num; j++)
				if (set[i]==s.set[j])
					break; // ���� �� �ϴ� �߰������� �� ���� for loop Ż��~ 
			if (j==s.num) // ���� ������ ���Ҵµ��� ������ ��ã��
				return false;
		}
		// �� �� �������� false return�ϴ� ���� �Ȱɸ��� �� loop ��������..
		return true; // �� �� ������ ���ٰ� �� �� �ְ���!
	}
	
	// ���� s1�� s2�� �������� �����մϴ�. --> �ڱ� �ڽ����� ����
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1); // ���� s1�� �����մϴ�.
		for (int i=0; i < s2.num; i++) // ���� s2�� ��Ҹ� �߰��մϴ�.
			add(s2.set[i]); // �̹� ������ �ִ°Ÿ� add �ȵǴ°ɷ� �츮�� �տ��� �����س�����!
	}
	
	// "{a b c}" ������ ���ڿ��� ǥ���� �ٲߴϴ�.
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		// StringBuffer Ŭ������ ��ü�� �� �� ������ �Ŀ��� ����Ͽ� �����ϰ� �ִ� ���ڿ��� ������ ������ �� �ִ�. 
		
		for (int i=0; i<num; i++)
			temp.append(set[i]+" ");
		temp.append("}");
		
		return temp.toString();
	}
	
	// Q1. ���������� Ȯ���մϴ�.
	public boolean isEmpty() {
		return num==0? true:false;
	}
	
	// Q1. ������ ���� á���� Ȯ���մϴ�.
	public boolean isFull() {
		return num==max? true:false;
	}
	
	// Q1. ������ �ʱ�ȭ �մϴ�. (��� ��Ҹ� ����)
	public void clear() {
		num = 0;
		set = new int[max];
	}
	
	// Q2. ����s�� ��� ��Ҹ� �߰��մϴ�. - ���պ���� true, ���� �ȵɽ� false
	// ����ȵǴ� ��� ? --> s�� �������̰ų�, s�� ��Ұ� �̹� �� ���տ� �� �ִ� ���
	public boolean unionWith (IntSet s) {
		int original = num; // ó�� ��� ����
		
		for (int i=0; i < s.num; i++)
			add(s.set[i]);
		
		return original == num? true:false;
	}
	
	// Q2. ���� s�� ����ִ� ��Ҹ� ����� ������ ��ҵ��� ��� �����մϴ�. - ���պ���� true, ���� �ȵɽ� false
	public boolean intersectionWith (IntSet s) {
		int original = num; // ó�� ��� ����
		
		int[] helper = new int[] {};
		
		for (int i=0; i < num; i++)
			for (int j=0; j < s.num; j++)
				if (set[i]==set[j])
						helper[helper.length -1] = set[i];
		
		set = helper; // ���������� ���� �ֵ鸸 ��Ƽ� set�� �״�� ������ ����ٿ��ֱ�!
		
		return original == num? true:false;
	}
	
	
	// Q2. ���� s�� ����ִ� ��Ҹ� �����մϴ�. - ���պ���� true, ���� �ȵɽ� false
	public boolean differenceWith (IntSet s) {
		int original = num; // ó�� ��� ����

		for (int i=0; i < num; i++)
			for (int j=0; j < s.num; j++)
				if (set[i]==set[j])
						remove(set[i]);
				
		return original == num? true:false;
	}
}
