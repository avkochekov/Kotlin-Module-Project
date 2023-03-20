import java.util.*

class ArchiveListMenu : MenuItem() {
    override fun toString(): String {
        return "Archive list"
    }

    override fun showMenu() {
        println("==================")
        println("Archive list menu:")
        println("==================")
        println("1. Create archive")
        println("2. Remove archive")
        println("3. Show available archives")
        println("4. Select archive")
        println("5. Exit")
        println("==================")
    }

    override fun handleMenu() {
        var validInput = false
        while (!validInput){
            val input = Scanner(System.`in`).nextLine().toIntOrNull()
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

    override fun add() {
        println("Enter archive title")
        super.getText()
            ?. let { title ->
                super.addItem(ArchiveMenu(title))
                println("Added archive \"$title\"")
            }
            ?: println("Invalid archive title")
    }

    override fun remove() {
        println("Enter archive index")
        super.getIndex()
            ?. let { index ->
                super.removeItem(index)
                println("Archive removed")
            }
            ?: println("Invalid archive index")
    }

    override fun select() {
        println("Enter archive index")
        super.getIndex()
            ?. let { index -> super.selectItem(index) }
            ?: println("Invalid archive index")
    }

    override fun show(){
        println("Archives:")
        super.showItems()
    }
}