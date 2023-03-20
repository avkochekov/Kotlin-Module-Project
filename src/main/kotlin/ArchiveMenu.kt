import java.util.*

class ArchiveMenu(val name: String) : MenuItem() {
    override fun toString(): String {
        return name
    }

    override fun showMenu() {
        println("==================")
        println("Archive \"$name\" menu:")
        println("==================")
        println("1. Create note")
        println("2. Remove note")
        println("3. Show available notes")
        println("4. Select note")
        println("5. Exit")
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
        println("Enter note title")
        super.getText()
            ?. let { title ->
                super.addItem(Note(title))
                println("Added note \"$title\"")
            }
            ?: println("Invalid note title")
    }

    override fun remove() {
        println("Enter note index")
        super.getIndex()
            ?. let { index ->
                super.removeItem(index)
                println("Note removed")
            }
            ?: println("Invalid note index")
    }

    override fun select() {
        println("Enter note index")
        super.getIndex()
            ?. let { index -> super.selectItem(index) }
            ?: println("Invalid note index")
    }

    override fun show(){
        println("Notes:")
        super.showItems()
    }
}