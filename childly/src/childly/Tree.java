package childly;

import java.util.ArrayList;

class Node {

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

	private Node root;
	private int level = 0;
	// 각 레벨에 해당하는 노드들을 저장
	private ArrayList<Node> lastList = new ArrayList<>();
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<Node> getLastList() {
		return lastList;
	}
	public void addChild(Node node, int n, int level) {
	
		int a = countA(node);
		int b = countB(node);
		
		if (n > a) {
			Node childNode = new Node("A");
			node.setLeft(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);
		}
		
		if (a > b) {
			Node childNode = new Node("B");
			node.setRight(childNode);
			childNode.setParent(node);
			this.addChild(childNode, n, level+1);
		}
		// 자식 노드들을 만들다가, 특히 최하위 레벨의 노드라면 리스트에 저장함
		// 마지막 레벨은 n*2-1
		if (level == n*2-1) {
			lastList.add(node);
		}
		
	}
	
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
	
	public String chase(Node node) {
		
		if (node == null) {
			return "";
		}
		else {
			return chase(node.getParent()) + node.getData();
		}
		
	}
	
	public int countA(Node node) {
		
		if (node == null) {
			return 0;
		}
		else {
			
			if (node.getData() == "A") {
				return 1 + countA(node.getParent());
			}
			else {
				return countA(node.getParent());
			}
			
		}
	}
	
	public int countB(Node node) {
		
		if (node == null) {
			return 0;
		}
		else {
			
			if (node.getData() == "B") {
				return 1 + countB(node.getParent());
			}
			else {
				return countB(node.getParent());
			}
			
		}
	}
	
	public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.println(node);
            inOrder(node.getRight());
        }
    }

}
