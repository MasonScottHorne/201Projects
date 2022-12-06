import java.util.Stack;
public class StackSorting {
    //method to return stack in descending order and pop and push when required
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> sortStack = new Stack<Integer>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while(!sortStack.isEmpty()&&sortStack.peek()>temp){
                s.push(sortStack.pop());
            }
            sortStack.push(temp);
        }
        return sortStack;
    }
    //testing with new stack
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(4);
        s.add(9);
        s.add(41);
        s.add(92);
        s.add(60);
        s.add(89);
        Stack<Integer> sortStack = sort(s);
        System.out.println("Sorted: ");
        while(!sortStack.isEmpty()){
            System.out.println(sortStack.pop()+" ");
        }

    }
}