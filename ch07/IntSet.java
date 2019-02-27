package ch07;
// int형 집합

public class IntSet {
	private int max; // 집합의 최대 개수
	private int num; // 집합의 현재 요소 개수
	private int[] set; // 집합 본체
	
	// 생성자
	public IntSet(int capacity) {
		num = 0; // 맨 처음엔 비어있는 상태
		max = capacity;
		try {
			set = new int[max]; // 집합 배열 생성
		}
		catch (OutOfMemoryError e) { // 배열 생성 실패
			max = 0;
		}
	}
	
	// 집합의 최대 개수
	public int capacity() {
		return max;
	}
	
	// 집합의 현재 요소 개수
	public int size() {
		return num;
	}
	
	
	// 집합에서 n을 검색합니다. (index 반환)
	public int indexOf(int n) {
		for (int i=0; i < num; i++)
			if (set[i]==n)
				return i; // 검색 성공
		return -1; // 검색 실패
	}
	
	
	// 집합에 n이 있는지 없는지 확인합니다.
	public boolean contains(int n) {
		return (indexOf(n)!=-1)? true : false;
	}
	
	
	// 집합에 n을 추가합니다.
	public boolean add(int n) {
		if (num>=max || contains(n)==true) // 가득 찼거나 이미 n이 존재하는 경우
			return false;
		else {
			set[num++] = n; // 가장 마지막 자리에 추가합니다.
			return true;
		}
	}
	
	// 집합에서 n을 삭제합니다
	public boolean remove(int n) {
		int idx; // n이 저장된 요소의 index
		
		if (num <= 0 || (idx=indexOf(n))==-1) // 비어있거나 n이 존재하지 않습니다.
			return false;
		else {
			set[idx] = set[--num]; // 마지막 요소를 삭제한 곳으로 옮깁니다.
			return true;
		}
	}
	
	// 집합 s에 복사합니다.
	public void copyTo(IntSet s) {
		int n = (s.max < num)? s.max:num; // 복사할 요소 개수 (둘 중 더 작은걸로)
		for (int i=0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	// 집합 s를 복사합니다.
	public void copyFrom(IntSet s) {
		int n = (max < s.num)? max:s.num; // 복사할 요소 개수 (둘 중 더 작은걸로)
		for (int i=0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	// 집합 s와 같은지 확인합니다.
	public boolean equalTo(IntSet s) {
		if (num != s.num) // 요소 개수가 같지 않으면
			return false;
		
		// 요소의 개수가 같은 경우
		for (int i=0; i<num; i++) { 
			int j = 0;
			for (; j<s.num; j++)
				if (set[i]==s.set[j])
					break; // 같은 거 일단 발견했으면 이 안쪽 for loop 탈출~ 
			if (j==s.num) // 루프 끝까지 돌았는데도 같은거 못찾음
				return false;
		}
		// 이 위 루프에서 false return하는 조건 안걸리고 잘 loop 돌았으면..
		return true; // 그 두 집합은 같다고 할 수 있겠지!
	}
	
	// 집합 s1과 s2의 합집합을 복사합니다. --> 자기 자신한테 복사
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1); // 집합 s1을 복사합니다.
		for (int i=0; i < s2.num; i++) // 집합 s2의 요소를 추가합니다.
			add(s2.set[i]); // 이미 기존에 있는거면 add 안되는걸로 우리가 앞에서 설계해놨었지!
	}
	
	// "{a b c}" 형식의 문자열로 표현을 바꿉니다.
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		// StringBuffer 클래스의 객체는 한 번 생성된 후에도 계속하여 저장하고 있는 문자열의 내용을 변경할 수 있다. 
		
		for (int i=0; i<num; i++)
			temp.append(set[i]+" ");
		temp.append("}");
		
		return temp.toString();
	}
	
	// Q1. 공집합인지 확인합니다.
	public boolean isEmpty() {
		return num==0? true:false;
	}
	
	// Q1. 집합이 가득 찼는지 확인합니다.
	public boolean isFull() {
		return num==max? true:false;
	}
	
	// Q1. 집합을 초기화 합니다. (모든 요소를 삭제)
	public void clear() {
		num = 0;
		set = new int[max];
	}
	
	// Q2. 집합s의 모든 요소를 추가합니다. - 집합변경시 true, 변경 안될시 false
	// 변경안되는 경우 ? --> s가 공집합이거나, s의 요소가 이미 본 집합에 다 있는 경우
	public boolean unionWith (IntSet s) {
		int original = num; // 처음 요소 개수
		
		for (int i=0; i < s.num; i++)
			add(s.set[i]);
		
		return original == num? true:false;
	}
	
	// Q2. 집합 s에 들어있는 요소만 남기고 나머지 요소들을 모두 삭제합니다. - 집합변경시 true, 변경 안될시 false
	public boolean intersectionWith (IntSet s) {
		int original = num; // 처음 요소 개수
		
		int[] helper = new int[] {};
		
		for (int i=0; i < num; i++)
			for (int j=0; j < s.num; j++)
				if (set[i]==set[j])
						helper[helper.length -1] = set[i];
		
		set = helper; // 교집합으로 남은 애들만 모아서 set에 그대로 가져다 복사붙여넣기!
		
		return original == num? true:false;
	}
	
	
	// Q2. 집합 s에 들어있는 요소만 삭제합니다. - 집합변경시 true, 변경 안될시 false
	public boolean differenceWith (IntSet s) {
		int original = num; // 처음 요소 개수

		for (int i=0; i < num; i++)
			for (int j=0; j < s.num; j++)
				if (set[i]==set[j])
						remove(set[i]);
				
		return original == num? true:false;
	}
}
