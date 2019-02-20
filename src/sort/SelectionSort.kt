package sort

/*
选择排序
选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：
初始时在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。
以此类推，直到所有元素均排序完毕。

注意选择排序与冒泡排序的区别：冒泡排序通过依次交换相邻两个顺序不合法的元素位置，
从而将当前最小（大）元素放到合适的位置；而选择排序每遍历一次都记住了当前最小（大）元素的位置，
最后仅需一次交换操作即可将其放到合适的位置。
 */


/*
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(n^2)
最优时间复杂度:O(n^2)
平均时间复杂度:O(n^2)
所需辅助空间:O(1)
稳定性:不稳定
 */
fun selectionSort(a: IntArray, n: Int){
    for (i in 0 until n-1){     //i为已排序序列的末尾
        var min: Int = i
        for (j in i+1 until n){ //未排序序列
            if (a[j]<a[min]){   //找出未排序序列中的最小值
                min = j
            }
        }
        if (min != i){
            swap(a,min,i)       //放到已排序序列末尾，该操作很可能把稳定性打乱，所以是不稳定算法
        }
    }
}


fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(3,5,1,8,6,6,9,8,7,6,2)
    val n: Int = array.size
    selectionSort(array,n)
    println("选择排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}