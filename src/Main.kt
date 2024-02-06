fun main(args: Array<String>) {
    val inventory = arrayOf(
        arrayOf("Hot dogs", 10),
        arrayOf("Buns", 20),
        arrayOf("Ketchup", 15),
        arrayOf("Mustard", 15),
        arrayOf("Napkins", 50)
    )

    println("Inventory Items:")
    for (item in inventory) {
        println("- ${item[0]} (${item[1]} on hand)")
    }

    while (true) {
        println("\nEnter item name to search or type 'exit' to quit:")
        val input = readLine()?.trim()?.toLowerCase()
        if (input == "exit") break

        val foundItem = inventory.find { it[0].toString().toLowerCase() == input?.toLowerCase() }
        if (foundItem != null) {
            println("Item: ${foundItem[0]}")
            println("Amount on hand: ${foundItem[1]}")
            println("Enter 'add' or 'subtract' to modify inventory:")
            val action = readLine()?.trim()?.toLowerCase()
            if (action == "add" || action == "subtract") {
                println("Enter the amount to $action:")
                val amountChange = readLine()?.toIntOrNull() ?: 0
                val currentAmount = foundItem[1] as Int
                val newAmount = if (action == "add") currentAmount + amountChange else currentAmount - amountChange
                if (newAmount < 0) {
                    println("Error: Inventory cannot be negative. Setting to 0.")
                    foundItem[1] = 0
                } else {
                    foundItem[1] = newAmount
                    println("Updated Inventory:")
                    println("Item: ${foundItem[0]}")
                    println("Original Amount: $currentAmount")
                    println("Amount $action: $amountChange")
                    println("New Total: $newAmount")
                }
            } else {
                println("Invalid action.")
            }
        } else {
            println("Item not found.")
        }
    }
}