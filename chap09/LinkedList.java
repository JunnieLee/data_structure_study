package chap09;
import java.util.Comparator;

// linked list Ŭ����
public class LinkedList<E> {
	//���
	class Node<E> { // ���׸����� ���� - E�� ������ Ŭ�������� ����
		private E data; // ������
		private Node<E> next; // ���� ������ (���� ��� ����)

		// ������
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // �Ӹ���� (�׿� ���� �����ϻ�, �Ӹ���� �� ��ü�� �ƴ϶�°Ϳ� ����!)
	private Node<E> crnt; // ���� ������ ���

	// ������
	public LinkedList() {
		head = crnt = null; // ����ִ� ���Ḯ��Ʈ ����
	}

	// ��� �˻�
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // ���� ��ĵ ���� ���

		while (ptr!= null) { 
			// ptr���� null�̸� ���� ���̻� ��ĵ�� ��尡 �������� �ʴٴ� ��. 
			// �̶����� ��ã���Ÿ� �˻����а���.
			
			if (c.compare(obj,  ptr.data)==0) { // �˻� ����
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // ���� ��带 ����
		}
		return null; // �˻� ����
	}

	
	// �Ӹ��� ��� ����
	public void addFirst(E obj) {
		Node<E> ptr = head; // �������� �Ӹ����
		head = crnt = new Node<E>(obj, ptr);
	}

	
	// ������ ��� ����
	public void addLast(E obj) {
		if (head==null) // ����Ʈ�� ����ִٸ�
			addFirst(obj); // �Ӹ��� �����ϴ°Ͱ� ���� ����!!
		else { // ����Ʈ�� ��尡 1�� �̻� �����ϴ� ��Ȳ�̶��
			Node<E> ptr = head; // ���� Ÿ�� ������ --> �ϴ� head�������� ����
			while (ptr.next != null) // ������ ��� �ٷ� �������� - ��� next�� ������带 ����Ű�� ���� �ݺ�
				ptr = ptr.next; // �� �������� ������� ��ġ�� Ÿ�� �����Ͱ� ���̴� ���¿��� �����ڳ�
			ptr.next = crnt = new Node<E>(obj, null); 
			// ���� ���� ��� �� �޺κ� �ڸ��� crnt�� ����, new Node�� ����
			// (new Node�� �������ϱ� �����ϴ� ���� ����� ���� null�̾�߰���!!)
		}
	}

	
	// �Ӹ���带 ����
	public void removeFirst() {
		if (head!=null) // ����Ʈ�� ������� ������
			head = crnt = head.next;
	}

	
	// ������带 ����
	public void removeLast() {
		if (head != null) { // ����Ʈ�� ������� �ʴٸ�
			if (head.next == null) // ��尡 �ϳ��� �ִٸ�
				removeFirst(); // �Ӹ���带 ����

			else { // ��尡 �ΰ� �̻��̶��
				Node<E> ptr = head; // ��ĵ���� ���
				Node<E> pre = head; // ��ĵ���� ����� ���ʳ��

				while (ptr.next != null) { // ptr�� ������带 ����Ű�� ������ ���� ���~
					pre = ptr;
					ptr = ptr.next;
				} // while�� ���� �� ptr�� ������带 ����Ű��, pre�� �����κ��� �ι�° ��带 ����ŵ�ϴ�.

				pre.next = null; // pre�� ���� ���� ���� ���
				crnt = pre;
			}
		}
	}

	
	// ��� p�� ����
	public void remove(Node p) {
		if (head != null) { // ����Ʈ�� ������� �ʴٸ�
			if (p==head) // p�� �Ӹ�����
				removeFirst(); // �Ӹ���带 ����
			else {
				Node<E> ptr = head;

				while (ptr.next != p) { // p�� ���� ��带 ã�� �������� ��� while loop�� ����!
					ptr = ptr.next; // ��� ��ĭ�� �� ���� ����  move on...
					if (ptr == null) return; // ����Ʈ ������ �ٴٶ��µ��� while�� Ż���� ���ߴٸ�...
					// p�� ����Ʈ�� ���ٴ°Ű���!! �׷� �׳� �� ���¿��� return�� ���� �޼ҵ� ����!
					// ���°� ��� �����ϰھ�...��..��...
				}

				// while���� Ż���ߴٴ°��� ptr.next == p ���ٴ� ���!!
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	// ���ó�带 ����
	public void removeCurrentNode() {
		remove(crnt);
	}

	// ��� ��带 ���� (���� 1)
	public void clear() {
		while (head != null) // ��忡 �ƹ��͵� ���� ������
			removeFirst(); // �Ӹ���� ����
		crnt = null;
	}

	// ��� ��带 ���� (���� 2)
		public void clear2() {
			head = crnt = null;
		}
		
	// ���� ��带 �ϳ� �������� �̵�
		public boolean next() {
			if (crnt == null || crnt.next == null) // ���� ��嵵 �������� �ʰ�, �� ������嵵 �������� ���� ��
				return false; // �̵��� �� ����
			crnt = crnt.next;
			return true;
		}

	// ���� ��带 ���
		public void printCurrentNode() {
			if (crnt == null)
				System.out.println("������ ��尡 �����ϴ�.");
			else
				System.out.println(crnt.data);
		}
	
	// ��� ��带 ���
		public void dump() {
			Node<E> ptr = head;
			
			while (ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}

}
