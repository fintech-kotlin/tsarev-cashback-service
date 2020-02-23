package ru.tinkoff.fintech.service.notification

class CardNumberMaskerImpl : CardNumberMasker {

    override fun mask(cardNumber: String, maskChar: Char, start: Int, end: Int): String {
        return when {
            cardNumber.isEmpty() -> ""
            end > cardNumber.length -> maskChar.toString().repeat(cardNumber.length)
            end < start -> throw Exception("Start index cannot be greater than end index")
            else -> (cardNumber.takeIf { !it.isEmpty() }
                    ?: "").replaceRange(start, end, maskChar.toString().repeat(end - start))
        }
    }
}