
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int count = m.getOrDefault(arr[i], 0);
            m.put(arr[i], count+1);  
        }
        List<Integer> l = m.values().stream().collect(Collectors.toList());
        Collections.sort(l, Comparator.reverseOrder());
        int sum = 0;
        int ans =0;
        for(int i=0;i<l.size();i++){
            sum += l.get(i);
            ans++;
            if(sum>=n/2)
                break;
        }
        return ans;
    }
}