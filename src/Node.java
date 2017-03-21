public class Node {
	public Node nextNode;
	public String data;
	
	public static Node createLinkedListFromArray(String[] arr){
		Node prev = null;
		for(int i=arr.length-1;i>=0;i--){
			Node n = new Node();
			n.data=arr[i];
			n.nextNode=prev;
			prev = n;
		}
		
		return prev;
	}
}
