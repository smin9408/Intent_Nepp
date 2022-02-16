package com.neppplus.intent_nepp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnSave.setOnClickListener {

//            입력된 닉네임을 변수에 저장.
            val inputNickname = edtNickname.text.toString()

//            복귀시 데이터를 들고 갈 Intent를 생성.
            val resultIntent = Intent() // 결과를 담기 위한 용도로만. 출발지 / 도착시 명시하지 않음

//            Intent에 데이터 담기 -> putExtra 활용
            resultIntent.putExtra("nick", inputNickname)

//            실제 복귀 결과로 세팅.
//            확인을 눌렀다 + 들고 돌아갈 데이터
            setResult(RESULT_OK, resultIntent)
            finish()


        }
    }
}