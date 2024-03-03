class solution_1{
  public int[] twoSum(int[] nums, int target) {
      int[] an = new int[2];
      int a = 0;
      for(int i = 0; i < nums.length; i++){
          for (int j = 0; j < nums.length; j++){
              if (nums[i] + nums[j]== target && i != j){
                  an[0]=i;
                  an[1]=j;
                  a = 1;
                  break;
              }
          }
          if(a != 0) break;
      }
      return an;
  }
 
}