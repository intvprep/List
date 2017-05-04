public class NumberToLinkedList {
	public static void main(String[] args) {
		int n = 877;
		Node head = numberToLinkedList(n);		
		while(head!=null){
			System.out.print(head.data);
			if(head.next!=null)
				System.out.print("->");
			head = head.next;
		}
	}
	
	public static Node numberToLinkedListReverse(int n){
		Node dummy = new Node(0);
		Node current = dummy;
		while(n>0){
			Node node = new Node((n%10));
			current.next = node;
			current = node;
			n=n/10;
		}
		return dummy.next;
	}
	
	public static Node numberToLinkedList(int n){
		Node head = numberToLinkedListReverse(n);
		Node prev = null;
		Node current = head;
		Node tmp = null;
		while(current!=null){
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		return prev;
	}
	private static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
}