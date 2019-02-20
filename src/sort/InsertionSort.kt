package sort

/*
插入排序
是一种简单直观的排序算法。它的工作原理非常类似于我们抓扑克牌
对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，
找到相应位置并插入。

插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，
比如量级小于千，那么插入排序还是一个不错的选择。

具体算法描述如下：

1.从第一个元素开始，该元素可以认为已经被排序
2.取出下一个元素，在已经排序的元素序列中从后向前扫描
3.如果该元素（已排序）大于新元素，将该元素移到下一位置
4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
5.将新元素插入到该位置后
6.重复步骤2~5
 */


/*
直接插入
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(n^2)
最优时间复杂度:O(n)
平均时间复杂度:O(n^2)
所需辅助空间:O(1)
稳定性:稳定
 */
fun insertionSort(a: IntArray, n: Int){
    for (i in 1 until n ){          //类似抓扑克牌
        var get = a[i]              //右手抓到一张扑克牌
        var j = i - 1               //拿在左手上的牌总是排序好的
        while (j>=0 && a[j] > get){ //将抓到的牌与手牌从右向左进行比较
            a[j+1] = a[j]           //如果该手牌比抓到的牌大，就将其右移
            j--
        }
        a[j+1] = get                //直到该手牌比抓到的牌小(或相等)，将抓到的牌插入到手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
    }
}

/*
二分插入
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(n^2)
最优时间复杂度:O(nlogn)
平均时间复杂度:O(n^2)
所需辅助空间:O(1)
稳定性:稳定
 */
fun insertionSortDichotomy(a: IntArray, n: Int){
    for (i in 1 until n){
        var get = a[i]              //右手抓到一张牌
        var left = 0                //拿在左手上的牌总是排序好的，所以可以用二分法
        var right = i - 1           //手牌左右边界进行初始化
        while (left <= right){      //采用二分法定位新牌位置
            var mid = (left + right) /2
            if (a[mid] > get)
                right = mid - 1
            else
                left = mid + 1
        }
        for (j in i-1 downTo left){  //将欲插入新牌位置右边的牌整体向右移动一个单位
            a[j+1] = a[j]
        }
        a[left] = get                //将抓到的牌插入手牌
    }

}

/*
希尔排序
分类:内部比较排序
数据结构:数组
最差时间复杂度:根据步长序列的不同而不同，已知最好的为O(n(logn)^2)
最优时间复杂度:O(n)
平均时间复杂度:根据步长序列的不同而不同
所需辅助空间:O(1)
稳定性:不稳定
 */
fun shellSort(a: IntArray, n: Int){
    var h = 0
    while (h<=n){           //生成初始增量
        h = 3 * h + 1
    }
    while (h >= 1){
        for (i in h until n){
            var j = i - h
            var get = a[i]
            while (j >= 0 && a[j] > get){
                a[j+h] = a[j]
                j = j-h
            }
            a[j+h] = get
        }
        h = (h-1)/3         //递减增量
    }
}


fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(3,5,1,8,6,6,9,8,7,6,2)
    val n: Int = array.size
//    insertionSort(array,n)
//    insertionSortDichotomy(array,n)
    shellSort(array,n)
    println("插入排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}