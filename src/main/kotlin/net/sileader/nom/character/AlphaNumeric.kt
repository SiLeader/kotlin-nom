package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParserScope

fun ParserScope.alphanumeric(minLength: Int = 0, maxLength: Int = Int.MAX_VALUE) =
    charParser(length = minLength..maxLength) { it.isAlpha() || it.isDigit() }
