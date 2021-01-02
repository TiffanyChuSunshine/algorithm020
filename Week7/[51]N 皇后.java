//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        Character[][] board = new Character[n][n];
        for (int i=0; i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        backTrack(board,0);
        return res;
    }

    void backTrack(Character[][] board, int row){
        if(row == board.length){
            List<String> boardList = new ArrayList<>();
            for(int k=0;k<row;k++){
                StringBuilder str = new StringBuilder();
                for (int m=0; m<board[k].length;m++){
                    str.append(board[k][m]);
                }
                boardList.add(str.toString());
            }
            res.add(boardList);
            return;
        }

        int n = board[row].length;
        for (int col=0;col<n;col++){
            if (!isValid(board,row,col)){
                continue;
            }
            board[row][col] = 'Q';
            backTrack(board,row+1);
            board[row][col] = '.';
        }

    }

    boolean isValid(Character[][] board, int row,int col){
        int n = board.length;
        //列
        for (int i=0;i<n;i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //右上方
        for (int i = row-1,j = col+1;i>=0 && j<n;i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //左上方
        for (int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
