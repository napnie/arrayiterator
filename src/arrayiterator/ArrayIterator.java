package arrayiterator;
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
	/** attribute to remember remove() has been call or not  */
	private boolean hasRemove;
	/** attribute to remember most recent element return by next() for remove() */
	private int previousCursor;

	/**
	 * Initialize a  new array iterator with array
	 * @param array is the array to iterate
	 */
	public ArrayIterator(T[] array){
		this.array = array;
		cursor = 0;
		hasRemove = false;
	}

	/**
	 * Return the next non-null element in the array.
	 * @return array element that cursor currently point
	 * @exception if there are no more elements
	 */
	public T next(){
		if ( !hasNext() ){
			throw new NoSuchElementException();
		}
		hasRemove = true;
		previousCursor = cursor;
		return array[cursor++];
	}

	/**
	 * Check if array has next non-null element.
	 * Automatically skip non-null elements.
	 * @return false if element no longer has non-null elements
	 */
	public boolean hasNext(){
		if (array[cursor+1]!=null){
			return true;
		}else{
			if (cursor<array.length){
				cursor++;
				hasNext();
			}
			return false;
		}
	}
	
	/**
	 * Remove most element return by next() by setting it to null.
	 * Can only be call once after a call to next().
	 * @exception if this method is called without calling next() or called more than once after calling next()
	 */
	public void remove(){
		if ( !hasRemove ){
			array[previousCursor] = null;
		}else{
			throw new IllegalStateException();
		}
	}
}
