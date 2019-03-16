package com.huowolf;

import static org.junit.Assert.*;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 这依旧是fibonacci问题。
 */
public class RectCover {

    public static int RectCover(int target) {

        /**
         * target=1,大矩形为2*1，只有一种排放方法；
         * target=2,大矩形为2*2，有两种排放方法；
         */
        if(target<=0)
            return 0;
        if(target<=2 && target>0)
            return target;

        int fibNfirst = 2;
        int fibNSecond = 1;
        int fibN = 0;
        for(int i=3;i<=target;i++){
            fibN = fibNfirst + fibNSecond;

            fibNSecond = fibNfirst;
            fibNfirst = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        int result = RectCover(4);
        System.out.println(result);

        assertEquals(RectCover(4),5);
    }
}
