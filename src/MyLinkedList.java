
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class MyLinkedList implements List {
	
	private int size = 0;
	
	private Node head;
	
	private Node tail;
	
	LinkedList<String> forRef;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(String str) {
		Node tmp = head;
		while(tmp.getNextNode()!=null){
			if(str == null){
				return str == tmp.getData();
			}else{
				str.equals(tmp.getData());
			}
			tmp = tmp.getNextNode();
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = head;
		size = 0;

	}

	@Override
	public void add(String str) {
		addLast(str);
	}

	@Override
	public void remove(String str) {
		if(isEmpty())return;
		if(head.getData().equals(str)){
			removeFirst();
		}else if(tail.getData().equals(str)){
			removeLast();
		}else{
			Node tmp = head;
			while(tmp!=null){
				if(tmp.getNextNode() !=null && tmp.getNextNode().getData().equals(str)){
					tmp.setNextNode(tmp.getNextNode().getNextNode());
					size--;
					return;
				}
				tmp = tmp.getNextNode();
			}
		}
	}

	@Override
	public void addFirst(String str) {
		head = new Node(str,head);
		if(isEmpty()){
			tail = head;
		}
		size++;

	}

	@Override
	public void removeFirst() {
		if(isEmpty())return;
		head = head.getNextNode();
		size--;
		if(isEmpty())tail = head;

	}

	@Override
	public void addLast(String str) {
		
		if(isEmpty()){
			addFirst(str);
		}else{
			Node newTail = new Node(str,null);
			tail.setNextNode(newTail);
			tail = newTail;
			size++;
		}
	}

	@Override
	public void removeLast() {
		if(isEmpty())return;
		if(size==1){
			removeFirst();
		}else{
			Node tmp = head;
			while(tmp.getNextNode().getNextNode()!=null){
				tmp = tmp.getNextNode();
			}
			tmp.setNextNode(null);
			tail = tmp;
			size--;
		}
	}

	@Override
	public void addAfter(String afterThis, String strToAdd) {
		if(tail.getData().equals(afterThis)){
			addLast(strToAdd);
		}else{
			Node tmp = head;
			while(tmp!=null){
				if(tmp.getData().equals(afterThis)){
					Node newNode = new Node(strToAdd,tmp.getNextNode());
					tmp.setNextNode(newNode);
					size++;
					return;
				}
			}
		}

	}

	@Override
	public int indexOf(String str) {
		int i=0;
		Node ptr = head;
		while(ptr!=null){
			if(ptr.getData().equals(str)){
				return i;
			}
			ptr = ptr.getNextNode();i++;
		}
		return -1;
	}

	@Override
	public Iterator<String> iterator() {
	
		return null;
	}

	private static class Node{
		private String data;
		
		private Node nextNode;
		
		public Node(String data, Node nextNode){
			this.data = data;
			this.nextNode = nextNode;
		}
		
		public String getData(){
			return data;
		}
		
		public Node getNextNode(){
			return nextNode;
		}
		
		public void setNextNode(Node nextNode){
			this.nextNode = nextNode;
		}
	}
	
	public void reverse(){
		//head = reverse(head,null);
		reverseStack(head);
		//reverseExtraPointer();
	}
	
	private void reverseExtraPointer(){
		if(head == null) return;
		if(head.getNextNode() == null) return;		
		Node current = head;
		Node previous = null;
		while(current !=null){
			Node next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;			
		}
		head = previous;
	}
	
//	private Node reverse(Node head2) {
//		if(head2==null)return null;
//		if(head2.getNextNode()==null) return head2;
//		Node secNode = head2.getNextNode();
//		head2.setNextNode(null);
//		Node revRest = reverse(secNode);			
//		secNode.setNextNode(head2);
//		return revRest;
//	}
	
	  private Node reverse(Node n,Node p){   
	        if(n==null) return null;
	        if(n.getNextNode()==null){ //if this is the end of the list, then this is the new head
	            n.setNextNode(p);
	            return n;
	        }
	        Node r=reverse(n.getNextNode(),n);  //call reverse for the next node, 	                                      //using yourself as the previous node
	        n.setNextNode(p);                     //Set your next node to be the previous node 
	        return r;                     //Return the head of the new list
	    }	

	private void reverseStack (Node head){
		Stack<Node> stack = new Stack<>();
		Node ptr = head;
		while(ptr != null){			
			stack.push(ptr);
			ptr = ptr.getNextNode();
		}
		
		head = ptr;
		while(!stack.isEmpty()){
			Node current =  stack.pop();
			ptr.setNextNode(current);
			ptr = current;
		}
		ptr.setNextNode(null);
	}

	@Override
	public String getFirst() {
		
		return head==null?null:head.getData();
	}

	@Override
	public String getLast() {
		
		return tail==null?null:tail.getData();
	}
	
	@Override
	public String toString() {
		Node tmp = head;
		StringBuffer b = new StringBuffer();
		b.append("[");
		while(tmp!=null){
			b.append(tmp.getData());
			tmp = tmp.getNextNode();
			if(tmp!=null)b.append(",");
		}
		b.append("]");
		return b.toString();
	}
}
