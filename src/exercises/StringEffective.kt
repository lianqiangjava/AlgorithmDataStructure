package exercises

import datastruct.Stack


/*
判断字符串括号是否有效
 */

fun main(args: Array<String>) {
    val map = mapOf(")" to "(","}" to "{","]" to "[" )
    var stack = Stack<String>()
    var isValid = true

    val s = "({}}[])"

    println(System.currentTimeMillis())
    for (c in s){
        if(!map.containsKey(c.toString())){
            stack.push(c.toString())
        }else if(!map.get(c.toString()).equals(stack.pop())){
            isValid = false
            break
        }
    }
    println(System.currentTimeMillis())

//    isValid = exercises.isValid(s)

    if(isValid){
        print("OK")
    }else{
        print("ERR")
    }
}


//效率慢
fun isValid(str: String): Boolean{
    var length: Int
    var s = str
    println(System.currentTimeMillis())
    do {
        length = s.length
        s = s.replace("()","").replace("{}","").replace("[]","")
    }while (length != s.length)
    println(System.currentTimeMillis())
    return s.length == 0
}