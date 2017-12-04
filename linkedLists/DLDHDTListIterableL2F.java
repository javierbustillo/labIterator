package linkedLists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTListIterableL2F<E> extends DLDHDTList<E> 
									  implements Iterable<E> 
{
	public Iterator<E> iterator() {
		return new LLIteratorF2L<E>(this);
	}

	private static class LLIteratorF2L<E> 
	implements Iterator<E> 
	{ 
		private LinkedList<E> theList;   // the list to iterate over
		// ... other internal fields ...
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorF2L(LinkedList<E> list) {
			theList = list; 
			if(list.length()==0) {
				current = null;
				hasMoreElements = false;
			}
			else {
				current = list.getLastNode();
				hasMoreElements = true;
			}
		}

		public boolean hasNext() {
			// Write the new code and substitute next statement ....
			return hasMoreElements; 
		}

		public E next() throws NoSuchElementException {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E tmp = current.getElement();
			try {
				current = theList.getNodeBefore(current);
			}
			catch(NodeOutOfBoundsException e) {
				current = null;
				hasMoreElements = false;
			}
			return tmp;
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

		}
	}

}
