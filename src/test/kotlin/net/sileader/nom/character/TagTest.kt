package net.sileader.nom.character

import net.sileader.net.sileader.nom.character.tag
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TagTest {
    private fun parser(input: String) = parse(input) {
        tag("Hello")(input)
    }

    @Test
    fun test_HelloWorld() {
        val res = parser("Hello, World!")
        assertEquals(", World!", res?.first)
        assertEquals("Hello", res?.second)
    }

    @Test
    fun test_Something() {
        val res = parser("Something")
        assertNull(res)
    }

    @Test
    fun test_blank() {
        val res = parser("")
        assertNull(res)
    }
}