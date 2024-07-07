package epicarchitect.testarch.utils

object Regexps {
    fun integersOrEmpty(maxCharCount: Int): Regex {
        val count = maxCharCount - 1
        return "^\$|^[1-9][0-9]{0,$count}$".toRegex()
    }
}