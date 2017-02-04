# ArrayIterator by Nitith Chayakul
  
## ArrayIterator
This is an ArrayIterator class that provide Iterator for any array!  
This class has 3 method
  
### next()
This method return the next non-null element in the array.
If there are no elements, it throw NoSuchElementException.
  
### hasNext()
Retrun true if next() can retrun another non-null array element
, false if no more elements.
  
### remove()
Remove most recent element return by next() from the array by setting it to null. This method can only be called once after a call to next(). If not it will throw IllegalStateException.