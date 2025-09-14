// Last updated: 9/14/2025, 12:54:31 PM
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean start = false;
        for(int i = s.length()-1; i >= 0 ; i--){
            if(s.charAt(i) == ' ' && !start) continue;
            else if (s.charAt(i) == ' ' && start) break;
            else {
                start = true;
                len++;
            }
        }
        return len;
    }
}