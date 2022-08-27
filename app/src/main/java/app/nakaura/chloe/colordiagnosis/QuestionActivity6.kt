package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion5Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion6Binding

class QuestionActivity6 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion6Binding
    var point6: Int = 0
    var sum5: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestion6Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        val question7Intent: Intent = Intent (this, QuestionActivity7::class.java)
        question7Intent.getIntExtra("sum4", 0)
        val sum4 = intent.getIntExtra("sum4", 0)
        println(sum4)

        binding.answerButton1.setOnClickListener{
            point6 = 1
            println("point6=$point6")
            sum5 = sum4 + point6
            question7Intent.putExtra("sum5", sum5)
            startActivity(question7Intent)
        }

        binding.answerButton2.setOnClickListener{
            point6 = 2
            println("point6=$point6")
            sum5 = sum4 + point6
            question7Intent.putExtra("sum5", sum5)
            startActivity(question7Intent)
        }

        binding.answerButton3.setOnClickListener{
            point6 = 3
            println("point6=$point6")
            sum5 = sum4 + point6
            question7Intent.putExtra("sum5", sum5)
            startActivity(question7Intent)
        }
    }
}
