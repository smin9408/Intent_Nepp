package com.neppplus.intent_nepp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    모든 함수에서 공유할 수 있는 변수. ( 멤버변수 or 전역변수 )
    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOtherActivity.setOnClickListener {

//            OtherActivity 로 이동
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)

        }

        btnSendMessage.setOnClickListener {

//            1. 뭐라고 입력했는지 추출
            val inputMessage = edtMessage.text.toString()

//            2. 추출한 내용을 다른 화면에 전달 (화면 이동 포함)

            val myIntent = Intent(this, ViewMessageActivity::class.java)

//            myIntent에, 입력한 내용을 첨부.
            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            새로운 닉네임을 받아내러 (결과를 얻으러) 가는 동작.
            startActivityForResult(myIntent, REQ_CODE_NICKNAME) // 숫자값으로, 닉네임을 받으러 간다고 구별하는데 사용.

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤 결과든, 결과를 받아 돌아올때 실행.
//        ex) 닉네임을 받아와도, 핸드폰 번호를 받아와도 모두 이 코드가 실행됨.

//        닉네임을 받아와서 실행된게 맞는지?
        if( requestCode == REQ_CODE_NICKNAME){

//            확인 버튼 누른게 맞는지?
            if(resultCode == RESULT_OK){

                Toast.makeText(this,"닉네임 변경에서 OK 누름.", Toast.LENGTH_SHORT).show()

//                닉네임 -> 받아왔을때, 받아온 닉네임 추출
//                data : resultIntent가 담겨 있다.
                val newNickname = data?.getStringExtra("nick")
                txtNickname.text = newNickname
            }
        }

    }
}