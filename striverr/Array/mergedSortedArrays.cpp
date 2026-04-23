#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        //BRute FOrce:

        // vector<int> arr3(m + n);

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

        int left = n - 1; //will point to last of arr1;
        int right = 0;    //will point of arr2

        while (left >= 0 && right < m) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break; //eg they are in correct position
            }
        }

        // sort both arrays
        sort(nums1.begin(), nums1.begin() + m);
        sort(nums2.begin(), nums2.begin() + n);

        // copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
};

void printVector(const vector<int>& arr) {
    cout << "[";
    for (size_t i = 0; i < arr.size(); i++) {
        cout << arr[i];
        if (i + 1 < arr.size()) cout << ", ";
    }
    cout << "]";
}

void runTest(const string& name, vector<int> nums1, int m, vector<int> nums2, int n, const vector<int>& expected) {
    Solution sol;

    vector<int> nums1Before = nums1;
    vector<int> nums2Before = nums2;

    sol.merge(nums1, m, nums2, n);

    bool pass = (nums1 == expected);

    cout << "---- " << name << " ----\n";
    cout << "nums1 before: ";
    printVector(nums1Before);
    cout << "\n";
    cout << "m = " << m << "\n";
    cout << "nums2: ";
    printVector(nums2Before);
    cout << "\n";
    cout << "n = " << n << "\n";
    cout << "expected: ";
    printVector(expected);
    cout << "\n";
    cout << "actual:   ";
    printVector(nums1);
    cout << "\n";
    cout << "result: " << (pass ? "PASS" : "FAIL") << "\n\n";
}

int main() {
    runTest(
        "Test 1",
        {1, 2, 3, 0, 0, 0},
        3,
        {2, 5, 6},
        3,
        {1, 2, 2, 3, 5, 6}
    );

    runTest(
        "Test 2",
        {1},
        1,
        {},
        0,
        {1}
    );

    runTest(
        "Test 3",
        {0},
        0,
        {1},
        1,
        {1}
    );

    runTest(
        "Test 4",
        {2, 4, 7, 0, 0, 0},
        3,
        {1, 3, 5},
        3,
        {1, 2, 3, 4, 5, 7}
    );

    runTest(
        "Test 5",
        {-5, -2, 0, 0, 0, 0},
        2,
        {-4, -1, 3, 8},
        4,
        {-5, -4, -2, -1, 3, 8}
    );

    return 0;
}