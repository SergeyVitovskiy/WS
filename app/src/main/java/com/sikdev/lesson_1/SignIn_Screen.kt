package com.sikdev.lesson_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sign_in__screen.*

class SignIn_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in__screen)

    }

    // Регистрация
    fun onClickRegistration(view: View) {
        val name: String = eText_name.text.toString()
        val firstName: String = eText_firstName.text.toString()
        val mail = eText_mail.text.toString()
        val password = eText_password.text.toString()
        val passwordTuo = eText_passwordTuo.text.toString()
        // Проверка корректности полей
        if (name != "") {
            if (firstName != "") {
                if (mail != "") {
                    if (mailCheck(mail)) {
                        if (password != "") {
                            if (passwordTuo != "") {
                                if (password == passwordTuo) {
                                    // Регистрация пользователя
                                    // fsd
                                    Toast.makeText(this, "Регистрация", Toast.LENGTH_LONG)
                                } else {
                                    alertDialog("Пароли не совпадают")
                                }
                            } else
                                alertDialog("Заполните поле 'Повторите пароль'")
                        } else {
                            alertDialog("Заполните поле 'Пароль'")
                        }
                    } else {
                        alertDialog("Некорректный E-mail")
                    }
                } else {
                    alertDialog("Заполните полу 'E-mail'")
                }
            } else {
                alertDialog("Заполните поле 'Фамилия'")
            }
        } else {
            alertDialog("Заполните поле 'Имя'")
        }
    }

    // Возрат на форму авторизации
    fun onClickInput(view: View) {
        val intent = Intent(this, SingUp_Screen::class.java)
        startActivity(intent)
    }

    // Проверка почты
    fun mailCheck(mail: String): Boolean {
        val regExMail = Regex("[a-zA-Z_.]+@[a-zA-Z]+\\.[a-zA-Z]{0,3}")
        return regExMail.containsMatchIn(mail)
    }

    // Диалог с ошибкой
    fun alertDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Ошибка ввода")
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("Ок") { dialogInterface, i -> }
        alertDialogBuilder.show()
    }
}