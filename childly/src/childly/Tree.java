package childly;

import java.util.ArrayList;

class Node {

	// 각 노드들은 자신의 값과 상위 노드, 자식 노드를 필드로 가진다
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

	private int level = 0;		// 노드의 레벨
	private ArrayList<Node> lastList = new ArrayList<>();		// 단말 노드들을 담는 리스트
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<Node> getLastList() {
		return lastList;
	}
	
	// A와 B의 개수를 계산해
	// 재귀 호출 방식으로 자식 노드들을 생성한다
	public void addChild(Node node, int n, int level) {
		
		/*
		 * push 행동을 알파벳 A, pop 행동을 알파벳 B라고 생각했을때
		 * A와 B의 개수는 같아야하며, A와 B를 나열할때 앞서는 A의 개수가 B의 개수보다 많거나 같아야한다
		 * A의 개수는 n보다 작거나 같아야한다
		 */

		int a = countChar(node, 'A');
		int b = countChar(node, 'B');
		
		// 어떤 노드가 A노드를 자식으로 가질 조건
		if (n > a) {
			Node childNode = new Node("A");
			node.setLeft(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);		// 생성한 자식노드를 다시 매개변수로 전달
		}
		
		// 어떤 노드가 B노드를 자식으로 가질 조건
		if (a > b) {
			Node childNode = new Node("B");
			node.setRight(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);
		}
		
		// 특히, 단말 노드라면 리스트에 저장
		// 마지막 레벨은 n*2-1
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
	
	// 매개변수로 받은 어떤 노드에 대하여
	// 그 노드의 상위 노드들을 추적하여
	// 그 값들을 문자열로 만든다
	public String chase(Node node) {
		
		if (node == null) {
			return "";
		}
		else {
			return chase(node.getParent()) + node.getData();
		}
		
	}
	
	// A와 B의 개수를 세는데 필요한 메소드
	public int countChar(Node node, char ch) {
		
		String tmp = chase(node);
		int cnt = 0;
		
		for (int i = 0; i < tmp.length(); i++) {
			
			if (tmp.charAt(i) == ch)
				cnt++;
			
		}
		
		return cnt;
		
	}
	
	// 노드 순회
	public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.println(node);
            inOrder(node.getRight());
        }
    }

}
