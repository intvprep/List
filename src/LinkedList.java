

import java.util.Iterator;

public class LinkedList {
	
	private Node head;
	
	private Node tail;

	int size = 0;
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}
	public void addFirst(String str){
		
		
		if(isEmpty()){
			head = new Node(str,null);
			tail = head;
		}else{
			head = new Node(str,head);
		}
		size++;
	}
	
	public String getFirst(){
		if(isEmpty())return null;
		
		return head.getData();
	}
	
	public String getLast(){
		if(isEmpty()) return null;
		return tail.getData();
	}
	public void addLast(String str){
		Node newTail = new Node(str,null);
		if(isEmpty()){
			head = newTail;
			tail = head;
		}else{
			tail.setNext(newTail);
			tail  = newTail;
		}
		
		size++;
	}
	
	

	
	private static class Node{
		
		public Node nextNode;
		
		private String data;
		
		public Node(String  str, Node nextNode){
			this.data = str;
			this.nextNode = nextNode;
		}
		
		public String getData(){
			return data;
		}
		
		public void setNext(Node node){
			nextNode = node;
		}
		
		public Node getNext(){
			return nextNode;
		}
		
	}
	
	@Override
	public String toString() {
		Node nextNode = head;
		StringBuffer buffer = new StringBuffer();
		while(nextNode!=null){
			buffer.append(nextNode.getData());
			nextNode = nextNode.getNext();
			
		}
	
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		java.util.LinkedList<String> ll;
		LinkedList l = new LinkedList();
		l.addFirst("Austin");
		l.addFirst("Dallas");
		l.addLast("Houston");
		l.addFirst("Waco");
		l.addLast("George Town");
		System.out.println(l.getFirst());
		System.out.println(l);
		
		LinkedList l2 = new LinkedList();

		Iterator<String> it = l.getIterator();

		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public Iterator<String> getIterator(){
		
		
		return new Iterator<String>() {
			
			private Node nextNode = head;
			
			@Override
			public boolean hasNext() {
				if(nextNode != null){
					return true;
				}
				else{
					return false;
				}
			}
			
			@Override
			public String next() {
				String val = nextNode.getData();
				nextNode = nextNode.getNext();
				return val;
			}
		};
	}
}
