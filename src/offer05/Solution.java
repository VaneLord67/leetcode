package offer05;

/**
 * @author CJR
 * @create 2021-10-27-12:42
 */

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
