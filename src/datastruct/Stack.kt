package datastruct

/*
 栈
 */

class Stack<T: Comparable<T>>(list: MutableList<T>) : Iterator<T>{

    //stack的count
    var elementCount: Int = 0

    //stack内部实现为MutableList
    var items: MutableList<T> = list

    //判断Stack是否为null
    fun isEmpty(): Boolean = this.items.isEmpty()

    //获取statck的items count
    fun count(): Int = this.items.count()

    override fun toString(): String {
        return this.items.toString()
    }

    fun push(item: T): T?{
        elementCount++
        items.add(item)
        return item
    }

    //pop操作，弹出栈顶元素即链表最末端元素，可为null
    fun pop(): T?{
        if (this.isEmpty()){
            return null
        }else{
            elementCount--
            val item = this.items.count()-1
            return this.items.removeAt(item)
        }
    }

    //只读操作，不弹出
    fun peek(): T?{
        if (isEmpty()){
            return null
        }else{
            return this.items[this.items.count() - 1]
        }
    }

    override fun hasNext(): Boolean {
        val hasNext = elementCount < count()
        if (!hasNext) elementCount = 0
        return hasNext
    }

    override fun next(): T {
        if (hasNext()){
            val topPos: Int = (count() - 1) - elementCount
            elementCount++
            return this.items[topPos]
        }else{
            throw NoSuchElementException("No such element")
        }
    }

}
