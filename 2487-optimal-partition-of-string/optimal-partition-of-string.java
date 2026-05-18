class Solution {
   public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int count = 0 , idx=0;
        while (idx < n){
            if (set.contains(s.charAt(idx))){
                set.clear();
                count++;
            }
            set.add(s.charAt(idx));
            idx++;
        }
        if (set.size()!=0){
            count++;
        }
        return count;
    }
}