package chap09;
import java.util.Comparator;

// linked list 클래스
public class LinkedList<E> {
	//노드
	class Node<E> { // 제네릭으로 구현 - E는 임의의 클래스형이 허용됨
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터 (다음 노드 참조)

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리노드 (그에 대한 참조일뿐, 머리노드 그 자체는 아니라는것에 유의!)
	private Node<E> crnt; // 현재 선택한 노드

	// 생성자
	public LinkedList() {
		head = crnt = null; // 비어있는 연결리스트 생성
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 스캔 중인 노드

		while (ptr!= null) { 
			// ptr값이 null이면 이제 더이상 스캔할 노드가 남아있지 않다는 뜻. 
			// 이때까지 못찾은거면 검색실패겠지.
			
			if (c.compare(obj,  ptr.data)==0) { // 검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // 다음 노드를 선택
		}
		return null; // 검색 실패
	}

	
	// 머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입전의 머리노드
		head = crnt = new Node<E>(obj, ptr);
	}

	
	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head==null) // 리스트가 비어있다면
			addFirst(obj); // 머리에 삽입하는것과 같은 과정!!
		else { // 리스트에 노드가 1개 이상 존재하는 상황이라면
			Node<E> ptr = head; // 현재 타겟 포인터 --> 일단 head에서부터 시작
			while (ptr.next != null) // 마지막 노드 바로 직전까지 - 계속 next로 다음노드를 가리키는 과정 반복
				ptr = ptr.next; // 맨 마지막에 꼬리노드 위치에 타겟 포인터가 놓이는 상태에서 끝나겠네
			ptr.next = crnt = new Node<E>(obj, null); 
			// 이전 꼬리 노드 그 뒷부분 자리에 crnt도 놓고, new Node도 놓고
			// (new Node는 꼬리노드니까 참조하는 다음 노드의 값이 null이어야겠지!!)
		}
	}

	
	// 머리노드를 삭제
	public void removeFirst() {
		if (head!=null) // 리스트가 비어있지 않으면
			head = crnt = head.next;
	}

	
	// 꼬리노드를 삭제
	public void removeLast() {
		if (head != null) { // 리스트가 비어있지 않다면
			if (head.next == null) // 노드가 하나만 있다면
				removeFirst(); // 머리노드를 삭제

			else { // 노드가 두개 이상이라면
				Node<E> ptr = head; // 스캔중인 노드
				Node<E> pre = head; // 스캔중인 노드의 앞쪽노드

				while (ptr.next != null) { // ptr이 꼬리노드를 가리키기 전까지 루프 삥삥~
					pre = ptr;
					ptr = ptr.next;
				} // while문 종료 시 ptr은 꼬리노드를 가리키고, pre는 꼬리로부터 두번째 노드를 가리킵니다.

				pre.next = null; // pre는 삭제 후의 꼬리 노드
				crnt = pre;
			}
		}
	}

	
	// 노드 p를 삭제
	public void remove(Node p) {
		if (head != null) { // 리스트가 비어있지 않다면
			if (p==head) // p가 머리노드면
				removeFirst(); // 머리노드를 삭제
			else {
				Node<E> ptr = head;

				while (ptr.next != p) { // p와 같은 노드를 찾기 전까지는 계속 while loop를 돈다!
					ptr = ptr.next; // 계속 한칸씩 그 다음 노드로  move on...
					if (ptr == null) return; // 리스트 끝까지 다다랐는데도 while문 탈출을 못했다면...
					// p가 리스트에 없다는거겠지!! 그럼 그냥 그 상태에서 return을 통해 메소드 종료!
					// 없는걸 어떻게 삭제하겠어...ㅎ..ㅎ...
				}

				// while문을 탈출했다는것은 ptr.next == p 였다는 사실!!
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	// 선택노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}

	// 모든 노드를 삭제 (버전 1)
	public void clear() {
		while (head != null) // 노드에 아무것도 없을 때까지
			removeFirst(); // 머리노드 삭제
		crnt = null;
	}

	// 모든 노드를 삭제 (버전 2)
		public void clear2() {
			head = crnt = null;
		}
		
	// 선택 노드를 하나 뒤쪽으로 이동
		public boolean next() {
			if (crnt == null || crnt.next == null) // 현재 노드도 존재하지 않고, 그 다음노드도 존재하지 않을 때
				return false; // 이동할 수 없음
			crnt = crnt.next;
			return true;
		}

	// 선택 노드를 출력
		public void printCurrentNode() {
			if (crnt == null)
				System.out.println("선택한 노드가 없습니다.");
			else
				System.out.println(crnt.data);
		}
	
	// 모든 노드를 출력
		public void dump() {
			Node<E> ptr = head;
			
			while (ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}

}
