//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.1深度优先-做减法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String curStr,int left,int right,List<String> res){
        if (left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        if (left > right){
            return;
        }

        if (left > 0){
            dfs(curStr + "(" , left-1, right, res);
        }

        if (right > 0){
            dfs(curStr + ")", left, right-1, res);
        }
    }


    //1.2深度优先-做加法
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//
//        if (n == 0){
//            return res;
//        }
//        dfs("",0,0,n,res);
//        return res;
//    }
//
//    private void dfs(String curStr,int left,int right,int n,List<String> res){
//        if (left == n && right == n){
//            res.add(curStr);
//        }
//
//        if (left < right){
//            return;
//        }
//
//        if (left < n){
//            dfs(curStr + "(",left + 1,right,n,res);
//        }
//
//        if (right < n){
//            dfs(curStr + ")",left,right + 1,n,res);
//        }
//
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
