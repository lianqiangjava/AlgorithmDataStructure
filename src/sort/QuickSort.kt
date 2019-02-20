package sort

/*
快速排序
是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序n个元素要O(nlogn)次比较。
在最坏状况下则需要O(n^2)次比较，但这种状况并不常见。事实上，快速排序通常明显
比其他O(nlogn)算法更快，因为它的内部循环可以在大部分的架构上很有效率地被实现出来。

快速排序使用分治策略(Divide and Conquer)来把一个序列分为两个子序列。步骤为：

1.从序列中挑出一个元素，作为"基准"(pivot).
2.把所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面（相同的数可以到任一边），
这个称为分区(partition)操作。
3.对每个分区递归地进行步骤1~2，递归的结束条件是序列的大小是0或1，这时整体已经被排好序了。
 */

//划分函数
fun partition(a: IntArray, left: Int, right: Int): Int{
    var pivot = a[right]            //这里每次都选择最后一个元素作为基准
    var tail = left - 1             //tail为小于基准的子数组最后一个元素的索引
    for (i in left until right){    //遍历基准以外的其他元素
        if (a[i] <= pivot){         //把小于等于基准的元素放到前一个数组末尾
            tail++
            if(tail != i)
                swap(a,tail,i)
        }
    }
    swap(a,tail+1,right)          //最后把基准放到前一个子数组的后边,剩下的子数组既是大于基准的子数组
                                    //该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
    return tail + 1                 //返回基准的索引
}

/*
分类:内部比较排序
数据结构:数组
最差时间复杂度:每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
最优时间复杂度:每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
平均时间复杂度:O(nlogn)
所需辅助空间:主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
稳定性:不稳定
 */
fun quickSort(a: IntArray, left: Int, right: Int){
    if (left >= right)
        return
    var pivot_index = partition(a,left,right)
    quickSort(a,left,pivot_index - 1)
    quickSort(a,pivot_index+1,right)
}

fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(3,5,1,8,6,5,4,9,7,6,2)
    val n: Int = array.size
    quickSort(array,0,n-1)
    println("快速排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}