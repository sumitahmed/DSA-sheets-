#include <bits/stdc++.h>
using namespace std;

// find the duplicate using a frequency array
int findDuplicate(vector<int>& arr) {
  // get size
  int n = arr.size();
  // allocate frequency array initialized to 0
  vector<int> freq(n + 1, 0);
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

// program entry
int main() {
  // declare and initialize array
  vector<int> arr = {1, 3, 4, 2, 3};
  // print result
  cout << "The duplicate element is " << findDuplicate(arr) << endl;
  // exit
  return 0;
}
