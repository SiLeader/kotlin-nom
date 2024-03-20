package net.sileader.net.sileader.nom.combinator

import net.sileader.net.sileader.nom.ParseException
import net.sileader.net.sileader.nom.Parser
import net.sileader.net.sileader.nom.ParserScope

internal fun <O> optImpl(input: String, parser: Parser<O>): Pair<String, O?> = try {
    parser.parse(input)
} catch (e: ParseException) {
    Pair(input, null)
}

fun <O> ParserScope.opt(content: Parser<O>) = parser { optImpl(it, content) }
