package net.sileader.nom.branch

import net.sileader.net.sileader.nom.branch.alt
import net.sileader.net.sileader.nom.character.alpha
import net.sileader.net.sileader.nom.character.digit
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AltTest {
    private fun parser(input: String) = parse(input) {
        alt(alpha(minLength = 1), digit(minLength = 1))(it)
    }

    @Test
    fun test_abc() {
        val res = parser("abc")
        assertEquals("", res?.first)
        assertEquals("abc", res?.second)
    }

    @Test
    fun test_123456() {
        val res = parser("123456")
        assertEquals("", res?.first)
        assertEquals("123456", res?.second)
    }

    @Test
    fun test_space() {
        val res = parser(" ")
        assertNull(res)
    }
}