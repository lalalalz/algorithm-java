package leetCode;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        return getMaxArea(heights);
    }

    private int getMaxArea(int[] heights) {
        int maxArea = findMaxArea(heights);
        return maxArea;
    }

    private int findMaxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height;
            int width = right - left;

            if (heights[left] > heights[right]) {
                height = heights[right++];
            }
            else {
                height = heights[left++];
            }

            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
