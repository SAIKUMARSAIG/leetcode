class Solution {
        public static long zeroFilledSubarray(int[] nums) {
        long count=0,n=0;
        for (int i : nums){
            if ( i == 0 ){
                n++;
            }else{
//                System.out.println(n);
                count += n*(n+1)/2;
                n=0;
            }
        }
//        System.out.println(n);
        count += n*(n+1)/2;
        return count;
    }
}