package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion3Binding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityQuestion4Binding

class QuestionActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion4Binding
    var point4: Int = 0
    var sum3: Int = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityQuestion4Binding.inflate(layoutInflater).apply { setContentView(this.root) }
            val question5Intent: Intent = Intent (this, QuestionActivity5::class.java)
            question5Intent.getIntExtra("sum2",0)
            val sum2 =intent.getIntExtra("sum2", 0)
            println(sum2)


            binding.answerButton1.setOnClickListener{
                point4 = 1
                println("point4=$point4")
                sum3 = sum2 + point4
                question5Intent.putExtra("sum3",sum3)
                startActivity(question5Intent)
            }

            binding.answerButton2.setOnClickListener{
                point4 = 2
                println("point4=$point4")
                sum3 = sum2 + point4
                question5Intent.putExtra("sum3",sum3)
                startActivity(question5Intent)
            }

            binding.answerButton3.setOnClickListener{
                point4 = 3
                println("point4=$point4")
                sum3 = sum2 + point4
                question5Intent.putExtra("sum3",sum3)
                startActivity(question5Intent)
            }
        }
    }

