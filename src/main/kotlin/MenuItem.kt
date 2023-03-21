import java.util.*

abstract class MenuItem {
    var list : MutableList<MenuItem> = mutableListOf()
    protected val scanner: Scanner = Scanner(System.`in`)

    open val menuTitle: String = ""
    open val menuItemName: String = ""

    fun touch() {
        showMenu()
        handleMenu()
    }

    protected open fun showMenu() {
        println("==================")
        println("$menuTitle menu:")
        println("==================")
        println("1. Create $menuItemName")
        println("2. Remove $menuItemName")
        println("3. Show available ${menuItemName}s")
        println("4. Select $menuItemName")
        println("5. Exit")
        println("==================")
    }

    protected open fun handleMenu() {
        while (true){
            scanner.nextLine().toIntOrNull()
                ?.let {
                        value ->
                    when(value) {
                        1 -> add()
                        2 -> remove()
                        3 -> show()
                        4 -> select()
                        5 -> return
                        else -> println("Invalid input, try again")
                    }
                    showMenu()
                }
                ?: println("Invalid input, try again")
        }
    }

    abstract fun add()

    abstract fun remove()

    abstract fun select()

    abstract fun show()

    protected fun getText(): String? {
        var data: String? = null
        while(scanner.hasNext()){
            data = scanner.nextLine()
            return data.ifEmpty { null }
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