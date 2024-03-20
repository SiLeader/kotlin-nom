package net.sileader.net.sileader.nom.branch

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.ParseException
import net.sileader.net.sileader.nom.Parser
import net.sileader.net.sileader.nom.ParserScope

interface Alt<O> {
    fun choice(input: String): Pair<String, O>
}

private class IterableAlt<O>(
    val branches: Iterable<Parser<O>>
) : Alt<O> {
    private fun parseOne(input: String, parser: Parser<O>): Pair<String, O>? = try {
        parser.parse(input)
    } catch (e: ParseException) {
        null
    }

    override fun choice(input: String): Pair<String, O> {
        for (parser in branches) {
            val res = parseOne(input, parser)
            if (res != null) {
                return res
            }
        }
        throw ParseException(ParseErrorKind.Alt)
    }
}

fun <O> ParserScope.alt(alt: Alt<O>) = parser { alt.choice(it) }

fun <O> ParserScope.alt(vararg parser: Parser<O>) = alt(IterableAlt(parser.asIterable()))
