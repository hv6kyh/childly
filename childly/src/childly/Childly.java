package childly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Childly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);	// 표준 입력을 위해 스캐너 객체 이용
		Stack<Integer> stack = new Stack<>();	// 스택 선언

		int top = 1;							// 스택에 넣을 숫자
		int n = -1;								// 사용자에게 입력 받는 숫자

		while (n != 0) {
			
			do {
		
				// ------ n입력받기 ------
				System.out.print("숫자 입력 : ");
				
				n = sc.nextInt();
				System.out.println("입력한 숫자 : " + n);
				// ---------------------
			
			} while(n < 0 || n > 16);
	
			Node root = new Node("A");				// 최상위 노드는 A(push)부터 시작
			
			Tree tree = new Tree();					// 트리 생성
			tree.addChild(root, n, 0);				// 자식 노드들을 만든다
	
			// 최하위 레벨의 노드(단말 노드)들을 담은 리스트
			ArrayList<Node> list = tree.getLastList();
			
			// 리스트에 담긴 노드의 개수만큼 반복
			for (int i = list.size() - 1; i >= 0 ; i--) {
				
				// 리스트에 담긴 노드를 하나씩 꺼낸다
				Node node = list.get(i);
				
				// 그 노드의 부모들을 추적해 마스크를 만든다
				String mask = tree.chase(node);
				
				// 마스크 문자열의 길이만큼 반복
				for (int j = 0; j < mask.length(); j++) {
					
					switch (mask.charAt(j)) {
					
					// 문자가 A면 push
					case 'A' :
						stack.push(top++);
						break;
						
					// 문자가 B면 pop
					case 'B' :
						System.out.print(stack.pop() + " ");
						break;
						
					}
					
				}
				
				top = 1;
				System.out.println();
				
			}
			
			System.out.println("총 경우의 수 = " + list.size());
			System.out.println("-----------------------------");
			
		}
		System.out.println("** 프로그램 종료 **");
	}
	
}