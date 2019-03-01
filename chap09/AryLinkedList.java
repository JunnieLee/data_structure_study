package chap09;
import java.util.Comparator;
// ���� ����Ʈ Ŭ���� (�迭 Ŀ�� ����)

public class AryLinkedList<E> {

	// ���
	class Node<E> {
		private E data; // ������
		private int next; // ����Ʈ�� ���� ������
		private int dnext; // free ����Ʈ�� ���� ������

		// data�� next�� ����
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n; //����Ʈ ��ü
	private int size; //����Ʈ�� �뷮 (���� ū ������ ��)
	private int max; // ������� ���� record
	private int head; // �Ӹ� ���
	private int crnt; // ���� ���� ���
	private int deleted; // free����Ʈ�� �Ӹ� ���
	private static final int NULL = -1; // ���� ��� ����/ ����Ʈ�� ���� ��

	// ������
	public AryLinkedList(int capacity) {
		head = crnt = max = deleted= NULL;
		try {
			n = new Node[capacity]; // �迭 ����
			for (int i=0; i<capacity; i++)
				n[i] = new Node<E>(); // ������ �迭��  ���� ��� ������Ʈ�� �� �־���
			size = capacity; // �迭 �ִ� ũ��� capacity��ŭ~
		}
		catch (OutOfMemoryError e) { // �迭 ������ ����
			size = 0;
		}
	}

	// ������ �����ϴ� record�� �ε����� ����
	private int getInsertIndex() {
		if (deleted == NULL) { // ������ record�� ����
			if (max < size) // ������� ���� record ( max )��  ����Ʈ�� �뷮( size )���� ���� �� 
				return ++max; // �� record�� ���
			else
				return NULL; // �뷮 over (��ħ)
		} else { // ������ ������ record�� ����
			int rec = deleted; // free ����Ʈ�� ����� value�� rec ������ ����.
			deleted = n[rec].dnext; // �⺻ ����Ʈ�� dnext���� free����Ʈ�� ���ο� ����尪���� �Ҵ�
			return rec; // ���� free ����Ʈ�� ����� �� (not any more)�� return
		}
	}
	
	// record idx�� free����Ʈ�� ���
	private void deleteIndex(int idx) {
		if (deleted == NULL) { // ������ record�� ����
			deleted = idx; // idx�� free����Ʈ�� �Ӹ��� ���
			n[idx].dnext = NULL;
		} else { // ������ ������ record�� ����
			int rec = deleted;  // ���� free����Ʈ�� ����尪�� rec�� ����
			deleted = idx; // idx�� free����Ʈ�� �Ӹ��� ����
			n[deleted].dnext = rec; 
			// å�� n[rec].dnext = rec; ��� �����ִµ� Ʋ���Ű���
		}
	}

	// ��带 �˻�
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head; // ���� ��ĵ���� ��� (head node���� ����)
		
		while (ptr != NULL) { // ����Ʈ ������ ��~��ĵ~
			if (c.compare(obj, n[ptr].data)==0) { // �˻����� ���� ��ĵ�ϰ� �ִ� ���� ���� �����ϸ�
				crnt = ptr; // ������ ��尪�� �ش� ��ĵ���� ���� �����ϰ�
				return n[ptr].data; // �˻� ������ ����� data�� return (return���°� E�ϱ�)
			}
			// ���� ��ĵ�ϰ� �ִ°Ͱ��� ��ġ���� �ʴ´ٸ�
			ptr = n[ptr].next; // ���� ��忡 �ָ�
		}
		//�� while�� ���������� �� ��͵� return���� �ʾҴٸ� ...
		return null; // �˻� ����
	}
	
	//  �Ӹ��� ��带 ����
	public void addFirst(E obj) {
		int ptr = head; // ���� ���� �Ӹ���尪�� ptr�� ����
		int rec = getInsertIndex(); // �����ؾ��� ��ġ�� rec�� ����
		if (rec != NULL) {
			head = crnt = rec; 
			// �Ӹ����� ���� ���ó�尪�� ���Ե� ���� �����ϰ�
			// �ε����� rec�� record ��ġ�� �ش� ��带 ����
			n[head].set(obj,  ptr);
		}
	}
	
	// ������ ��带 ����
	
	//
	
	//
	
	//
}
