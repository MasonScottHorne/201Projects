public interface MyList{
    //insert 'item' at 'index'. Must rearrange pointers.
    public boolean insert(int index, Object item);
    //insert 'item' at the end of the list.
    public void append(Object item);


    //clear the entire list.
    public void clear();

    // return true if list is empty, false otherwise.
    public boolean isEmpty();

    // return the size of the list, else -1. Must require O(1) ops.
    public Object removeFirst();
    public int size();
    public void prepend(Object item);
    // replaces the existing Object  at 'index' with 'item'.
    // return true, if replace succeeds.
    // return false, otherwise.
    public void replace(int index, Object item);

    // removes the element at 'index'.
    public Object remove(int index);
    public Object removeLast();

    // return the element at 'index', if it exists.
    // return null otherwise.
    // Do not remove the item at 'index'.
    public Object get(int index);
}