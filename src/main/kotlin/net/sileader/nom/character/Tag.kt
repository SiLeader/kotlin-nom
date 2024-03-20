package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.ParserScope

fun ParserScope.tag(tag: String) = parser {
    if (it.startsWith(tag)) {
        ok(it.substring(tag.length), tag)
    } else {
        error(ParseErrorKind.Tag)
    }
}
