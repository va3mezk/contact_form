package net.vezk.contact_form.util

import java.util.regex.*

class Validator {
    companion object {
        fun validText(typeText: Int, tvValue: String): Boolean {
            val pattern: Pattern =
                Pattern.compile(typeValidation(typeText), Pattern.CASE_INSENSITIVE)
            val matcher: Matcher = pattern.matcher(tvValue)
            return matcher.matches()
        }

        private fun typeValidation(typeText: Int): String {
            return when (typeText) {
                1 -> "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
                2 -> "^[+]?[0-9]{10,13}\$"
                else -> ""
            }
        }
    }
}


