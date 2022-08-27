package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val questionIntent: Intent = Intent (this, QuestionActivity::class.java)
        binding.startButton.setOnClickListener {
            startActivity(questionIntent)
        }
    }
}