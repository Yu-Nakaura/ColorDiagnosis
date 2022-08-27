package app.nakaura.chloe.colordiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.colordiagnosis.databinding.ActivityEndBinding
import app.nakaura.chloe.colordiagnosis.databinding.ActivityMainBinding

class EndActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEndBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEndBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val resultIntent: Intent = Intent (this, ResultActivity::class.java)
        resultIntent.getIntExtra("total", 0)
        val total = intent.getIntExtra("total", 0)
        println(total)

        binding.resultButton.setOnClickListener {
            resultIntent.putExtra("total", total)
            startActivity(resultIntent)
        }
    }
}
