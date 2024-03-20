package net.sileader.nom.character

import net.sileader.net.sileader.nom.character.space
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class SpaceTest {
    private fun parser(input: String) = parse(input) {
        space()(it)
    }

    @Test
    fun test_space_tab_21c() {
        val res = parser(" \t21c")
        assertEquals("21c", res?.first)
        assertEquals(" \t", res?.second)
    }

    @Test
    fun test_Z21c() {
        val res = parser("Z21c")
        assertEquals("Z21c", res?.first)
        assertEquals("", res?.second)
    }

    @Test
    fun test_blank() {
        val res = parser("")
        assertEquals("", res?.first)
        assertEquals("", res?.second)
    }
}