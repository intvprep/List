

public class FindNthFromLastNode {
	
	public static void main(String[] args) {
		String data[] = {"ramdas","nana","sawant","kartik","amita","gunjal"};
		Node head = Node.createLinkedListFromArray(data);
		printList(head);
		printList(reverseList(head));	
//		System.out.println(findNthFromLast(head, 3));
//		printList(moveLastToFront(head));
		
//		addLast(head, "last");
		insertInPosition(head, "Abby", 2);
//		printList(head);
	}
	
	
	//  0       1    2       3       4        5
	//ramdas->nana->sawant->kartik->amita->gunjal->null
	public static String findNthFromLast(Node head,int n){
		Node main = head;
		Node ref = head;
		int i=0;
		while(i<n){
			ref = ref.nextNode;
			i++;
		}
		while(ref!=null){
			ref = ref.nextNode;
			main = main.nextNode;
		}
		return main.data;
	}
	
	public static Node insertInPosition(Node head,String data, int position){
		Node ptr = head;
		int n=0;
		while(n<position){
			ptr = ptr.nextNode;
			n++;
		}
		System.out.println(ptr.data);
		
		return head;
		
	}
	
	public static Node reverseList(Node head){
		Node prev = null;
		Node current = head;
		while(current!=null){
			Node n = new Node();
			n.data = current.data;
			n.nextNode = prev;
			prev = n;
			current = current.nextNode;
		}		
		return prev;
	}
	
	public static void printList(Node head){
		System.out.println();
		Node ptr = head;
		while(ptr!=null){
			System.out.print(ptr.data);
			ptr = ptr.nextNode;
			if(ptr!=null)
				System.out.print("->");
		}
		System.out.println();
	}
	//ramdas->nana->sawant->kartik->amita->gunjal->null
	
	//gunjal->ramdas->nana->sawant->kartik->amita->null
	public static Node moveLastToFront(Node head){
		Node last = head;
		Node secLast = null;
		while(last.nextNode!=null){
			secLast = last;
			last = last.nextNode;
		}
		secLast.nextNode = null;
		last.nextNode = head;		
		return last;
	}
	public static void addLast(Node head, String data){
		Node ptr = head;
		while(ptr.nextNode !=null){
			ptr = ptr.nextNode;
		}
		Node newTail = new Node();
		newTail.data = data;
		ptr.nextNode = newTail;
	}
	

}
