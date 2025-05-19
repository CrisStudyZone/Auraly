package com.serdigital.auraly.domain.model

enum class PaymentMethod(val label: String) {
    WALLET_TRANSFER("Transferencia billetera"),
    BANK_TRANSFER("Transferencia Banco"),
    CASH("Efectivo")
}
