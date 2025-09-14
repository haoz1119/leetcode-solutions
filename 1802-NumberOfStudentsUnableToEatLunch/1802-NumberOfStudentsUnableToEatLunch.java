// Last updated: 9/14/2025, 12:53:12 PM
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> stu = new ArrayDeque<>();
        for(int i : students){
            stu.add(i);
        }
        // boolean sandwichtaken = false;
        int ind = 0;
        int top = 0;
        while(ind != stu.size()){
            int s = stu.poll();
            if(s==sandwiches[top]){
                top++;
                // sandwichtaken = true;
                ind=0;
            }else{
                stu.add(s);
                ind++;
            }
        }
        return stu.size();
    }
}