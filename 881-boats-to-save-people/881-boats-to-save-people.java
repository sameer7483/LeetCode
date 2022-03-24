class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0;
        int j = people.length-1;
        int res = 0;
        Arrays.sort(people);
        while(i <= j){
            if(i==j){
                res +=1;
                j--;
            }  
            else{
                if(people[j] + people[i] <= limit){
                    res +=1;
                    j--;
                    i++;
                }
                else{
                    res +=1;
                    j--;
                }
            }
        }
        return res;
    }
}