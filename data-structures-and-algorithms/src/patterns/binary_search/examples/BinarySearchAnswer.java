package patterns.binary_search.examples;

public class BinarySearchAnswer {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need faster speed
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceiling division
        }

        return hours <= h;
    }
}
