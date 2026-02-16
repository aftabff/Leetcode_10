// class Solution {
//     public int thirdMax(int[] nums) {

//         int n = nums.length;
//         int max1 = 0; 
//         int max2 = 0;
//         int max3 = 0;

//         if(n < 3){
//             max1 = Math.max(nums[0] , nums[1]);
//             return max1;
//         }

//         for(int i=0; i<n; i++){
//             if(nums[i] > max1)
//             {
//                 max3 = max2;
//                 max2 = max1;
//                 max1 = nums[i];
//             }
//             else if(nums[i] > max2 && nums[i]!= max1)
//             {
//                 max3 = max2;
//                 max2 = nums[i];
//             }
//             else if(nums[i] > max3 && nums[i]!= max2 && nums[i]!= max1)
//             {
//                 max3 = nums[i];
//             }
//         }

//         return max3;
//     }
// }

class Solution {
    public int thirdMax(int[] nums) {

        int n = nums.length;

        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){

            // ignore duplicates
            if(nums[i] == max1 || nums[i] == max2 || nums[i] == max3)
                continue;

            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] > max3){
                max3 = nums[i];
            }
        }

        // if third max not present return max1
        if(max3 == Long.MIN_VALUE)
            return (int)max1;

        return (int)max3;
    }
}
