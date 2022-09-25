package leetCode;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        return getMaxArea(heights);
    }

    private int getMaxArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int width  = j - i;
                int height = Math.min(heights[i], heights[j]);

                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}
