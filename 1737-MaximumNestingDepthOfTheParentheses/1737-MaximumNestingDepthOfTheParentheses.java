// Last updated: 9/14/2025, 12:53:13 PM
class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<Character>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') st.push(')');
            if(s.charAt(i)==')') st.pop();
            max = Math.max(max, st.size());
        }
        return max;
    }
}