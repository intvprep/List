

import java.util.Iterator;


public interface List {
	int size(); //done
	boolean isEmpty();//done
	boolean contains(String str);
	void clear();
	void add(String str);
	void remove(String str);
	void addFirst(String str);
	String getFirst();
	void removeFirst();
	void addLast(String str);
	String getLast();
	void removeLast();
	void addAfter(String afterThis, String strToAdd);
	int indexOf(String str);	
	void reverse();
	Iterator<String> iterator();
	
}
