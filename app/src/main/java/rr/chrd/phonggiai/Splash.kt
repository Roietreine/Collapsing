package rr.chrd.phonggiai

import android.content.Intent
import android.os.Bundle
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity

class Splash : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        splashAction(false, 1) { _, _ ->
            startActivity(Intent(application, MainActivity::class.java))
        }
    }
}