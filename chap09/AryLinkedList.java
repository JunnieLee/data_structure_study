package chap09;
import java.util.Comparator;
// 연결 리스트 클래스 (배열 커서 버전)

public class AryLinkedList<E> {

	// 노드
	class Node<E> {
		private E data; // 데이터
		private int next; // 리스트의 뒤쪽 포인터
		private int dnext; // free 리스트의 뒤쪽 포인터

		// data와 next를 설정
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n; //리스트 본체
	private int size; //리스트의 용량 (가장 큰 데이터 수)
	private int max; // 사용중인 꼬리 record
	private int head; // 머리 노드
	private int crnt; // 현재 선택 노드
	private int deleted; // free리스트의 머리 노드
	private static final int NULL = -1; // 다음 노드 없음/ 리스트가 가득 참

	// 생성자
	public AryLinkedList(int capacity) {
		head = crnt = max = deleted= NULL;
		try {
			n = new Node[capacity]; // 배열 생성
			for (int i=0; i<capacity; i++)
				n[i] = new Node<E>(); // 생성한 배열에  각각 노드 오브젝트를 쭉 넣어줌
			size = capacity; // 배열 최대 크기는 capacity만큼~
		}
		catch (OutOfMemoryError e) { // 배열 생성에 실패
			size = 0;
		}
	}

	// 다음에 삽입하는 record의 인덱스를 구함
	private int getInsertIndex() {
		if (deleted == NULL) { // 삭제한 record가 없음
			if (max < size) // 사용중인 꼬리 record ( max )가  리스트의 용량( size )보다 작을 때 
				return ++max; // 새 record를 사용
			else
				return NULL; // 용량 over (넘침)
		} else { // 기존에 삭제한 record가 있음
			int rec = deleted; // free 리스트의 헤드노드 value를 rec 변수에 넣음.
			deleted = n[rec].dnext; // 기본 리스트의 dnext값을 free리스트의 새로운 헤드노드값으로 할당
			return rec; // 이전 free 리스트의 헤드노드 값 (not any more)을 return
		}
	}
	
	// record idx를 free리스트에 등록
	private void deleteIndex(int idx) {
		if (deleted == NULL) { // 삭제한 record가 없음
			deleted = idx; // idx를 free리스트의 머리에 등록
			n[idx].dnext = NULL;
		} else { // 기존에 삭제한 record가 있음
			int rec = deleted;  // 기존 free리스트의 헤드노드값을 rec에 저장
			deleted = idx; // idx를 free리스트의 머리에 삽입
			n[deleted].dnext = rec; 
			// 책엔 n[rec].dnext = rec; 라고 써져있는데 틀린거같음
		}
	}

	// 노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head; // 현재 스캔중인 노드 (head node부터 시작)
		
		while (ptr != NULL) { // 리스트 끝까지 쭉~스캔~
			if (c.compare(obj, n[ptr].data)==0) { // 검색값과 현재 스캔하고 있는 값이 둘이 동일하면
				crnt = ptr; // 선택한 노드값을 해당 스캔중인 노드로 설정하고
				return n[ptr].data; // 검색 성공한 노드의 data값 return (return형태가 E니까)
			}
			// 현재 스캔하고 있는것과는 일치하지 않는다면
			ptr = n[ptr].next; // 다음 노드에 주목
		}
		//이 while문 끝날때까지 그 어떤것도 return되지 않았다면 ...
		return null; // 검색 실패
	}
	
	//  머리에 노드를 삽입
	public void addFirst(E obj) {
		int ptr = head; // 삽입 전의 머리노드값을 ptr에 담음
		int rec = getInsertIndex(); // 삽입해야할 위치를 rec에 담음
		if (rec != NULL) {
			head = crnt = rec; 
			// 머리노드와 현재 선택노드값을 삽입될 노드로 설정하고
			// 인덱스가 rec인 record 위치에 해당 노드를 삽입
			n[head].set(obj,  ptr);
		}
	}
	
	// 꼬리에 노드를 삽입
	
	//
	
	//
	
	//
}
