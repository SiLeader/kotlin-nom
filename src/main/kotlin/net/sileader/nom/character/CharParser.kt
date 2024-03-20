package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.ParserScope

internal fun ParserScope.charParser(length: IntRange, predicate: (Char) -> Boolean) = parser {
    val ok: (Int) -> Pair<String, String> = { i ->
        ok(it.substring(i), it.substring(0, i))
    }

    for (i in 0..length.last) {
        val char = it.getOrNull(i) ?: return@parser ok(i)

        if (!predicate(char)) {
            return@parser if (i < length.first) {
                error(ParseErrorKind.Length)
            } else {
                ok(i)
            }
        }
    }
    error(ParseErrorKind.Length)
}
