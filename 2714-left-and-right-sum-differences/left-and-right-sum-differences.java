class Solution {
    public static int[] leftRightDifference(int[] nums) {
        int res[] = new int[nums.length];
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int n = nums.length;
        left[0]=0;
        right[n-1] = 0;
        int ind = 1;
        for (int i=0;i<n-1;i++){
            left[ind] = left[i]+nums[i];
            ind++;
        }
        int lind = n-2;
        for (int i=n-1;i>0;i--){
            right[lind] = right[i]+nums[i];
            lind--;
        }
        for (int i=0;i<n;i++){
            res[i] = Math.abs(left[i]-right[i]);
        }
        return res;
    }
}