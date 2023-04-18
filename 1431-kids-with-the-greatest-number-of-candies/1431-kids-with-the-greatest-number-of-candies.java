class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extra) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for(int c : candies){
            if(c+extra >= max)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}