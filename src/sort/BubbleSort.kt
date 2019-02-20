package sort

/*
冒泡排序
比较相邻的元素，如果前一个比后一个大，就把它们两个调换位置。
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
针对所有的元素重复以上的步骤，除了最后一个。
持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */


/*
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(n^2)
最优时间复杂度:O(n)
平均时间复杂度:O(n^2)
所需辅助空间:O(1)
稳定性:稳定
 */
fun bubbleSort(a: IntArray,n: Int){
    for(i in 0 until n-1){
        for (j in 0 until n-1-i){
            if (a[j]>a[j+1]){   //如果条件改成a[j] >= a[j+1]，则变为不稳定算法
                swap(a,j,j+1)
            }
        }
    }
}

/*
冒泡改进-鸡尾酒排序
分类:内部比较排序
数据结构:数组
最差时间复杂度:O(n^2)
最优时间复杂度:O(n)
平均时间复杂度:O(n^2)
所需辅助空间:O(1)
稳定性:稳定
 */
fun cocktailSort(a: IntArray,n: Int){

    //初始化边界
    var left: Int = 0
    var right: Int = n - 1

    while (left < right){
        //前半轮，将最大元素放到后面
        for (i in left until right){
            if (a[i] > a[i+1]){
                swap(a,i,i+1)
            }
        }
        right--

        //后半轮，将最小元素放到前面
        for (i in right downTo left+1 ){
            if (a[i-1] > a[i]){
                swap(a,i-1,i)
            }
        }
        left++
    }
}

fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(5,7,3,9,3,2,0,1,6)
    val n: Int = array.size
    bubbleSort(array,n)
//    cocktailSort(array,n)
    println("冒泡排序结果:")
    for (i in 0 until n){
        print(array[i].toString() + ",")
    }
}