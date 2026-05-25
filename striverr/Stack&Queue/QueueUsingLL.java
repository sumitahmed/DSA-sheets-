// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    Node start, end;
    int size;

    public myQueue() {
        // Initialize your data members
        start =null;
        end=null;
        size=0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        if(start ==null) return true;
        else return false;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        Node temp = new Node(x);
        if(start==null) //first el
        {
            start =temp;
            end=temp;
        }else{
            
        end.next = temp;
        end = temp; //move rear forward
        }
        
        size+=1;
    }

    public void dequeue() {
        // Removes the front element of the queue
        if(start ==null){
            return;
        }
        
        start = start.next;
        size -=1;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if(isEmpty()){
            return -1;
        }
        return start.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return size;
    }
}
