// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//


class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int max = 0;
        int front = 0;
        int back = height.length -1;
        while (front < back) {

            int v = (back - front) * Math.min(height[back], height[front]);

            if (v > max) max = v;

            if (height[back] < height[front]) back--;
            else front++;
        }

        return max;
    }
}
