package sort

/*
堆排序
是指利用堆这种数据结构所设计的一种选择排序算法。
堆是一种近似完全二叉树的结构（通常堆是通过一维数组来实现的），
并满足性质：以最大堆（也叫大根堆、大顶堆）为例，其中父结点的值总是大于它的孩子节点。

堆排序的过程：

1.由输入的无序数组构造一个最大堆，作为初始的无序区
2.把堆顶元素（最大值）和堆尾元素互换
3.把堆（无序区）的尺寸缩小1，并调用heapify(A, 0)从新的堆顶元素开始进行堆调整
4.重复步骤2，直到堆的尺寸为1
 */

fun heapify(a: IntArray, i: Int, size: Int){    //从a[i]向下进行堆调整
    var left_child = 2*i+1  //左孩子索引
    var right_child = 2*i+2 //右孩子索引
    var max = i             //选出当前结点与其左右孩子三者之中的最大值

    if (left_child < size && a[left_child] > a[max])
        max = left_child
    if (right_child < size && a[right_child] > a[max])
        max = right_child
    if (max != i){
        swap(a,i,max)       //把当前结点和它的最大(直接)子节点进行交换
        heapify(a,max,size) //递归调用，继续从当前结点向下进行堆调整
    }
}

fun buildHeap(a: IntArray, n: Int): Int{    //建堆
    var heap_size = n
    for (i in heap_size /2 -1 downTo 0){    //从每一个非叶结点开始向下进行堆调整
        heapify(a,i,heap_size)
    }
    return heap_size
}

/*
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(nlogn)
最优时间复杂度:O(nlogn)
平均时间复杂度:O(nlogn)
所需辅助空间:O(1)
稳定性:不稳定
 */
fun heapSort(a: IntArray,n: Int){
    var heap_size = buildHeap(a,n)  //建立一个最大堆
    while (heap_size > 1){          //堆(无序号)元素个数大于1，未完成排序
        //将堆顶元素与堆的最后一个元素互换，并从堆中去掉最后一个元素
        //此处交换操作很有可能把后面元素的稳定性打乱，所以堆排序是不稳定的排序算法
        swap(a,0,--heap_size)
        heapify(a,0,heap_size) //从新的堆顶元素开始向下进行堆调整，时间复杂度O(logn)
    }
}


fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(3,5,1,8,6,6,9,8,7,6,2)
    val n: Int = array.size
    heapSort(array,n)
    println("堆排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}