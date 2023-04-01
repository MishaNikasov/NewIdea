package nikasov.domain.entitiy

import java.time.LocalDateTime

data class Session(
    val id: Long,
    val title: String,
    val date: LocalDateTime,
    val advices: List<Advice>
)