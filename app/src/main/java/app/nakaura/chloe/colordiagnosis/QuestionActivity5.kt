package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion3Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion5Binding

class QuestionActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion5Binding
    var point5: Int = 0
    var sum4: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestion5Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        val question6Intent: Intent = Intent(this, QuestionActivity6::class.java)
        question6Intent.getIntExtra("sum3", 0)
        val sum3 = intent.getIntExtra("sum3", 0)
        println(sum3)

        binding.answerButton1.setOnClickListener {
            point5 = 1
            println("point5=$point5")
            sum4 = sum3 + point5
            question6Intent.putExtra("sum4", sum4)
            startActivity(question6Intent)
        }

        binding.answerButton2.setOnClickListener {
            point5 = 2
            println("point5=$point5")
            sum4 = sum3 + point5
            question6Intent.putExtra("sum4", sum4)
            startActivity(question6Intent)
        }

        binding.answerButton3.setOnClickListener {
            point5 = 3
            println("point5=$point5")
            sum4 = sum3 + point5
            question6Intent.putExtra("sum4", sum4)
            startActivity(question6Intent)
        }
    }
}