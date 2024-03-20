package net.sileader.net.sileader.nom

sealed interface ParseErrorKind {
    data object Complete : ParseErrorKind
    data object Length : ParseErrorKind
    data object Alt : ParseErrorKind
    data object Char : ParseErrorKind
    data object Tag : ParseErrorKind
    data object Many : ParseErrorKind
}

class ParseException(val kind: ParseErrorKind) : RuntimeException()

interface Parser<O> {
    fun parse(input: String): Pair<String, O>
    fun <O2> and(g: Parser<O2>): And<O, O2> = And(this, g)
    fun or(g: Parser<O>): Or<O> = Or(this, g)

    operator fun invoke(input: String): Pair<String, O> = parse(input)
}

data class And<O1, O2>(
    private val parser1: Parser<O1>,
    private val parser2: Parser<O2>,
) : Parser<Pair<O1, O2>> {
    override fun parse(input: String): Pair<String, Pair<O1, O2>> {
        val (i1, o1) = parser1.parse(input)
        val (i2, o2) = parser2.parse(i1)
        return Pair(i2, Pair(o1, o2))
    }
}

data class Or<O>(
    private val parser1: Parser<O>,
    private val parser2: Parser<O>,
) : Parser<O> {
    override fun parse(input: String): Pair<String, O> = try {
        parser1.parse(input)
    } catch (e: ParseException) {
        parser2.parse(input)
    }
}

private data class FunctionParser<O>(
    private val f: (String) -> Pair<String, O>
) : Parser<O> {
    override fun parse(input: String): Pair<String, O> = f(input)
}

class ParserScope {
    fun <O> parser(f: (String) -> Pair<String, O>): Parser<O> = FunctionParser(f)

    fun error(errorKind: ParseErrorKind): Nothing = throw ParseException(errorKind)

    fun <O> ok(next: String, output: O): Pair<String, O> = Pair(next, output)
}

fun <O> parse(input: String, parser: ParserScope.(String) -> Pair<String, O>): Pair<String, O>? {
    val scope = ParserScope()
    return try {
        parser(scope, input)
    } catch (e: ParseException) {
        null
    }
}
