class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length)
            return false;
        int[] count = new int[1001];
        int n = arr.length;
        for(int i=0;i<n;i++)
            count[target[i]]++;
        for(int i=0;i<n;i++)
            count[arr[i]]--;
        for(int i=0;i<1001;i++)
            if(count[i] > 0)
                return false;
        return true;
    }
}