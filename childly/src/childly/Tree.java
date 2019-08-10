package childly;

import java.util.ArrayList;

class Node {

	// �� ������ �ڽ��� ���� ���� ���, �ڽ� ��带 �ʵ�� ������
	private String data;
	private Node parent;
	private Node left;
	private Node right;

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node(String data) {
		super();
		this.data = data;
	}
	
}

public class Tree {

	private int level = 0;		// ����� ����
	private ArrayList<Node> lastList = new ArrayList<>();		// �ܸ� ������ ��� ����Ʈ
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<Node> getLastList() {
		return lastList;
	}
	
	// A�� B�� ������ �����
	// ��� ȣ�� ������� �ڽ� ������ �����Ѵ�
	public void addChild(Node node, int n, int level) {
		
		/*
		 * push �ൿ�� ���ĺ� A, pop �ൿ�� ���ĺ� B��� ����������
		 * A�� B�� ������ ���ƾ��ϸ�, A�� B�� �����Ҷ� �ռ��� A�� ������ B�� �������� ���ų� ���ƾ��Ѵ�
		 * A�� ������ n���� �۰ų� ���ƾ��Ѵ�
		 */

		int a = countChar(node, 'A');
		int b = countChar(node, 'B');
		
		// � ��尡 A��带 �ڽ����� ���� ����
		if (n > a) {
			Node childNode = new Node("A");
			node.setLeft(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);		// ������ �ڽĳ�带 �ٽ� �Ű������� ����
		}
		
		// � ��尡 B��带 �ڽ����� ���� ����
		if (a > b) {
			Node childNode = new Node("B");
			node.setRight(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);
		}
		
		// Ư��, �ܸ� ����� ����Ʈ�� ����
		// ������ ������ n*2-1
		if (level == n*2-1) {
			lastList.add(node);
		}
		
	}
	
	/*
	public void clearTree(Node node) {
		
		if (node.getLeft() != null) {
			Node leftNode = node.getLeft();
			node.setLeft(null);
			clearTree(leftNode);
		}
		
		if (node.getRight() != null) {
			Node rightNode = node.getRight();
			node.setRight(null);
			clearTree(rightNode);
		}
		
		node = null;
		
	}
	*/
	
	// �Ű������� ���� � ��忡 ���Ͽ�
	// �� ����� ���� ������ �����Ͽ�
	// �� ������ ���ڿ��� �����
	public String chase(Node node) {
		
		if (node == null) {
			return "";
		}
		else {
			return chase(node.getParent()) + node.getData();
		}
		
	}
	
	// A�� B�� ������ ���µ� �ʿ��� �޼ҵ�
	public int countChar(Node node, char ch) {
		
		String tmp = chase(node);
		int cnt = 0;
		
		for (int i = 0; i < tmp.length(); i++) {
			
			if (tmp.charAt(i) == ch)
				cnt++;
			
		}
		
		return cnt;
		
	}
	
	// ��� ��ȸ
	public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.println(node);
            inOrder(node.getRight());
        }
    }

}
