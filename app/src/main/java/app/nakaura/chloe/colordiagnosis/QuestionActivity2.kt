package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion2Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestionBinding

class QuestionActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion2Binding
    var point2: Int = 0
    var sum1: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestion2Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        val question3Intent: Intent = Intent (this, QuestionActivity3::class.java)
        question3Intent.getIntExtra("point1",0)
        val point1 =intent.getIntExtra("point1", 0)
        println(point1)

        binding.answerButton1.setOnClickListener{
            point2 = 1
            println("point2=$point2")
            sum1 = point2 + point1
            question3Intent.putExtra("sum1",sum1)
            startActivity(question3Intent)
        }

        binding.answerButton2.setOnClickListener{
            point2 = 2
            println("point2=$point2")
            sum1 = point2 + point1
            question3Intent.putExtra("sum1",sum1)
            startActivity(question3Intent)
        }

        binding.answerButton3.setOnClickListener{
            point2 = 3
            println("point2=$point2")
            sum1 = point2 + point1
            question3Intent.putExtra("sum1",sum1)
            startActivity(question3Intent)
        }
    }
}
