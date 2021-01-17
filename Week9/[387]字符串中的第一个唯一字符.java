//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> position = new HashMap<Character,Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if (position.containsKey(ch)){
                position.put(ch,-1);
            }else {
                position.put(ch,i);
            }
        }
        int first = n;
        for (Map.Entry<Character,Integer> entry : position.entrySet()){
            int pos = entry.getValue();
            if (pos != -1 && pos < first){
                first = pos;
            }
        }
        if (first == n){
            first = -1;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
