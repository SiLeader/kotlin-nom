package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.ParserScope

fun ParserScope.char(char: Char) = parser {
    val first = it.firstOrNull()
    if (first == null || first != char) {
        error(ParseErrorKind.Char)
    } else {
        ok(it.drop(1), char)
    }
}
