@kotlinx.serialization.Serializable
data class Question(val id: Int, val label: String, val correct_answer_id: Int, val answers: List<Answer>)
