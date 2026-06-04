class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        getPerms(nums,result,list,set);
        return result;
    }

    public static void getPerms(int[] nums,List<List<Integer>> result,List<Integer> list,Set<Integer> set){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        int n = nums.length;
        for (int i=0;i<n;i++){
            if (!set.contains(i)){
                set.add(i);
                list.add(nums[i]);
                getPerms(nums,result,list,set);
                list.remove(list.size()-1);
                getPerms(nums,result,list,set);
                set.remove(i);
            }
        }
    }
}