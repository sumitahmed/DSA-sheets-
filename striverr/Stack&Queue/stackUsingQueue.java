/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 
/*
q.offer(x)   // insert
q.poll()     // remove
q.peek()     // front element
q.size()     // size
q.isEmpty()  // checks empty
*/

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q= new LinkedList<>();
    }
    
    public void push(int x) {
        int s=q.size();

        //insert a new element
        // q.push(x);
        q.offer(x);

        for(int i=0;i<s;i++){
            q.offer(q.poll()); //q.push(q.pop())
        }
    }
    
    public int pop() {
        return q.poll(); //q.pop;
    }
    
    public int top() {
        return q.peek(); //q.top;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
