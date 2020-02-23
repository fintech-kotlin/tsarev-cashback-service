package ru.tinkoff.fintech.service.notification

import ru.tinkoff.fintech.model.NotificationMessageInfo
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

class NotificationMessageGeneratorImpl(
        private val cardNumberMasker: CardNumberMasker
) : NotificationMessageGenerator {

    val cardMasker: CardNumberMasker = CardNumberMaskerImpl();

    override fun generateMessage(notificationMessageInfo: NotificationMessageInfo): String {
        return "Уважаемый, ${notificationMessageInfo.name}!\n" +
                "Спешим Вам сообщить, что на карту ${cardMasker.mask(notificationMessageInfo.cardNumber)}\n" +
                "начислен cashback в размере ${notificationMessageInfo.cashback}\n" +
                "за категорию ${notificationMessageInfo.category}.\n" +
                "Спасибо за покупку ${notificationMessageInfo.transactionDate.truncatedTo(ChronoUnit.MINUTES)}"
    }
}