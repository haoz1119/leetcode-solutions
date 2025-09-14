// Last updated: 9/14/2025, 12:53:18 PM
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
         int maxScore = 0;
        int bestPrev = values[0] + 0; // Initialize with the first element's value + its index

        for (int j = 1; j < values.length; j++) {
            // Calculate the current score using the best previous value
            maxScore = Math.max(maxScore, bestPrev + values[j] - j);
            // Update the best previous value for the next iteration
            bestPrev = Math.max(bestPrev, values[j] + j);
        }

        return maxScore;
    }
}