package sort

/*
归并排序
是创建在归并操作上的一种有效的排序算法，效率为O(nlogn)，1945年由冯·诺伊曼首次提出。

归并排序的实现分为递归实现与非递归(迭代)实现。递归实现的归并排序是算法设计中分治策略
的典型应用，我们将一个大问题分割成小问题分别解决，然后用所有小问题的答案来解决整个
大问题。非递归(迭代)实现的归并排序首先进行是两两归并，然后四四归并，然后是八八归并，
一直下去直到归并了整个数组。

归并排序算法主要依赖归并(Merge)操作。归并操作指的是将两个已经排序的序列合并成一个
序列的操作，归并操作步骤如下：

1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
4.重复步骤3直到某一指针到达序列尾
5.将另一序列剩下的所有元素直接复制到合并序列尾
 */

/*
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(nlogn)
最优时间复杂度:O(nlogn)
平均时间复杂度:O(nlogn)
所需辅助空间:O(n)
稳定性:稳定
 */
fun merge(a: IntArray,left: Int,mid: Int, right: Int){//合并两个已排好序的数组

    var l = left
    var len = right - left + 1
    var temp: Array<Int> = Array<Int>(len,{0})
    var index = 0
    var i = left
    var j = mid + 1

    while (i <= mid && j<= right){
        if(a[i] <=a[j]){
            temp[index++] = a[i++]
        }else{
            temp[index++] = a[j++]
        }
    }

    while (i<=mid){
        temp[index++] = a[i++]
    }

    while (j<=right){
        temp[index++] = a[j++]
    }
    for (k in 0 until len){
        a[l++] = temp[k]
    }

}

//递归实现的归并排序(自顶向下)
fun mergeSortRecursion(a: IntArray, left: Int, right: Int){
    if (left == right)
        return
    var mid = (left + right) / 2
    mergeSortRecursion(a, left, mid)
    mergeSortRecursion(a, mid+1, right)
    merge(a,left,mid,right)
}

//迭代实现归并排序(自底向上)
fun mergeSortIteration(a: IntArray, len: Int){
    var left: Int
    var mid: Int
    var right: Int
    var i: Int = 1

    while (i<len){

        left = 0
        while (left+i < len){   //后一个子数组存在
            mid = left + i - 1
            right = if (mid + i < len) mid + i else len - 1
            merge(a,left,mid,right)
            left = right + 1
        }
        i*=2
    }

}


fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(3,5,1,8,6,6,9,8,7,6,2)
    val n: Int = array.size
//    mergeSortRecursion(array,0,n-1)
    mergeSortIteration(array,n)
    println("归并排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}




