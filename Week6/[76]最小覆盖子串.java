//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 674 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        unorder_map<char,int> need,window;
        for (char c:t){
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0; len = INT_MAX;
        while (right < s.size()){
            char c = s[right];
            right++;
            if (need.count(c)){
                window[c]++;
                if (window[c] == need[c]){
                    valid++;
                }
            }
            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right -left;
                }
                char d = s[left];
                left++;
                if (need.count(d)){
                    if (window[d] == need[d]){
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        return len == INT_MAX ? "",s.substr(start,len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
