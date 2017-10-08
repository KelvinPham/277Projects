import java.util.ArrayList;

/**
 * Class functions as a generic heap 
 * @author Kelvin
 * @param <T>  the generic parameter used in our heap
 */
public class Heap<T extends Comparable<T>> {
	/**
	 * where we store our heap first
	 */
	private ArrayList<T> heap;

	/**
	 * constructor of our heap
	 */
	public Heap() {
		heap = new ArrayList<T>();
	}

	/**
	 * accessor for the heaps size
	 * @return size of heap
	 */
	public int getSize() {
		return heap.size();
	}

	/**
	 * check if there is data in our heap
	 * @return true if there is no data
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	/**
	 * method gets the parent location
	 * @param i the current location
	 * @return parent location
	 */
	public int getPLoc(int i) {
		return (i - 1) / 2;
	}

	/**
	 * method obtains the left child location
	 * @param i our current location
	 * @return left child location
	 */
	public int getLCLoc(int i) {
		return 2 * i + 1;
	}

	/**
	 * method obtains the right childs location
	 * @param i current location
	 * @return the location of right child
	 */
	public int getRCLoc(int i) {
		return 2 * i + 2;
	}

	/**
	 * method gets the data at a certain location
	 * @param i the location of data
	 * @return the data at location
	 */
	public T getTAt(int i) {
		if (heap.get(i) == null) {
			System.out.println("Item does not exist.");
			return null;
		} else {
			return heap.get(i);
		}
	}

	/**
	 * adds a new data to the heap
	 * @param t data being added
	 */
	public void add(T t) {
		heap.add(null);
		int index = heap.size() - 1;
		while (index > 0 && getTAt(getPLoc(index)).compareTo(t) > 0) {
			heap.set(index, getTAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, t);
	}

	/**
	 * removes the min from the heap and reorganizes it
	 * @return the min that was removed
	 */
	public T removeMin() {
		T min = heap.get(0);
		int index = heap.size() - 1;
		T last = heap.remove(index);
		if (index > 0) {
			heap.set(0, last);
			T root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done) {
				if (getLCLoc(index) <= end) {// left exists
					T child = getTAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if (getRCLoc(index) <= end) {// rt exists
						if (getTAt(getRCLoc(index)).compareTo(child) < 0) {
							child = getTAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.compareTo(root) < 0) {
						heap.set(index, child);
						index = childLoc;
					} else {
						done = true;
					}
				} else {// no children
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}

	/**
	 * prints the heap
	 */
	public void printHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.print(i + ") " + heap.get(i) + " ");
			System.out.println();
		}

	}
}