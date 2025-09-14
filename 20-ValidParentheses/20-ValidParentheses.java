// Last updated: 9/14/2025, 12:55:14 PM
class Solution {
    public boolean isValid(String s) {
        int l = s.length();
        if(l%2!=0) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < l; i++){
            if(s.charAt(i)=='(') {
                st.push('(');
            }
            else if(s.charAt(i)=='{') {
                st.push('{');
            }
            else if(s.charAt(i)=='[') {
                st.push('[');
            }
            else if(s.charAt(i)==']') {
                if(st.empty()||!st.pop().equals('[')) return false;
            }
            else if(s.charAt(i)=='}') {
                if(st.empty()||!st.pop().equals('{')) return false;
            }
            else if(s.charAt(i)==')') {
                if(st.empty()||!st.pop().equals('(')) return false;
            }
            
        }
        if(!st.empty()) return false;
        return true;
    }
}