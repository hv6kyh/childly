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
		
		String masks[];

		
		while (n != 0) {
			
			do {
		
				// ------ n입력받기 ------
				System.out.print("숫자 입력 : ");
				
				n = sc.nextInt();
				System.out.println("입력한 숫자 : " + n);
				// ---------------------
			
			} while(n < 0 || n > 16);
	
			Node root = new Node("A");				// 최상위 노드는 A(push)부터 시작
			
			Tree tree = new Tree();
			tree.addChild(root, n, 0);				// A와 B의 개수에 따라 자식 노드들을 만든다
	
			ArrayList<Node> list = tree.getLastList();
			
			// 마스크를 보관하는 배열이 있다.
			// 배열의 크기는 최종 노드의 개수와 같다
			masks = new String[list.size()];
			
			// 배열에 마스크를 채운다
			for (int i = 0; i < list.size() ; i++) {
				masks[i] = tree.chase(list.get(i));
			}
			
			tree.inOrder(root);
			System.out.println("clear");
			tree.clearTree(root);
			root = null;
			tree.inOrder(root);
			
			for (int i = masks.length-1; i >= 0; i--) {
				
				String mask = masks[i];
				
				for (int j = 0; j < mask.length(); j++) {
					
					switch (mask.charAt(j)) {
					
					case 'A' :
						stack.push(top++);
						break;
						
					case 'B' :
						System.out.print(stack.pop() + " ");
						break;
						
					}
				}
				top = 1;
				System.out.println();
				
			}
	
//			for (int i = list.size() - 1; i >= 0 ; i--) {
//				
//				// 리스트에 담긴 노드(트리 구조상 최하위 레벨의 노드들)
//				Node node = list.get(i);
//				// 그 노드의 부모들을 추적해 마스크를 만든다
//				String mask = tree.chase(node);
//				
//				for (int j = 0; j < mask.length(); j++) {
//					
//					switch (mask.charAt(j)) {
//					
//					case 'A' :
//						stack.push(top++);
//						break;
//						
//					case 'B' :
//						System.out.print(stack.pop() + " ");
//						break;
//						
//					}
//				}
//				top = 1;
//				System.out.println();
//				
//			}
			System.out.println("총 경우의 수 = " + list.size());
			System.out.println("-----------------------------");
			
		}
		System.out.println("** 프로그램 종료 **");
	}
	
}
