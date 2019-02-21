package ch05;

// 각 행, 열에 퀸을 1개씩만  배치하는 조합을 재귀적으로 나열함!!
// (각 행에 퀸을 1개만 배치)

public class QueenBB {
	static boolean[] flag = new boolean[8]; // 각 행에 퀸을 배치했는지 확인
	static int[] pos = new int[8]; // 각 열의 퀸의 위치 저장
	
	// 각 열의 퀸의 위치를 출력할 것임.
	static void print() {
		for (int i = 0; i <8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	// i열의 알맞은 위치에 퀸을 놓을것임!
	static void set(int i) { // i가 열, j가 행 (set 메소드는 열 값 i를 기준으로 operate됨)
		for (int j=0; j < 8; j++) {
			if (flag[j]==false) { // j행에 퀸이 배치되지 않은 상태라면,
				pos[i]=j; // 퀸을 j행 i열에 배치
				
				if (i==7) // 7열에까지 모두 배치가 완료된 상태라면, 그 상태를 그대로 출력!
					print();
				else {// 아직 열 별로 모두 배치가 완료된 상태가 아니라면,
					flag[j]=true; // 이번 i열에 대해서 j행은 배치가 완료되었으니, true인 상태!
					set(i+1); // 다음 (i+1)번째 열에 또 퀸을 배치하는 과정 ㄱㄱ	
					flag[j]=false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		set(0); // 0열에 퀸을 배치하는 것으로 전체 프로세스를 시작!
				// i=7이 될때 이 모든 프로세스가 끝이 나겠지!!!
	}
}

