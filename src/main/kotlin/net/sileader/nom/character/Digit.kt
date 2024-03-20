package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParserScope

private val numeric = hashSetOf(
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
)

internal fun Char.isDigit(): Boolean = numeric.contains(this)

fun ParserScope.digit(minLength: Int = 0, maxLength: Int = Int.MAX_VALUE) =
    charParser(length = minLength..maxLength) { it.isDigit() }
