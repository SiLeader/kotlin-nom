package net.sileader.net.sileader.nom.branch

import net.sileader.net.sileader.nom.Parser
import net.sileader.net.sileader.nom.ParserScope
import net.sileader.net.sileader.nom.combinator.optImpl

interface Permutation<O> {
    fun permutation(input: String): Pair<String, O>
}

private data class TwoPermutation<O1, O2>(
    private val parser1: Parser<O1>,
    private val parser2: Parser<O2>,
) : Permutation<Pair<O1, O2>> {
    override fun permutation(input: String): Pair<String, Pair<O1, O2>> {
        val (i12, o12) = optImpl(input, parser1.and(parser2))
        if (o12 != null) {
            return Pair(i12, o12)
        }
        val (i21, o21) = parser2.and(parser1)(input)
        val (o2, o1) = o21

        return Pair(i21, Pair(o1, o2))
    }
}

fun <O> ParserScope.permutation(permutation: Permutation<O>) = parser {
    permutation.permutation(it)
}

fun <O1, O2> ParserScope.permutation(parser1: Parser<O1>, parser2: Parser<O2>) =
    permutation(TwoPermutation(parser1, parser2))
