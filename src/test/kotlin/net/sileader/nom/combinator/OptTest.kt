package net.sileader.nom.combinator

import net.sileader.net.sileader.nom.character.alpha
import net.sileader.net.sileader.nom.combinator.opt
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class OptTest {
    private fun parser(input: String) = parse(input) {
        opt(alpha(minLength = 1))(it)
    }

    @Test
    fun test_abcd() {
        val res = parser("abcd;")
        assertEquals(";", res?.first)
        assertEquals("abcd", res?.second)
    }

    @Test
    fun test_123() {
        val res = parser("123;")
        assertEquals("123;", res?.first)
        assertNull(res?.second)
    }
}