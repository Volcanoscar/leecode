package ink.lichen.leecode.dp;

/**
 * Created by lichen@daojia.com on 2018-12-13.
 *
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 */
public class NumDistinct {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n || n == 0){
            return 0;
        }
        int[] res = new int[n];
        for (int i = 0 ; i < n ; i++){

        }
        return 0;
    }

}
