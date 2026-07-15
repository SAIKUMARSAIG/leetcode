class Solution {
     public static int gcd(int a, int b){
        if (b!=0){
            return gcd(b,a%b);
        }
        return a;
    }




    public static int gcdOfOddEvenSums(int n) {
        int oddSum=0, evenSum=0;
        for (int i=1;i<=n*2;i++){
            if (i%2==0){
                evenSum+=i;
            }else{
                oddSum+=i;
            }
        }
        return gcd(oddSum,evenSum);
    }

}
