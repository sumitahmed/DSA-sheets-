import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //BRute FOrce:

        // int[] arr3 = new int[m + n];

        // int left = 0;   // pointer for nums1
        // int right = 0;  // pointer for nums2
        // int index = 0;  // pointer for arr3

        // // merge both arrays
        // while (left < m && right < n) {
        //     if (nums1[left] <= nums2[right]) {
        //         arr3[index++] = nums1[left++];
        //     } else {
        //         arr3[index++] = nums2[right++];
        //     }
        // }

        // // remaining elements of nums1
        // while (left < m) {
        //     arr3[index++] = nums1[left++];
        // }

        // // remaining elements of nums2
        // while (right < n) {
        //     arr3[index++] = nums2[right++];
        // }

        // // copy back into nums1
        // for (int i = 0; i < m + n; i++) {
        //     nums1[i] = arr3[i];
        // }

        //Optimal:

        int left = n-1; //will point to last of arr1;
        int right = 0; //will point of arr2

        while(left>=0 && right<m){
            if(nums1[left]>nums2[right]){
                int temp = nums1[left];
                nums1[left]=nums2[right];
                nums2[right]=temp;
                left--;
                right++;
            }
            else{
                break; //eg they are in correct position
            }
        }
        // sort both arrays
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2, 0, n);

        // copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}

public class mergeSortedArrays {

    private static void runTest(String name, int[] nums1, int m, int[] nums2, int n, int[] expected) {
        Solution sol = new Solution();

        int[] nums1Before = nums1.clone();
        int[] nums2Before = nums2.clone();

        sol.merge(nums1, m, nums2, n);

        boolean pass = Arrays.equals(nums1, expected);

        System.out.println("---- " + name + " ----");
        System.out.println("nums1 before: " + Arrays.toString(nums1Before));
        System.out.println("m = " + m);
        System.out.println("nums2: " + Arrays.toString(nums2Before));
        System.out.println("n = " + n);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual:   " + Arrays.toString(nums1));
        System.out.println("result: " + (pass ? "PASS" : "FAIL"));
        System.out.println();
    }

    public static void main(String[] args) {
        runTest(
            "Test 1",
            new int[] {1, 2, 3, 0, 0, 0},
            3,
            new int[] {2, 5, 6},
            3,
            new int[] {1, 2, 2, 3, 5, 6}
        );

        runTest(
            "Test 2",
            new int[] {1},
            1,
            new int[] {},
            0,
            new int[] {1}
        );

        runTest(
            "Test 3",
            new int[] {0},
            0,
            new int[] {1},
            1,
            new int[] {1}
        );

        runTest(
            "Test 4",
            new int[] {2, 4, 7, 0, 0, 0},
            3,
            new int[] {1, 3, 5},
            3,
            new int[] {1, 2, 3, 4, 5, 7}
        );

        runTest(
            "Test 5",
            new int[] {-5, -2, 0, 0, 0, 0},
            2,
            new int[] {-4, -1, 3, 8},
            4,
            new int[] {-5, -4, -2, -1, 3, 8}
        );
    }
}