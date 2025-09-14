// Last updated: 9/14/2025, 12:53:16 PM
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> sti = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==')'){
                if(sti.empty()) continue;
                else{
                    sb.append(")");
                    sti.pop();
                }
            }
            else if(s.charAt(i)=='('){
                sb.append("(");
                sti.push(sb.length()-1);
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        while(!sti.empty()){
            sb.deleteCharAt(sti.pop());
        }

        return sb.toString();
    }
}