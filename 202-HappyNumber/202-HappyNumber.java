// Last updated: 9/14/2025, 12:53:57 PM
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            if(!set.contains(n)) set.add(n);
            n = sumOfSquare(n);  
        }
        return n == 1;
    }

    private static int sumOfSquare(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10)*(n % 10);
            n /= 10;
        }
        return sum;
    }
}