import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        return pq.peek(); // kth largest
    }
}
