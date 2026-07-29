
public class ArrayListBootleg<E> {

	private Object[] array;
	
	private int arraySize = 0;
	
	private int capacity;
	
	
	ArrayListBootleg(int size) {
		
		array = new Object[size];
		capacity = size;
		
	}
	
	// Increases the array's size
	private void checkCapacity() {
		if(arraySize < capacity) return;
		
		Object[] temp = new Object[capacity*2];
		
		for(int a = 0; a < capacity; a++)
			temp[a] = array[a];
		
		array = temp;
		
		
	}
	
	/**Adds the given value to the list. */
	public void add(E value) {
		
		array[arraySize] = value;
		arraySize++;
		checkCapacity();
	}
	
	
	/**Inserts the given value into the list at the specified index. */
	public void addAt(E value, int index) {
		arraySize++;
		checkCapacity();
		
		for(int i = capacity-1; i > index; i--)
			array[i] = array[i - 1];
		
		array[index] = value;
		
	}
	
	/**Adds the given array to the list. */
	public void addArray(E[] values) {
		
		for(int n = arraySize, i = 0; i < values.length; n++, i++ )
		{
			array[n] = values[i];
			arraySize++;
			checkCapacity();
		}
		
	}
	
	/**Inserts the given array into the list starting from the specified index.
	 * Primitive Data-Types must use wrapper classes.
	 * */
	public void addArrayAt(E[] values, int index) {
		arraySize += values.length-1;
		checkCapacity();
		
		for(int i = capacity -1; i > index + values.length - 1; i--)
			array[i] = array[i - 1];
		for(int n = index, i = 0; n < index + values.length;n++, i++)
			array[n] = values[i];
		
		
	}
	
	/**Removes the specified element from the list. */
	public void delete(int index) {
		for(int i = index; i < capacity - 1; i++)
			array[i] = array[i + 1];
		array[capacity - 1] = null;
		arraySize--;
	}
	
	/**Returns the current size of the list. */
	public int length() {
		
		return arraySize;
	}

	/**Gets the array value in the specified index.
	 * Returns null if asked to return an invalid index.
	 *  */
	public Object get(int index) {
		if(index < 0 || index >= arraySize)
			return null;
	
		return array[index];
	}
	
}
