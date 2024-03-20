package net.sileader.nom.multi

import net.sileader.net.sileader.nom.character.tag
import net.sileader.net.sileader.nom.multi.many
import net.sileader.net.sileader.nom.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class ManyTest {
    private fun parser(input: String) = parse(input) {
        many(tag("abc"))(it)
    }

    @Test
    fun test_abcabc() {
        val res = parser("abcabc")
        assertEquals("", res?.first)
        val expected = buildList {
            add("abc")
            add("abc")
        }
        assertEquals(res?.second?.size, 2)
        for (i in 0..expected.lastIndex) {
            assertEquals(expected[i], res?.second?.getOrNull(i))
        }
    }

    @Test
    fun test_abc123() {
        val res = parser("abc123")
        assertEquals("123", res?.first)
        val expected = buildList {
            add("abc")
        }
        assertEquals(res?.second?.size, 1)
        for (i in 0..expected.lastIndex) {
            assertEquals(expected[i], res?.second?.getOrNull(i))
        }
    }

    @Test
    fun test_123123() {
        val res = parser("123123")
        assertEquals("123123", res?.first)
        assertEquals(res?.second?.size, 0)
    }

    @Test
    fun test_blank() {
        val res = parser("")
        assertEquals("", res?.first)
        assertEquals(res?.second?.size, 0)
    }
}