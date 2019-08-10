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

		while (n != 0) {
			
			do {
		
				// ------ n�Է¹ޱ� ------
				System.out.print("���� �Է� : ");
				
				n = sc.nextInt();
				System.out.println("�Է��� ���� : " + n);
				// ---------------------
			
			} while(n < 0 || n > 16);
	
			Node root = new Node("A");				// �ֻ��� ���� A(push)���� ����
			
			Tree tree = new Tree();					// Ʈ�� ����
			tree.addChild(root, n, 0);				// �ڽ� ������ �����
	
			// ������ ������ ���(�ܸ� ���)���� ���� ����Ʈ
			ArrayList<Node> list = tree.getLastList();
			
			// ����Ʈ�� ��� ����� ������ŭ �ݺ�
			for (int i = list.size() - 1; i >= 0 ; i--) {
				
				// ����Ʈ�� ��� ��带 �ϳ��� ������
				Node node = list.get(i);
				
				// �� ����� �θ���� ������ ����ũ�� �����
				String mask = tree.chase(node);
				
				// ����ũ ���ڿ��� ���̸�ŭ �ݺ�
				for (int j = 0; j < mask.length(); j++) {
					
					switch (mask.charAt(j)) {
					
					// ���ڰ� A�� push
					case 'A' :
						stack.push(top++);
						break;
						
					// ���ڰ� B�� pop
					case 'B' :
						System.out.print(stack.pop() + " ");
						break;
						
					}
					
				}
				
				top = 1;
				System.out.println();
				
			}
			
			System.out.println("�� ����� �� = " + list.size());
			System.out.println("-----------------------------");
			
		}
		System.out.println("** ���α׷� ���� **");
	}
	
}