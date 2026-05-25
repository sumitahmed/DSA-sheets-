public class myQueue {
    int end, start, arr[];
    int currSize, size;

    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        end = -1; start =-1;
        size = n;
        arr = new int[n];
        currSize=0;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        if(currSize==0) return true;
        else return false;
    }

    public boolean isFull() {
        // Check if queue is full
        if(currSize==size) return true;
        else return false;
    }

    public void enqueue(int x) {

    // If queue is already full,
    // we cannot insert more elements
    if (isFull()) {
        return;
    }

    // If queue is empty,
    // this is the FIRST element being inserted
    if (currSize == 0) {

        // Front and Rear both point
        // to index 0
        start = 0;
        end = 0;
    }

    // Otherwise queue already has elements
    else {

        // Move rear one step forward
        // % size makes queue circular
        end = (end + 1) % size;
    }

    // Insert element at rear
    arr[end] = x;

    // Increase current size
    currSize++;
}

    public void dequeue() {

    // If queue is empty,
    // nothing to remove
    if (isEmpty()) {
        return;
    }

    // If queue has only ONE element
    if (currSize == 1) {

        // After deletion queue becomes empty
        // so reset both pointers
        start = -1;
        end = -1;
    }

    // Otherwise move front forward
    else {

        // Move start one step ahead
        // % size keeps circular movement
        start = (start + 1) % size;
    }

    // Reduce size after deletion
    currSize--;
}

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return arr[start];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()) return -1;
        return arr[end];
    }
}
 {
    
}
