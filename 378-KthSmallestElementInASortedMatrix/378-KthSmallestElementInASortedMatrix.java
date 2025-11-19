// Last updated: 11/19/2025, 7:10:38 PM
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int[] row : matrix) {
            for (int num : row) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}
