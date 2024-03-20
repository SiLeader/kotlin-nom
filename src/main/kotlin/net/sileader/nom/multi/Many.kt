package net.sileader.net.sileader.nom.multi

import net.sileader.net.sileader.nom.ParseErrorKind
import net.sileader.net.sileader.nom.ParseException
import net.sileader.net.sileader.nom.Parser
import net.sileader.net.sileader.nom.ParserScope

fun <O> ParserScope.many(parser: Parser<O>, minLength: Int = 0, maxLength: Int = Int.MAX_VALUE) = parser {
    val values = mutableListOf<O>()

    var input = it
    for (i in 0..maxLength) {
        try {
            val res = parser.parse(input)
            input = res.first
            values.add(res.second)
        } catch (e: ParseException) {
            return@parser if (i < minLength) {
                error(ParseErrorKind.Many)
            } else {
                ok(input, values)
            }
        }
    }

    error(ParseErrorKind.Many)
}