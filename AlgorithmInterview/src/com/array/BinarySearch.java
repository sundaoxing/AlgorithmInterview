package com.array;

import com.util.Util;

/*
            如何写出正确的程序：
                1.明确各个变量的含义（当前环境下的语义）
                2.找到循环不变量
                3.小批量数据测试：
                    带入数据跑一遍程序（debug一步一步跟程序运行过程），
                    理解计算机执行程序和我们自己理解的程序运行的差别在哪里，
                    找到不同点的原因+解决办法
                4.大批量数据测试

        二分查找法:
        难点：数组边界条件控制
        解决：明确循环不变量:[l,r]表示的具体语义
    思想：（分治思想）对于有序数列：[l,r]闭区间
            [                   mid                    ]
            [   <mid      ]     mid     [      >mid    ]
           比中间值小到左区间            比中间值大到右区间
 */
public class BinarySearch<T extends Comparable<T>> {
    /**
     * 二分查找：
     *      1.设置起始查找闭区间[l,r]=>[0,length-1]
     *      2.循环判断查找区间左边界是否小于或者等于右边界：
     *              是：（代表查找区间仍然有效）
     *                   1.获取查找区间的中间索引mid
     *                   2.判断目标是否等于查找区间mid索引表示的中间值
     *                          是：找到目标，返回目标所在区间索引
     *                   3.判断目标是否大于查找区间mid索引表示的中间值
     *                          是：比中间值大到右区间=>更新当前查找区间的左边界l
     *                          否：比中间值小到左区间=>更新当前查找区间的右边界r
     *              否：跳出循环，返回-1，代表查找失败，未找到目标
     * @param arr           查找数组
     * @param target        查找目标
     * @return
     */
    public int binarySearch(T arr[] , T target){
        int l = 0 , r = arr.length-1;//语义：在[l,r]范围里查找target
        while(l <= r){//l==r时，[l,r]区间仍然有效
            int mid = (r-l)/2+l;
            if(target.compareTo(arr[mid]) ==0){//[l,mid,r]直接找到目标
                return mid;
            }
            if(target.compareTo(arr[mid]) >0){
                l = mid +1;//target在[mid+1,r]中
            }else{//target.compareTo(arr[mid]) <0
                r = mid-1;//target在[mid+1,r]中
            }
        }
        return -1;
    }
}
