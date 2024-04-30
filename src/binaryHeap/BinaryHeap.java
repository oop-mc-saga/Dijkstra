package binaryHeap;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Heap
 *
 * @author tadaki
 * @param <T> stored object class
 */
public class BinaryHeap<T extends Comparable<T>> {

    private final List<T> list; // list to store objects
    private int n = 0; // number of objects

    public BinaryHeap() {
        list = new LinkedList<>();
        // Add null object at zero-th position
        list.add(null);
    }

    /**
     * put a new object into this binary heap
     *
     * @param t
     */
    public void put(T t) {
        list.add(t);// add the new object at the end
        n++;// increment the number of objects
        shiftUp(n);
    }

    /**
     * get the smallest object and remove it from this binary heap
     *
     * @return
     */
    public T getMinimum() {
        T t = list.get(1);// the smallest object
        T x = list.remove(n);// the last object
        n--;
        // put the last object to the top and shift it down
        if (n > 0) {
            list.set(1, x);
            shiftDown(1);
        }
        return t;
    }

    /**
     * Confirm this binary heap empty
     *
     * @return
     */
    public boolean isEmpty() {
        // Note that the zero-th element is null
        return (list.size() <= 1);
    }

    /**
     * Confirm whether this binary heap contains the object t
     * 
     * @param t
     * @return
     */
    public boolean contains(T t){
        return list.contains(t);
    }

    /**
     * reduce the value of the object t
     * 
     * @param t
     */
    public void reduceValue(T t){
        int k = list.indexOf(t);// the position of the object
        shiftDown(k);// shift down the object
    }
    
    /**
     * shift up the object at k-th position
     * 
     * @param k
     */
    private void shiftUp(int k) {
        int j = k / 2;// the position of the parent
        if (k > 1 && less(k, j)) {// if the parent is larger
            swap(k, j);
            shiftUp(j);
        }
    }

    /**
     * shift down the object at k-th position
     * 
     * @param k
     */
    private void shiftDown(int k) {
        if (2 * k <= n) {// if the object has a child
            int j = 2 * k;// the position of the left child
            if (j < n && less(j + 1, j)) {// if the right child is smaller than the left child 
                j++;
            }
            if (less(k, j)) {// if the object is smaller than the child
                return;// do nothing
            }
            swap(k, j);
            shiftDown(j);
        }
    }

    private boolean less(int k, int j) {
        return (list.get(k).compareTo(list.get(j)) < 0);
    }

    private void swap(int k, int j) {
        T t = list.get(k);
        list.set(k, list.get(j));
        list.set(j, t);
    }
}
