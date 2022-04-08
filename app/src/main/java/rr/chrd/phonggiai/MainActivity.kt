package rr.chrd.phonggiai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var bckExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (bckExit) {
            super.finishAffinity()
            return
        }
        this.bckExit = true
        Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ bckExit = false }, 2000)
    }
}