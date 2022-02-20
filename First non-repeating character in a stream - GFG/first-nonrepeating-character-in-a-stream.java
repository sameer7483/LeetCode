// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int[] count = new int[26];
        String res = "";
        Deque<Character> dq = new LinkedList<>();
        for(int i=0;i<A.length();i++){
            count[A.charAt(i)-'a']++;
            dq.add(A.charAt(i));
            while(!dq.isEmpty() && count[dq.peekFirst()-'a'] > 1)
                dq.pollFirst();
            if(!dq.isEmpty())
            {
                res += dq.peekFirst();
            }
            else{
                res += "#";
            }
        }
        return res;
        
    }
}