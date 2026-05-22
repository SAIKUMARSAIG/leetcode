class Solution {
    // public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    //     int resLength = spells.length;
    //     int res[] = new int[resLength];
    //     int idx = 0;
    //     for (int i : spells) {
    //         int count = 0;
    //         for (int p : potions){
    //             if ( i*p >= success ){
    //                 count++;
    //             }
    //         }
    //         res[idx] = count;
    //         idx++;
    //     }
    //     return res;
    // }


public static int[] successfulPairs(int[] spells, int[] potions, long success) {

    Arrays.sort(potions);

    int n = spells.length;
    int m = potions.length;

    int[] res = new int[n];

    for (int i = 0; i < n; i++) {

        int left = 0;
        int right = m - 1;
        int ans = m;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long product = (long) spells[i] * potions[mid];

            if (product >= success) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        res[i] = m - ans;
    }

    return res;
}
}