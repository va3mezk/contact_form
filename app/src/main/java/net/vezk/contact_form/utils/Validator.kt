package net.vezk.contact_form.utils

import java.util.regex.*

/**
 * 馃嚜馃嚫
 * class [Validator] es la encargada de validar las TextView de
 * correo electr贸nico y tel茅fono.
 *
 * 馃嚭馃嚫
 * class [Validator] is in charge of validating the TextView of
 * email and telephone.
 **/
class Validator {
    companion object {
        /**
         * 馃嚜馃嚫
         *  fun [validText] recibe un par de par谩metros
         * @param typeText es el 1 Correo electr贸nico y 2 T茅lefono
         * @param tvValue es el valor de la textView a validar
         * @return un valor booleano verdadero y es v谩lido el valor y falso si los datos
         * de entrada est谩n escritos incorrectamente.
         *
         * 馃嚭馃嚫
         * fun [validText] receives a pair of parameters
         * @param typeText is 1 Email and 2 Phone
         * @param tvValue is the value of the textView to validate
         * @return a boolean value true and the value is valid and false if the data
         * input are misspelled.
         **/
        fun validText(typeText: Int, tvValue: String): Boolean {
            val pattern: Pattern =
                Pattern.compile(typeValidation(typeText), Pattern.CASE_INSENSITIVE)
            val matcher: Matcher = pattern.matcher(tvValue)
            return matcher.matches()
        }
        /**
         * 馃嚜馃嚫
         * fun [typeValidation]
         * esta funci贸n simplemente implementa la cadena de validaci贸n
         * para correo electr贸nico o tel茅fono
         *
         * 馃嚭馃嚫
         * fun [typeValidation]
         * this function simply implements the validation string
         * for email or phone
         **/
        private fun typeValidation(typeText: Int): String {
            return when (typeText) {
                1 -> "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
                2 -> "^[+]?[0-9]{10,13}\$"
                else -> ""
            }
        }
    }
}