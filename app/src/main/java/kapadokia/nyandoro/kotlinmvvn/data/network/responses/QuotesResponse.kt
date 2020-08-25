package kapadokia.nyandoro.kotlinmvvn.data.network.responses

import kapadokia.nyandoro.kotlinmvvn.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)