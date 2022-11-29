class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                int temp=nums[count];
				nums[count] = nums[i];
				nums[i]= temp;
				count++;
            }
        }
        return nums;
        
    }
}