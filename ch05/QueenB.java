package ch05;

// 각 열에 퀸을 1개씩만  배치하는 조합을 재귀적으로 나열함!!
// 가지뻗기

public class QueenB {
	static int[] pos = new int[8]; // 각 열의 퀸의 위치를 pos 배열에 저장할 것임!
	
	// 각 열의 퀸의 위치를 출력할 것임.
	static void print() {
		for (int i = 0; i <8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	// i열에 퀸을 놓을것임!
	static void set(int i) { // i가 열, j가 행
		for (int j=0; j < 8; j++) {
			pos[i]=j; //퀸을 j행에 배치
			
			if (i==7) // 7열에까지 모두 배치가 완료된 상태라면, 그 상태를 그대로 출력!
				print();
			else // 아직 모두 배치가 완료된 상태가 아니라면,
				set(i+1); // 다음 (i+1)번째 열에 또 퀸을 배치하는 과정 ㄱㄱ
		}
	}
	
	public static void main(String[] args) {
		set(0); // 0열에 퀸을 배치하는 것으로 전체 프로세스를 시작!
				// i=7이 될때 이 모든 프로세스가 끝이 나겠지!!!
	}
}
