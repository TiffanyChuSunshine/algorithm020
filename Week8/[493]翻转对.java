//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 251 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int findReversedPairs(int[] nums,int left,int right){
        int res = 0,mid = left + (right-left)/2;
        int i = left,j = mid+1;
        for(;i <= mid;i++){
            while(j <= right && (long)nums[i] > 2*(long)nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        return res;
    }

    private int mergeSort(int[] nums,int[] numsSorted,int left,int right){
        if(left == right) return 0;
        int mid = left + (right - left) / 2;
        int res = mergeSort(nums,numsSorted,left,mid) +
                mergeSort(nums,numsSorted,mid+1,right) +
                findReversedPairs(nums,left,right);
        int i = left,j = mid+1,k = left;

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]) numsSorted[k++] = nums[i++];
            else numsSorted[k++] = nums[j++];
        }
        while(i <= mid) numsSorted[k++] = nums[i++];
        while(j <= right) numsSorted[k++] = nums[j++];

        for(int ind = left;ind <= right;ind++) nums[ind] = numsSorted[ind];

        return res;
    }

    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        int[] numsSorted = new int[nums.length];
        return mergeSort(nums,numsSorted,0,nums.length-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
