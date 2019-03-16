package com.huowolf;

/**
 * Created by huowolf on 2019/3/2.
 * 寻找1000以内的完数。
 * 6=1+2+3
 */
public class CompleteNumber {

    public static void main(String[] args){
        int sum;
        for(int n=1;n<1000;n++) //从1-1000内开始对每一个数遍历
        {
            sum = 0; //每完成一个数的因子寻找遍历后，都要对sum清零
            for(int i=1;i<n;i++)
            {
                if(n%i==0){
                    sum=sum+i;  //若寻到该数的一个因子，就将该因子加到sum上
                }

            }
            if(sum==n)//寻遍该数的所有因子后，根据sum值判断该数是不是一个完数
                System.out.println(n);
        }
    }


}
