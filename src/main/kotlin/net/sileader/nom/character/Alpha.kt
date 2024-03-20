package net.sileader.net.sileader.nom.character

import net.sileader.net.sileader.nom.ParserScope

private val alphabet = hashSetOf(
    'a',
    'b',
    'c',
    'd',
    'e',
    'f',
    'g',
    'h',
    'i',
    'j',
    'k',
    'l',
    'm',
    'n',
    'o',
    'p',
    'q',
    'r',
    's',
    't',
    'u',
    'v',
    'w',
    'x',
    'y',
    'z',
    'A',
    'B',
    'C',
    'D',
    'E',
    'F',
    'G',
    'H',
    'I',
    'J',
    'K',
    'L',
    'M',
    'N',
    'O',
    'P',
    'Q',
    'R',
    'S',
    'T',
    'U',
    'V',
    'W',
    'X',
    'Y',
    'Z'
)

internal fun Char.isAlpha(): Boolean = alphabet.contains(this)

fun ParserScope.alpha(minLength: Int = 0, maxLength: Int = Int.MAX_VALUE) =
    charParser(length = minLength..maxLength) { it.isAlpha() }
