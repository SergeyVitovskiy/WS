package com.sikdev.lesson_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sing_up__screen.*


class SingUp_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up__screen)
    }

    // Вход
    fun onClickInput(view: View) {
        val mail: String = eText_mail.text.toString()
        val password: String = eText_password.text.toString()
        // Проверки E-mail и пароля
        if (mail != "") {
            if (password != "") {
                if(emailCheck(mail))
                    Toast.makeText(this, "Вход", Toast.LENGTH_LONG).show()
                else
                    alertDialog("Некорректный E-mail")
            } else
                alertDialog("Заполните поле 'Пароль'")
        } else
            alertDialog("Заполните поле 'E-mail'")
    }
    // Авторизация
    fun onClickRegistration(view: View) {
        val intent = Intent(this, SignIn_Screen::class.java)
        startActivity(intent)
    }
    // Проверка почты
    private fun emailCheck(mail:String): Boolean {
        val regExMail = Regex("[a-zA-Z_.]+@[a-zA-Z]+\\.[a-zA-Z]{0,3}")
        return (regExMail.containsMatchIn(mail))
    }
    // Диалоговое окно с ошибкой
    private fun alertDialog(message: String) {
        val errorAlertDialog = AlertDialog.Builder(this)
        errorAlertDialog.setTitle("Ошибка ввода")
        errorAlertDialog.setMessage(message)
        errorAlertDialog.setPositiveButton("Ок") { dialogInterface, i -> }
        errorAlertDialog.show();
    }
}