package positionListLLDirect;

import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptionClasses.EmptyListException;
import positionInterfaces.Position;
import positionInterfaces.PositionList;

public class PositionListElementsBackwardIterator<E> implements Iterator<E> {

	private Position<E> current; 
	private PositionList<E> theList;
	
	public PositionListElementsBackwardIterator(PositionList<E> list) {
		// TODO Auto-generated constructor stub
		theList = list; 
		try { 
			current = theList.last(); 
		}
	    catch (EmptyListException e) { 
	    	current = null; 
	    }
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current!=null;
	}

	@Override
	public E next() {
		if (!hasNext()) 
			throw new NoSuchElementException("Iterator has past the end.");
		Position<E> ptr = current; 
		try { 
			current = theList.prev(current); 
		}
		catch (Exception e) { 
			current = null; 
		}
		return ptr.element();
	}

}
