class ArchiveMenu(val name: String) : MenuItem() {
    override val menuTitle: String = "Archive $name"
    override val menuItemName: String = "note"

    override fun toString(): String {
        return name
    }

    override fun add() {
        println("Enter note title")
        getText()
            ?.let { title ->
                addItem(NoteMenu(title))
                println("Added note \"$title\"")
            }
            ?: println("Invalid note title")
    }

    override fun remove() {
        println("Enter note index")
        getIndex()
            ?.let { index ->
                removeItem(index)
                println("Note removed")
            }
            ?: println("Invalid note index")
    }

    override fun select() {
        println("Enter note index")
        getIndex()
            ?.let { index -> selectItem(index) }
            ?: println("Invalid note index")
    }

    override fun show() {
        println("Notes:")
        showItems()
    }
}