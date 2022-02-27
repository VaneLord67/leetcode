package offer58_1;

/**
 * @author CJR
 * @create 2022-02-26-0:59
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >=0; i--) {
            if (!strs[i].trim().equals("")) {
                sb.append(strs[i].trim());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}