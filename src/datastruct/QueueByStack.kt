package datastruct

/**
 * 使用栈实现队列
 * 只看push、pop方法
 */
class QueueByStack {

    var stack1 = Stack<String>() //做INPUT
    var stack2 = Stack<String>() //做OUTPUT

    /**
     * stack1 只做输入
     */
    fun push(item: String): String?{
        stack1.push(item)
        return item
    }

    /**
     * stack2 做输出，当stack2为空时，把stack1全部导入stack2
     */
    fun pop(): String?{
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return null
            }else{
                for(s in 1..stack1.count()){
                    stack2.push(stack1.pop().toString())
                }
                return stack2.pop()
            }
        }else{
            return stack2.pop()
        }
    }


}