class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        s.addAll(l);
        return s.size() != nums.length; 
    }
}