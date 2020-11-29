//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1021 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;

    }


    public void backTrack(int[] nums,LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
        }

        for (int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }

            track.add(nums[i]);
            backTrack(nums,track);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
