class myStack {
    
    int top;
    int arr[];
    int size;
    public myStack(int n) {
        // Define Data Structures
        top=-1;
        size=n;
        arr= new int[size];
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if(top== -1) return true;
        else return false;
    }

    public boolean isFull() {
        // check if the stack is full
        if(top==size-1) return true;
        else return false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()){
            return;
        }
        top = top+1;
        arr[top] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()){
            return;
        }
        top =top-1;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }
}

public class Main {
    public static void main(String[] args) {

        myStack s = new myStack(5);

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.peek()); // 30

        s.pop();

        System.out.println(s.peek()); // 20
    }
}