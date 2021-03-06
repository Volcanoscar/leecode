package ink.lichen.leecode.bytecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lichen@daojia.com on 2018-11-28.
 * <p>
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]
 * <p>
 * [[4,5],[6,7],[2,3]]
 * <p>
 * [[4,5],[4,6],[6,7],[2,3],[1,1]]
 * [[1,1],[2,3],[4,5],[4,6],[6,7]]
 * f(0) = 1;
 * f(1) = f(0)+1;
 *
 * [[6,1],[13,2],[6,10],[11,14],[16,14]]
 */
public class MaxEnvelopes {


//    public int maxEnvelopes(int[][] envelopes) {
//
//        Arrays.sort(envelopes, (e1, e2) -> Integer.compare(e1[0], e2[0]));
//
//        int   n  = envelopes.length;
//        int[] dp = new int[n];
//        int ret = 0;
//        for (int i = 0 ; i < n; i++){
//
//            dp[i] = 1;
//            for (int j = 0 ; j < n; j++){
//                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//                ret = Math.max(ret,dp[i]);
//            }
//        }
//        return ret;

//    }
//    [[5,4],[6,4],[6,7],[2,3]]
//    [[4,5],[4,6],[6,7],[2,3],[1,1]]
//     [[1,1],[2,3],[4,6],[4,5],[6,7]]
//        [1,1] i = 0, j = -1  h[0] = 1 ,len 0->1
//        [2,3] i = 0, j = 0  m = 0 -> i = 1 -> h[1] = 3 -> len 1->2

        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (e1, e2) -> {
                if (e1[0] != e2[0]) return e1[0] - e2[0];
                return e2[1] - e1[1];
            });
            int len = 0;
            int[] h = new int[envelopes.length];
            for(int[] envelope : envelopes) {
                int i=0, j=len-1;
                while (i<=j) {
                    int m = (i+j)/2;
                    if (h[m] < envelope[1]) i=m+1; else j=m-1;
                }
                h[i] = envelope[1];
                if (i == len) len ++;
            }
            return len;
        }

    public static void main(String[] args) {
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        maxEnvelopes.maxEnvelopes(new int[][]{
                {5,4},
                {6,4},
                {6,7},
                {2,7}}
                );
    }

}
