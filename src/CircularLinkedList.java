
public class CircularLinkedList {
	private Node tail;
	private int size = 0;
	
	public void addFirst(String str){
		if(isEmpty()){
			tail = new Node(str,null);
			tail.setNext(tail);
		}else{
			Node n = new Node(str,tail.getNext());
			tail.setNext(n);
		}
		size++;
		
	}
	
	public String getFirst(){
		if(isEmpty()) return null;
		return tail.getNext().getData();
	}
	public void removeFirst(){
		if(!isEmpty()){
			Node head = tail.getNext();
			if(head == tail){
				tail = null;
			}else{
				tail.setNext(head.getNext());
			}
			size--;
		}
	}
	
	public void addLast(String str){
		addFirst(str);
		tail = tail.getNext();
	}
	
	public String getLast(){
		if(isEmpty())  return null;		
		return tail.getData();
	}
	
	public void rotate(){
		if(tail!=null){
			tail = tail.getNext();
		}			
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	private static class Node{
		Node next;
		String data;
		public Node(String data,Node next){
			this.data = data;
			this.next = next;
		}
		
		public String getData(){
			return data;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public Node getNext(){
			return next;
		}
	}
}
