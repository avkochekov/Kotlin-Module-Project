import java.util.*

abstract class MenuItem {
    var list : MutableList<MenuItem> = mutableListOf()

    fun touch() {
        showMenu()
        handleMenu()
    }

    abstract fun showMenu()

    abstract fun handleMenu()

    abstract fun add()

    abstract fun remove()

    abstract fun select()

    abstract fun show()

    protected fun getText(): String? {
        var input: Scanner = Scanner(System.`in`)
        var data: String? = null
        while(input.hasNext()){
            data = input.nextLine().toString();
            if (!data.isEmpty())
                return data
            else
                return null
        }
        return null
    }

    protected fun getIndex() : Int? {
        getText()
            ?.toIntOrNull()
                ?.let { index ->
                    if ((index > 0) && (index <= list.size)){
                        return index - 1
                    } else {
                        return null
                    }
                }
                ?: return null
            ?: return null
    }

    protected fun addItem(item: MenuItem) {
        list.add(item)
    }

    protected fun removeItem(index: Int) {
        list.removeAt(index)
    }

    protected fun selectItem(index: Int) {
        list.elementAt(index).touch()
    }

    protected fun showItems(){
        var index: Int = 0
        for (item in list)
            println("   ${++index}: $item")
    }
}