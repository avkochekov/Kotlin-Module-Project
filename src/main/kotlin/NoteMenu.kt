class NoteMenu (val title: String, private var content: String = "") : MenuItem() {
    override fun toString(): String {
        return "Title: $title\n" +
                "Text: $content"
    }

    override fun showMenu() {
        println("==================")
        println("Note: $title")
        println("==================")
        println("1. Show note text")
        println("2. Set note text")
        println("3. Remove note text")
        println("5. Exit")
    }

    override fun handleMenu() {
        while (true){
            scanner.nextLine().toIntOrNull()
                ?.let {
                        value ->
                    when(value) {
                        1 -> show()
                        2 -> add()
                        3 -> remove()
                        5 -> return
                        else -> println("Invalid input, try again")
                    }
                    showMenu()
                }
                ?: println("Invalid input, try again")
        }
    }

    override fun add() {
        println("Enter note text")
        getText()?. let { text -> content = text }
    }

    override fun remove() {
        content = ""
        println("Text removed")
    }

    override fun select() { }

    override fun show(){
        println(this)
    }
}