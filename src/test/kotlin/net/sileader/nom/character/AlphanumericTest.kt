package net.sileader.nom.character

import net.sileader.net.sileader.nom.character.alphanumeric
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class AlphanumericTest {
    private fun parser(input: String) = parse(input) {
        alphanumeric()(it)
    }

    @Test
    fun `test_21cZ%1`() {
        val res = parser("21cZ%1")
        assertEquals("%1", res?.first)
        assertEquals("21cZ", res?.second)
    }

    @Test
    fun `test_&Z21c`() {
        val res = parser("&Z21c")
        assertEquals("&Z21c", res?.first)
        assertEquals("", res?.second)
    }

    @Test
    fun `test_blank`() {
        val res = parser("")
        assertEquals("", res?.first)
        assertEquals("", res?.second)
    }
}