package com.neppplus.intent_nepp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnReturnToMain.setOnClickListener {

//            돌아가는 경우에는 Intent 활용 X
//            val myIntentToMain = Intent(this, MainActivity::class.java)
//            startActivity(myIntentToMain)

            finish()

        }
    }
}