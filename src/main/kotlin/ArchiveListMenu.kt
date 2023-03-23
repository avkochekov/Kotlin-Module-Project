class ArchiveListMenu : MenuItem() {
    override val menuTitle: String = "Archive list"
    override val menuItemName: String = "archive"

    override fun toString(): String {
        return "Archive list"
    }

    override fun add() {
        println("Enter archive title")
        getText()
            ?.let { title ->
                addItem(ArchiveMenu(title))
                println("Added archive \"$title\"")
            }
            ?: println("Invalid archive title")
    }

    override fun remove() {
        println("Enter archive index")
        getIndex()
            ?.let { index ->
                removeItem(index)
                println("Archive removed")
            }
            ?: println("Invalid archive index")
    }

    override fun select() {
        println("Enter archive index")
        getIndex()
            ?.let { index -> selectItem(index) }
            ?: println("Invalid archive index")
    }

    override fun show() {
        println("Archives:")
        showItems()
    }
}