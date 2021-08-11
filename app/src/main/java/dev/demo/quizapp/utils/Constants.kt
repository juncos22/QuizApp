package dev.demo.quizapp.utils

import dev.demo.quizapp.R
import dev.demo.quizapp.models.Question

object Constants {
    const val USER_NAME: String = "username"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val q1 = Question(1,
            "What country does this flag belong to?",
        R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
        "Austria",
            1)

        val q2 = Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Germany",
            "Australia",
            "Armenia",
            "Argentina",
            2)

        val q3 = Question(3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Austria",
            "Germany",
            "Belgium",
            "Armenia",
            3)

        val q4 = Question(4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Germany",
            "Brazil",
            "Armenia",
            "Australia",
            2)

        val q5 = Question(5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Finland",
            "Italy",
            "Denmark",
            "Australia",
            3)
        val q6 = Question(6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "France",
            "Fiji",
            "Italy",
            "Norway",
            2)

        val q7 = Question(7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Norway",
            "Italy",
            "France",
            1)

        val q8 = Question(8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Austria",
            "India",
            "Brazil",
            "Armenia",
            2)

        val q9 = Question(9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "France",
            "Italy",
            "Armenia",
            "Kuwait",
            4)

        val q10 = Question(10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "France",
            "Denmark",
            "Finland",
            1)

        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)

        return questionsList
    }
}