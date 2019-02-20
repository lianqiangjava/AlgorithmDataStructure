package sort

fun swap(array:IntArray,i:Int,j:Int){
    array[i] = array[i] xor array[j]
    array[j] = array[i] xor array[j]
    array[i] = array[i] xor array[j]
}