class Solution {
    // public static int findPeakElement(int[] nums) {
    //     int n = nums.length;
    //     if (n == 1) return 0;
    //     if (nums[0] > nums[1]) return 0; 
    //     if (nums[n-1] > nums[n-2]) return n-1;
    //     for (int i=1;i<n-1;i++){
    //         if (nums[i]>nums[i-1] && nums[i]>nums[i+1]){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    public static int findPeakElement(int[] nums) {
            int n = nums.length;
            if (n==1){
                return 0;
            } else if (n==2) {
                if (nums[0]<nums[1]) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            int l=0,r = n-1;
            while (l<=r){
                int mid = l + (r-l)/2;
                if (mid>0 && nums[mid-1]>nums[mid]){
                    r = mid-1;
                } else if (mid < n-1 && nums[mid]<nums[mid+1]) {
                    l = mid+1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
}