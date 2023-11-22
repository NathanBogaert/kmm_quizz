package network.data

import kotlinx.serialization.Transient
import network.data.Question

@kotlinx.serialization.Serializable
data class Quiz(@Transient val name: String = "My quiz", val questions: List<Question>)
