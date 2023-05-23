package griffin.appdev.calculatorForAppStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var settingChanged = false;
        val btnReturn = findViewById<Button>(R.id.btnReturn);
        val btnPrimary = findViewById<Button>(R.id.btnPrimary);

        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            intent.putExtra("STRING_NAME", settingChanged);
            startActivity(intent);

        }

        btnPrimary.setOnClickListener {
            settingChanged = true;
        }




    }


}
