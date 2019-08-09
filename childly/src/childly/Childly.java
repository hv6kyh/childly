package childly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Childly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);	// ǥ�� �Է��� ���� ��ĳ�� ��ü �̿�
		Stack<Integer> stack = new Stack<>();	// ���� ����

		int top = 1;							// ���ÿ� ���� ����
		int n = -1;								// ����ڿ��� �Է� �޴� ����
		
		String masks[];

		
		while (n != 0) {
			
			do {
		
				// ------ n�Է¹ޱ� ------
				System.out.print("���� �Է� : ");
				
				n = sc.nextInt();
				System.out.println("�Է��� ���� : " + n);
				// ---------------------
			
			} while(n < 0 || n > 16);
	
			Node root = new Node("A");				// �ֻ��� ���� A(push)���� ����
			
			Tree tree = new Tree();
			tree.addChild(root, n, 0);				// A�� B�� ������ ���� �ڽ� ������ �����
	
			ArrayList<Node> list = tree.getLastList();
			
			// ����ũ�� �����ϴ� �迭�� �ִ�.
			// �迭�� ũ��� ���� ����� ������ ����
			masks = new String[list.size()];
			
			// �迭�� ����ũ�� ä���
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
//				// ����Ʈ�� ��� ���(Ʈ�� ������ ������ ������ ����)
//				Node node = list.get(i);
//				// �� ����� �θ���� ������ ����ũ�� �����
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
			System.out.println("�� ����� �� = " + list.size());
			System.out.println("-----------------------------");
			
		}
		System.out.println("** ���α׷� ���� **");
	}
	
}
