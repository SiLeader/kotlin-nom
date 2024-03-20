package net.sileader.nom.character

import net.sileader.net.sileader.nom.character.char
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CharTest {
    private fun parser(input: String) = parse(input) {
        char('a')(it)
    }

    @Test
    fun test_abc() {
        val res = parser("abc")
        assertEquals("bc", res?.first)
        assertEquals('a', res?.second)
    }

    @Test
    fun test_space_abc() {
        val res = parser(" abc")
        assertNull(res)
    }

    @Test
    fun test_bc() {
        val res = parser("bc")
        assertNull(res)
    }

    @Test
    fun test_blank() {
        val res = parser("")
        assertNull(res)
    }
}