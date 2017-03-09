package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class to iterate an elements in the array.
 * @author Nitith Chayakul
 * @since Feb 4, 2017
 */
public class ArrayIterator<T> implements Iterator<T>{
	/** attribute for array to iterate */
	private T[] array;
	/** attribute to remember its position in the collection */
	private int cursor;
	/** attribute to remember remove() has already been call or not  */
	private boolean legal;
	/** last element */
	private int lastCursor;

	/**
	 * Initialize a  new array iterator with array
	 * @param array is the array to iterate
	 */
	public ArrayIterator(T[] array){
		this.array = array;
		cursor = 0;
		legal = false;
	}

	/**
	 * Return the next non-null element in the array.
	 * @return array element that cursor currently point
	 * @exception NoSuchElementException if there are no more elements
	 */
	public T next(){
		if ( hasNext() ){
			legal = true;
			lastCursor = cursor;
			return array[cursor++];
		}else{
			throw new NoSuchElementException();
		}
	}

	/**
	 * Check if array has next non-null element.
	 * Automatically skip non-null elements.
	 * @return true if next element is not null , false if array no longer has non-null elements
	 */
	public boolean hasNext(){
		for (int i = cursor ; i < array.length ; i++){
			if (array[i]!=null){
				cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove most element return by next() by setting it to null.
	 * Can only be call once after a call to next().
	 * @exception IllegalStateException if this method is called without calling next() or called more than once after calling next()
	 */
	public void remove(){
		if ( legal ){
			array[lastCursor] = null;
			legal = false;
		}else{
			throw new IllegalStateException();
		}
	}
}
