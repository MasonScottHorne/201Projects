public class DLinkedList implements MyList {

    @Override
    //prepend node to front
    public void prepend(Object item) {
        Node newNode = new Node(item);
        if (size < 0){
            System.out.println("Error index out of bounds");
        }
        if (size == 0) {
        head = newNode;
        tail = newNode;
      }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }//increasing size
        size++;
    }
    @Override
    //removes first at index
    public Object removeFirst() {
        if (size < 0){
            System.out.println("Error index out of bounds");
        }
        if (size == 0)
            return null;
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
        return temp;
    }
    //insert at a specified index
    @Override
    public boolean insert(int index, Object item) {
        //checking and returning false if there is an index bounds problem boolean so I can't return void
        if (index < 0 || index > size) return false;
        {
            if (index == 0) {
                prepend(item);
                return true;
            }
            if (index == size) {
                append(item);
                return true;
            }
            Node newNode = new Node(item);
            Node before = get(index - 1);
            Node after = before.next;
            newNode.prev = before;
            newNode.next = after;
            before.next = newNode;
            after.prev = newNode;
            size++;
        }
        return false;
    }
    @Override
    //appending the item at the end
    public void append(Object item) {
      Node newNode=new Node(item);
      if (size < 0){
          System.out.println("Error index out of bounds");
      }
      if(size==0) {
          head = newNode;
          tail = newNode;
      }    else{
              tail.next = newNode;
              newNode.prev = tail;
              tail = newNode;
          }
      size++;
      }
    @Override
    //removing the last element
    public Object removeLast(){
        if (size < 0){
            System.out.println("Error index out of bounds");
        }
        if(size==0) return null;
        Node temp = tail;
        if(size==1){
            head=null;
            tail=null;
        }
        else{
            tail = tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        size--;
        return temp;
    }
    @Override
    //deleting the whole DLL
    public void clear() {
        //giving error message
        if (size < 0){
            System.out.println("Error index out of bounds this is already empty");
        }
        Node temp = new Node();
        while (this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
    }
    //checking if it is Empty
    @Override
    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }
    //getting the size of the DLL
    @Override
    public int size() {
        return size;
    }
    //replace an item at a specified index
    @Override
    public void replace(int index, Object item) {
        Node temp = get(index);
        temp.next.prev=temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        Node newNode = new Node(item);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
    }
    //remove an item at the specified index
    @Override
    public Object remove(int index) {
        //error and returning message
        if(index <0 || index >= size) System.out.println("ERROR! Out of bounds");;
        if(index == 0) return removeFirst();
        if(index == size-1) return removeLast();
        Node temp = get(index);
        temp.next.prev=temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        size--;
        return temp;
        }
    @Override
    //get the item temp at the index returning the item temp at the index
    public Node get(int index) {
        if(index<0 || index>=size) return null;
        Node temp = head;
        if(index<size/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else{
                temp = tail;
                for(int i =size-1; i>index; i--){
                    temp = temp.prev;
                }
            }
        return temp;
        }
    // define any variables you want using the Encapsulation design principle.
    Node head = null;
    Node tail = null;
    int size = 0;

    private class Node {
        Object obj;
        Node next;
        Node prev;
        public Node(){
            this.obj = obj;
            this.next = next;
            this.prev = prev;
        }
        public Node(Object obj){
            this.obj = obj;
        }
    }
}