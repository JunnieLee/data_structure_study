package ch05;

import java.util.Scanner;

public class Q6 {
	// no개의 원반을 x번 기둥에서 y번 기둥으로 옮김!
	static void move(int no, String start, String mid, String end) {
		if (no>1) // 1. 맨 마지막 원반을 제외한 나머지 원반그룹들을 시작 기둥에서 중간기둥으로 옮겨라
			move(no-1, start, mid, mid);
		
		// 2. 맨 마지막 원반을 목표기둥으로 옮겨라
		System.out.println("원반[" + no + "]을 " + start + "기둥에서 " + end +"기둥으로 옮겼습니다.");
		
		// 3. 맨 마지막 원반을 제외한 나머지 원반그룹들을 중간기둥에서 목표기둥으로 옮겨라
		if (no>1) 
			move(no-1, mid, mid, end);	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("하노의의 탑!!");
		System.out.print("원반 개수:");
		int n = stdIn.nextInt();
		
		System.out.println("시작 기둥 이름");
		String start = stdIn.next();
		
		System.out.println("가운데 기둥 이름");
		String mid = stdIn.next();
		
		System.out.println("목표 기둥 이름");
		String end = stdIn.next();
		
		move(n, start, mid, end); // 1번 기둥에 있는 n개의 원반을 3번 기둥으로 옮겨라!!
	}
}

