package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityMainBinding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    var point1: Int = 0
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityQuestionBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val question2Intent: Intent = Intent (this, QuestionActivity2::class.java)

        binding.answerButton1.setOnClickListener{
            point1 = 1
            println("point1=$point1")
            question2Intent.putExtra("point1",point1)
            startActivity(question2Intent)
        }

        binding.answerButton2.setOnClickListener{
            point1 = 2
            println("point1=$point1")
            question2Intent.putExtra("point1",point1)
            startActivity(question2Intent)
        }

        binding.answerButton3.setOnClickListener{
            point1 = 3
            println("point1=$point1")
            question2Intent.putExtra("point1",point1)
            startActivity(question2Intent)
        }
    }
}