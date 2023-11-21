import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Transient

@kotlinx.serialization.Serializable
data class Quiz(@Transient val name: String="My quiz", val questions: List<Question>)
