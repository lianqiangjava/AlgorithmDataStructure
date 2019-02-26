package exercises

import datastruct.QueueByStack
import datastruct.Stack

//用栈实现队列
fun main(args: Array<String>) {


    val queueByStack = QueueByStack()
    queueByStack.push("a")
    queueByStack.push("b")
    queueByStack.push("c")


    for (i in 0..2){
        print(queueByStack.pop())
    }




}

