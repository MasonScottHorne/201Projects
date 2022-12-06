import java.util.Stack;

public class WeirdQueue<Object>{

    public WeirdQueue(){
        Stack s1 = new Stack<Object>();
        Stack s2 = new Stack<Object>();
    }
    //enqueue method pushes the item enqueue style
    public void enqueue(Stack s1,Object item){
        //error check
        if(s1.size()==0){
            System.out.println("Error Queue is already empty");
        }
        s1.push(item);

    }
    //dequeue method returns object that is popped
    public Object dequeue(Stack s1, Stack s2){
        //error check
        if (s1.size()==0) {
            System.out.println("Error Queue is already empty");
            return null;
        }
        //if it is empty then dequeue
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        //return the popped
        return (Object) s2.pop();
    }
}