package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion6Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion7Binding

class QuestionActivity7 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion7Binding
    var point7: Int = 0
    var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestion7Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        val endIntent: Intent = Intent (this, EndActivity::class.java)
        endIntent.getIntExtra("sum5", 0)
        val sum5 = intent.getIntExtra("sum5", 0)
        println(sum5)

        binding.answerButton1.setOnClickListener{
            point7 = 1
            println("point7=$point7")
            total = sum5 + point7
            endIntent.putExtra("total", total)
            startActivity(endIntent)
        }

        binding.answerButton2.setOnClickListener{
            point7 = 2
            println("point7=$point7")
            total = sum5 + point7
            endIntent.putExtra("total", total)
            startActivity(endIntent)
        }

        binding.answerButton3.setOnClickListener{
            point7 = 3
            println("point7=$point7")
            total = sum5 + point7
            endIntent.putExtra("total", total)
            startActivity(endIntent)
        }
    }
}