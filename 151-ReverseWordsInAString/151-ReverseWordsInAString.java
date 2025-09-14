// Last updated: 9/14/2025, 12:54:05 PM
class Solution {
    public String reverseWords(String s) {
        String[] st = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < st.length - 1; i++){
            sb.append(st[st.length - i - 1]);
            sb.append(" ");
        }
        sb.append(st[0]);
        return sb.toString().trim();
    }
}