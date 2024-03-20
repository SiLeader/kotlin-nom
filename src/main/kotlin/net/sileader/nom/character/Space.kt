package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParserScope

fun ParserScope.space(minLength: Int = 0, maxLength: Int = Int.MAX_VALUE) =
    charParser(length = minLength..maxLength) { it == ' ' || it == '\t' }
