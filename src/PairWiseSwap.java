public class PairWiseSwap{	
		private static class Node{
		int value;
		Node next;
	}

		private static Node createLinkedList(int[] arr){
		Node prev = null;
		for (int i=arr.length-1;i>=0 ;i-- ) {
			Node node = new Node();
			node.value = arr[i];
			node.next = prev;
			prev = node;
		}

		return prev;
	}
	private static void printLL(Node head){
		Node ptr = head;
		while(ptr!=null){
			System.out.print(ptr.value);
			ptr = ptr.next;
			if(ptr!=null)System.out.print("->");
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = createLinkedList(arr);
		Node head1 = pairWiseSwap(head);
		printLL(head1);
	}
	//1->2->3->4->5
	//2->1->3->4->5
	//2->1->4-3->5
	private static Node pairWiseSwap(Node head){
		Node ptr = head;
		Node current = head;
		while(current.next !=null){
			Node tmp = current.next; //2
			current.next = tmp.next;//1->3
			tmp.next = current;//2->1
			current = current.next;
		}
		
		return ptr;
	}


}