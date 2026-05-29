class Solution {
    public static int minElement(int[] nums) {
        int min = sum(nums[0]);
        for (int i=1;i<nums.length;i++){
            min = Math.min(min,sum(nums[i]));
        }
        return min;
    }

    public static int sum(int num){
        int sum=0;
        while (num>0){
            sum+= num%10;
            num/=10;
        }
        return sum;
    }
}