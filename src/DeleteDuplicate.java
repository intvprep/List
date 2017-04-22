public class DeleteDuplicate{
	
	private static class Node{
		int value;
		Node next;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,2,2,3,4,4,4,5,5,5,5};
		Node head = createLinkedList(arr);
		//printLL(head);

		Node head1 = deleteDuplicate(head);

		printLL(head1);
	}

	private static Node deleteDuplicate(Node head){
		Node ptr = head;
		Node current = ptr;
		while(current.next!=null){
			if(current.value == current.next.value){
				current.next = current.next.next;
			}else{
				current = current.next;
			}

		}

		return ptr;
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
}