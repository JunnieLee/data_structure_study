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
			n[head].set(obj,  ptr);
			// �ε����� rec�� record ��ġ(���� head ��ġ)�� �ش� ��带 ����
			// data�� ��ǲ�� E obj, �׸��� �� ���ο� �Ӹ���尡 �������� ����ų �ִ�
			// ���� �Ӹ����̾��� ��!
		}
	}

	// ������ ��带 ����
	public void addLast(E obj) {
		if (head==NULL) // ����Ʈ�� ���������
			addFirst(obj); // �Ӹ��� ����
		else {
			int ptr = head; // ptr�� �Ӹ���� ������ ����
			while (n[ptr].next != NULL) // ������� �Ǳ� ��������
				ptr = n[ptr].next; // �� ���� ���� move on
			// ptr�� ������带 ����Ű�� index�� �ɶ� �� loop�� ��������
			int rec = getInsertIndex();
			// rec���ٰ� '���ο�ְ� ���ԵǸ� ������ ��ġ �ε���'�� ����
			if (rec != NULL) { // �ε��� rec�� record�� ����
				n[ptr].next = crnt = rec;
				// ���� ������� ������ ���� ���ԵǴ� ��尡 ����! rec�� ���� (index ó��)
				n[rec].set(obj,  NULL);
				// ���� �� ó�� (�� ���� ���� �������� �갡 �� �������� ����Ű�� ���� NULL)
			}
		}
	}

	// �Ӹ� ��带 ����
	public void removeFirst() {
		if (head!=NULL) { // ����Ʈ�� ����ִ°� �ƴϸ�
			int ptr = n[head].next; // �Ӹ���� �� ���� ���� index�� ptr�� ����
			deleteIndex(head); // head ����
			head = crnt = ptr; // ���� ���ο� head�� ������ �ι�° ���
		}
	}

	// ���� ��带 ����
	public void removeLast() {
		if (head!=NULL) {
			if (n[head].next == NULL) // ��尡 �ϳ��� �ִٸ�
				removeFirst(); // �Ӹ� ��� ����
			else {
				int ptr = head; // ��ĵ���� ���
				int pre = head; // ��ĵ���� ����� ���� ���

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				} // ptr�� ������� index�϶� while���� ��� �� ����.
				// �׶����� ��� �� �������� move on
				n[pre].next=NULL; // pre�� ���� ���� �������
				deleteIndex(ptr); // å�� pre�� ���ֶ� �ߴµ� ��Ÿ�ε�;
				crnt = pre;
			}
		}
	}

	// record p�� ����
	public void remove(int p) {
		if (head!=NULL) {
			if (p==head) // p�� �Ӹ�����
				removeFirst();
			else {
				int ptr = head;

				while (n[ptr].next!=p) {
					ptr = n[ptr].next;
					if (ptr==NULL) return; // p�� ����Ʈ�� �����ϴ�.
				} // n[ptr].next==p�ɶ����� ���� ��� ��.

				n[ptr].next=NULL; // ���� p�ִ� �ڸ��� NULL�� ����Ű�� �����
				deleteIndex(p); // å�� ptr�̶� �Ǿ��ִµ� p�ΰͰ���
				n[ptr].next = n[p].next; 
				crnt = ptr;
			}
		}
	}

	// ���� ��带 ����
	public void removeCurrentNode() {
		remove(crnt);
	}

	// ��� ��带 ����
	public void clear() {
		while (head != NULL)
			removeFirst(); // �� �� ������
		crnt = NULL; // �Ӹ� ��带 ����
	}

	// ���� ��带 �ϳ� �������� �̵�
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false; // �̵��� �� ����
		crnt = n[crnt].next;
		return false;
	}

	// ���� ��带 ���
	public boolean printCurrentNode() {
		if (crnt==NULL)
			System.out.println("���� ��尡 �����ϴ�.");
		else
			System.out.println(n[crnt].data);
	}

	// ��� ��带 ���
	public void dump() {
		int ptr = head;

		while (ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}
