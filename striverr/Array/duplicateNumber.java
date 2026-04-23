import java.util.*;

// utility with frequency-array duplicate finder
class Solution {
    // find the duplicate using a frequency array
    static int findDuplicate(int[] arr) {
        // get size
        int n = arr.length;
        // allocate frequency array initialized to 0
        int[] freq = new int[n + 1];
        // scan elements
        for (int i = 0; i < n; i++) {
            // return current value if already seen
            if (freq[arr[i]] == 0) {
                // mark as seen
                freq[arr[i]] += 1;
            } else {
                // duplicate found
                return arr[i];
            }
        }
        // fallback if none (per original)
        return 0;
    }
}

// separate main class
public class Main {
    // program entry
    public static void main(String[] args) {
        // declare and initialize array
        int[] arr = new int[]{1, 3, 4, 2, 3};
        // print result
        System.out.println("The duplicate element is " + Solution.findDuplicate(arr));
    }
}
