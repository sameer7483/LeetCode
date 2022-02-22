class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).boxed().map(x->String.valueOf(x)).collect(Collectors.toList());
        Collections.sort(list, new Comparator<String>(){
            public int compare(String a, String b){
                return -(a+b).compareTo(b+a);
            }
        });
        String res = String.join("", list);
        try{  
        if(Integer.parseInt(res) == 0)
            return "0";
        }catch(Exception ex){
            
        }
        return res;
    }
}