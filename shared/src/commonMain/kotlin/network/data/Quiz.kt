package network.data

import kotlinx.serialization.Transient
import network.data.Question

@kotlinx.serialization.Serializable
data class Quiz(@Transient var name: String = "My quiz", val questions: List<Question>)
