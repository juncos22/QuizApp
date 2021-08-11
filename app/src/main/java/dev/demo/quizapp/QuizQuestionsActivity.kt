package dev.demo.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import dev.demo.quizapp.models.Question
import dev.demo.quizapp.utils.Constants
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var questionsList: ArrayList<Question>
    private var currentPosition = 1
    private var selectedOptionPosition: Int = 0
    private var correctAnswers = 0
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        username = intent.getStringExtra(Constants.USER_NAME)

        questionsList = Constants.getQuestions()
        loadQuestion()
        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun loadQuestion() {
        progress_horizontal.progress = currentPosition
        tv_progress.text = "$currentPosition / ${progress_horizontal.max}"

        val question = questionsList[currentPosition-1]
        defaultOptionsView()

        if (currentPosition == questionsList.size) {
            btn_submit.text = "Finish"
        }else {
            btn_submit.text = "Submit"
        }
        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option1.text = question.optionOne
        tv_option2.text = question.optionTwo
        tv_option3.text = question.optionThree
        tv_option4.text = question.optionFour
    }
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option1)
        options.add(1, tv_option2)
        options.add(2, tv_option3)
        options.add(3, tv_option4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.tv_border_background)
        }
    }
    
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.tv_selected_background)
    }
    private fun answerView(answer: Int, drawablView: Int) {
        when (answer) {
            1 -> {
                tv_option1.background = ContextCompat.getDrawable(this, drawablView)
            }
            2 -> {
                tv_option2.background = ContextCompat.getDrawable(this, drawablView)
            }
            3 -> {
                tv_option3.background = ContextCompat.getDrawable(this, drawablView)
            }
            4 -> {
                tv_option4.background = ContextCompat.getDrawable(this, drawablView)
            }
        }
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option1 -> {
                selectedOptionView(tv_option1, 1)
            }
            R.id.tv_option2 -> {
                selectedOptionView(tv_option2, 2)
            }
            R.id.tv_option3 -> {
                selectedOptionView(tv_option3, 3)
            }
            R.id.tv_option4 -> {
                selectedOptionView(tv_option4, 4)
            }
            R.id.btn_submit -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionsList.size -> {
                            loadQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, username)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else {
                    val question = questionsList[currentPosition-1]
                    if (question.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_background)
                    }else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_background)

                    if (currentPosition == questionsList.size) {
                        btn_submit.text = "Finish"
                    }else {
                        btn_submit.text = "Go to the next question"
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }
}