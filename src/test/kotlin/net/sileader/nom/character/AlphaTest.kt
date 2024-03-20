package net.sileader.nom.character

import net.sileader.net.sileader.nom.character.alpha
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class AlphaTest {
    private fun parser(input: String) = parse(input) {
        alpha()(it)
    }

    @Test
    fun test_alpha_abc() {
        val res = parser("abc")
        assertEquals("", res?.first)
        assertEquals("abc", res?.second)
    }

    @Test
    fun test_alpha_ab1c() {
        val res = parser("ab1c")
        assertEquals("1c", res?.first)
        assertEquals("ab", res?.second)
    }

    @Test
    fun test_alpha_1c() {
        val res = parser("1c")
        assertEquals("1c", res?.first)
        assertEquals("", res?.second)
    }

    @Test
    fun test_alpha_blank() {
        val res = parser("")
        assertEquals("", res?.first)
        assertEquals("", res?.second)
    }
}