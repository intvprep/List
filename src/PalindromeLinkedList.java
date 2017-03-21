

public class PalindromeLinkedList {
	
	
	
	
	private static class Node{
		Node nextNode;
		String data;
		
	
	}
	
	public static void main(String[] args) {
		String[] arr = {"ramdas","sawant","nana","sawant","ramdas"};
		
		Node head = createLinkedList(arr);
		
//		while(head!=null){
//			System.out.println(head.data);
//			head = head.nextNode;
//		}
		
		boolean isPalindrome = checkForPalindrome(head);
			
	}

	private static boolean checkForPalindrome(Node head) {
		//printList(head);
		Node fast = head;
		Node slow = head;
		while(fast.nextNode!=null && fast.nextNode.nextNode!=null){
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		System.out.println("slow ptr: "+slow.data);
		System.out.println("fast ptr: "+fast.data);
		Node mid = slow;
//		System.out.println(head.data);
		Node secondHalfReversed = reverse(slow.nextNode);
		
		//printList(secondHalfReversed);
		Node firstpart = head;
		
		//while(firstpart);
		
		return false;
	}

	public static void printList(Node node){
		Node tmp = node;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.nextNode;
		}
	}
	
	private static Node createLinkedList(String[] arr) {
		Node next = null;
		for (int i = arr.length-1; i >=0; i--) {
			Node node = new Node();
			node.data = arr[i];
			node.nextNode = next;
			next = node;
		}
		return next;
	}
	
	//1->2->3->4->5
	//slow 3
	//1->2->3->4
	//slow 2
	//String[] arr = {"ramdas","sawant","nana2","sawant","ramdas"};
	private static Node reverse(Node node){
		Node tmp = node;
		Node prev = null;
		while(tmp!=null){
			Node n = new Node();
			n.data = tmp.data;
			n.nextNode = prev;
			prev = n;
			tmp = tmp.nextNode;
		}
		
		return prev;
	}
}
