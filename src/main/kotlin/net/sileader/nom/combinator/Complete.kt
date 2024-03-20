package net.sileader.net.sileader.nom.combinator

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.Parser
import net.sileader.net.sileader.nom.ParserScope

fun <O> ParserScope.complete(parser: Parser<O>) = parser {
    val (i, o) = parser(it)
    if (i.isEmpty()) {
        error(ParseErrorKind.Complete)
    } else {
        ok(i, o)
    }
}
