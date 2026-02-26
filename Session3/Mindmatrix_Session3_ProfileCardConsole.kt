/**
 * Mindmatrix Internship
 * Session 3 Lab
 * Profile Card Console Program
 *
 * Objective:
 * Create a dynamic console program that displays formatted user profile cards
 * with an optional ASCII avatar box.
 *
 * Concepts Used:
 * - Data Class
 * - Functions
 * - Loops
 * - String Templates
 * - Formatted Console Output
 */

 // -------------------------------
 // Data Class
 // -------------------------------
data class Profile(
    val name: String,
    val title: String,
    val bio: String
)


// -------------------------------
// Avatar Renderer
// -------------------------------
fun renderAvatar(width: Int, height: Int): String {

    val avatarText = "Avatar"
    val result = StringBuilder()

    for (i in 1..height) {

        if (i == height / 2) {
            val padding = (width - avatarText.length) / 2

            val line = " ".repeat(padding) +
                    avatarText +
                    " ".repeat(width - padding - avatarText.length)

            result.append("|$line|\n")
        } else {
            result.append("|" + " ".repeat(width) + "|\n")
        }
    }

    return result.toString()
}


// -------------------------------
// Text Block Renderer
// -------------------------------
fun renderTextBlock(label: String, text: String, width: Int): String {

    var content = "$label: $text"

    // Trim if content exceeds width
    if (content.length > width) {
        content = content.substring(0, width)
    }

    val padding = width - content.length

    return "|" + content + " ".repeat(padding) + "|\n"
}


// -------------------------------
// Profile Card Builder
// -------------------------------
fun renderProfile(
    profile: Profile,
    width: Int = 30,
    showAvatar: Boolean = true
): String {

    val border = "+" + "-".repeat(width) + "+\n"
    val result = StringBuilder()

    result.append(border)

    if (showAvatar) {
        result.append(renderAvatar(width, 3))
    }

    result.append(renderTextBlock("Name", profile.name, width))
    result.append(renderTextBlock("Title", profile.title, width))
    result.append(renderTextBlock("Bio", profile.bio, width))

    result.append(border)

    return result.toString()
}


// -------------------------------
// Main Function
// -------------------------------
fun main() {

    val profile1 = Profile(
        "Ada Lovelace",
        "Software Developer",
        "Early computing pioneer"
    )

    val profile2 = Profile(
        "Alan Turing",
        "Scientist",
        "Father of Computer Science"
    )

    val profile3 = Profile(
        "Keerthi R Naik",
        "Engineering Student",
        "Learning Kotlin and Jetpack Compose"
    )

    // Profile with avatar
    println(renderProfile(profile1, 30, true))

    // Profile without avatar
    println(renderProfile(profile2, 30, false))

    // Another profile with avatar
    println(renderProfile(profile3, 30, true))
}
