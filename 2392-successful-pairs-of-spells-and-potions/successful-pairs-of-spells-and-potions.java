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
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int res[] = new int[n];
        int idx = 0;
        for (int i = 0; i<n; i++){
            int num = spells[i];
            int l=0,r=m-1;
            int ans = m;
            while (l<=r){
                int mid = l + (r-l)/2;
                // int product = spells[i] * potions[mid];
                long product = (long) spells[i] * potions[mid];

                if (product>=success){
                    ans = mid;
                    r = mid-1;
                } else if (product<success) {
                    l = mid+1;
                }
            }
            res[i] = m-ans;
        }
        return res;
    }
}