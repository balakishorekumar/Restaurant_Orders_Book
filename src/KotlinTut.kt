fun main() {
    val orderList = mutableListOf<Order>()


    orderList.add(Order(1).addItem(Noodles()))

    orderList.add(Order(2).addItem(Vegetables()))


    val items = listOf(Noodles(), Vegetables("cabbage", "onion", "radish", "tomato"))
    orderList.add(Order(3).addAll(items))

    orderList.add(Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage ", "Onion")))


    orderList.add(Order(5).addItem(Noodles()).addItem(Noodles()).addItem(Vegetables("Spinach")))

    for (order in orderList) {
        order.print()
        println()
    }

}

class Order(private val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }

    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    private var total = 0
    fun print() {
        println("Order #${orderNumber}")
        for (item in itemList) {
            println("$item: $${item.price}")
            total += item.price
        }
        println("Total is : $total")
    }

}

open class Item(val name: String, val price: Int)
class Vegetables(private vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return if (toppings.isEmpty()) {
            "$name Chef's choice"
        } else {
            name + " " + toppings.joinToString()
        }
    }
}

class Noodles : Item("noodles", 10) {
    override fun toString(): String {
        return "$name "
    }
}


