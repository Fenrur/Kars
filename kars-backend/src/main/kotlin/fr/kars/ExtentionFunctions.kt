package fr.kars

import org.jooq.DSLContext
import org.jooq.TransactionalCallable

fun fr.kars.jooq.enums.PartyEventType.toDomain(): fr.kars.PartyEventType {
    return when(this) {
        fr.kars.jooq.enums.PartyEventType.public -> fr.kars.PartyEventType.Public
        fr.kars.jooq.enums.PartyEventType.private -> fr.kars.PartyEventType.Private
    }
}

fun fr.kars.PartyEventType.toJooq(): fr.kars.jooq.enums.PartyEventType {
    return when(this) {
        fr.kars.PartyEventType.Public -> fr.kars.jooq.enums.PartyEventType.public
        fr.kars.PartyEventType.Private -> fr.kars.jooq.enums.PartyEventType.private
    }
}

inline fun<T> DSLContext.transactional(crossinline block: () -> T): T {
    return this.transactionResult(TransactionalCallable {
        return@TransactionalCallable block()
    })
}