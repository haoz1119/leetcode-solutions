import java.util.Map;
class solution_217 {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Map<Integer, Integer> num = new HashMap<>();
        for(int i : nums){
            num.put(i, 0);
        }
        for(int i : nums){
            num.put(i, num.get(i)+1);
            if(num.get(i)>1) flag = true;
        }
        return flag;
    }
}