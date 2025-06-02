import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Min-heap based on sum of pairs
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        // Add first element of nums2 with each element of nums1 (up to k)
        for (int i = 0; i < nums1.length && i < k; i++) {
            que.offer(new int[]{nums1[i], nums2[0], 0});  // third element is index in nums2
        }

        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(Arrays.asList(cur[0], cur[1]));

            if (cur[2] == nums2.length - 1) continue;

            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return res;
    }
}
