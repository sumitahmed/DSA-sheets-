import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int beg =0, end = (n*m) -1;

        while(beg<=end){
            int mid = (beg+end)/2;
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                beg=mid+1; //do it in the 1d matrix;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}

public class searchIn2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            runSampleTests();
            sc.close();
            return;
        }

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(matrix, target));

        sc.close();
    }

    private static void runSampleTests() {
        Solution sol = new Solution();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println("Sample Test 1 (target = 3): " + sol.searchMatrix(matrix, target1));
        System.out.println("Sample Test 2 (target = 13): " + sol.searchMatrix(matrix, target2));
    }
}