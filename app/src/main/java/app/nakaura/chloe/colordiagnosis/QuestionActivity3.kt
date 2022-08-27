package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion2Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion3Binding

class QuestionActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion3Binding
    var point3: Int = 0
    var sum2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestion3Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        val question4Intent: Intent = Intent (this, QuestionActivity4::class.java)
        question4Intent.getIntExtra("sum1",0)
        val sum1 =intent.getIntExtra("sum1", 0)
        println(sum1)

        binding.answerButton1.setOnClickListener{
            point3 = 1
            println("point3=$point3")
            sum2 = sum1 + point3
            question4Intent.putExtra("sum2",sum2)
            startActivity(question4Intent)
        }

        binding.answerButton2.setOnClickListener{
            point3 = 2
            println("point3=$point3")
            sum2 = sum1 + point3
            question4Intent.putExtra("sum2",sum2)
            startActivity(question4Intent)
        }

        binding.answerButton3.setOnClickListener{
            point3 = 3
            println("point3=$point3")
            sum2 = sum1 + point3
            question4Intent.putExtra("sum2",sum2)
            startActivity(question4Intent)
        }
    }
}



