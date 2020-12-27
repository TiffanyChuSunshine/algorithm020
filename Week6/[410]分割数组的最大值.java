//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划 
// 👍 238 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i< nums.length;i++){
            right += nums[i];
            if (left < nums[i]){
                left = nums[i];
            }
        }

        while(left < right){
            int mid = (right - left)/2 + left;
            if (check(nums,mid,m)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] nums,int x, int m){
        int sum = 0;
        int cnt = 1;
        for (int i = 0;i<nums.length;i++){
            if (sum + nums[i] > x){
                cnt++;
                sum = nums[i];
            }else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
