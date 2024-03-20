package net.sileader.nom.branch

import net.sileader.net.sileader.nom.branch.permutation
import net.sileader.net.sileader.nom.character.alpha
import net.sileader.net.sileader.nom.character.digit
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PermutationTest {
    private fun parser(input: String) = parse(input) {
        permutation(alpha(minLength = 1), digit(minLength = 1))(it)
    }

    @Test
    fun test_abc123() {
        val res = parser("abc123")
        assertEquals("", res?.first)
        assertEquals(Pair("abc", "123"), res?.second)
    }

    @Test
    fun test_123abc() {
        val res = parser("123abc")
        assertEquals("", res?.first)
        assertEquals(Pair("abc", "123"), res?.second)
    }

    @Test
    fun test_abc() {
        val res = parser("abc;")
        assertNull(res)
    }
}