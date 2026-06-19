class Solution {
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int prefixSum=0;
        for (int i : gain){
            prefixSum+=i;
            max = Math.max(max,prefixSum);
        }
        return max;
    }
}