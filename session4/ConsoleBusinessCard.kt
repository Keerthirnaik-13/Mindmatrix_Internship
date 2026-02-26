data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)

fun centerText(text: String, width: Int): String {
    val padding = (width - text.length) / 2
    return " ".repeat(padding.coerceAtLeast(0)) + text
}

fun printLine(width: Int) {
    println("-".repeat(width))
}

fun printEmptyRow(width: Int) {
    println("|" + " ".repeat(width - 2) + "|")
}

fun printLogo(width: Int) {
    val logoText = "[ANDROID]"
    val centeredLogo = centerText(logoText, width - 2)
    println("|$centeredLogo" + " ".repeat((width - 2) - centeredLogo.length) + "|")
}

fun printHeader(card: BusinessCard, width: Int) {
    val centeredName = centerText(card.name, width - 2)
    val centeredTitle = centerText(card.title, width - 2)

    println("|$centeredName" + " ".repeat((width - 2) - centeredName.length) + "|")
    println("|$centeredTitle" + " ".repeat((width - 2) - centeredTitle.length) + "|")
}

fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (showContacts) {
        val phoneText = "Phone: ${card.phone}"
        val emailText = "Email: ${card.email}"

        println("|  $phoneText" + " ".repeat((width - 4) - phoneText.length) + "|")
        println("|  $emailText" + " ".repeat((width - 4) - emailText.length) + "|")
    }
}

fun main() {
    val cardWidth = 50
    val showContacts = true

    val myCard = BusinessCard(
        name = "Keerthi R Naik",
        title = "Android Developer",
        phone = "+91-XXXXXXXXXX",
        email = "keerthi@example.com"
    )

    printLine(cardWidth)
    printLogo(cardWidth)
    printEmptyRow(cardWidth)
    printHeader(myCard, cardWidth)
    printEmptyRow(cardWidth)
    printContacts(myCard, cardWidth, showContacts)
    printLine(cardWidth)
}
