package org.cardna.presentation.ui.login

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.cardna.R
import com.example.cardna.databinding.ActivitySetNameBinding
import org.cardna.presentation.base.BaseViewUtil

class SetNameActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySetNameBinding>(R.layout.activity_set_name) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
//        setClickListener()
        setChangedListener()
    }

    private fun setClickListener() {
//        signupCheckListener()
    }

    private fun setChangedListener() {
        editTextChanged(binding.etSignupFirstname)
        editTextChanged(binding.etSignupLastname)

        firstnameCountChanged()
    }

    private fun buttonColorChanged() {
        val isFirstnameCheck = binding.etSignupFirstname.text.isNullOrBlank()
        val isLastnameCheck = binding.etSignupLastname.text.isNullOrBlank()

        with(binding.btnSignUpNameAccess) {
            if (isFirstnameCheck || isLastnameCheck) {
                setBackgroundResource(R.drawable.bg_signup_white3_radius_10)
                setTextColor(getColor(R.color.white_2))
                isClickable = false
            } else {
                setBackgroundResource(R.drawable.bg_signup_gradient_green_purple_radius_10)
                setTextColor(getColor(R.color.main_black))
                isClickable = true
            }
        }
    }

    fun signupCheckListener(view: View) {
        initAlertDialog()
    }

    private fun initAlertDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.alert_signup)

        val title = dialog.findViewById<TextView>(R.id.tv_alert_title)
        val negativeButton = dialog.findViewById<Button>(R.id.btn_alert_negative)
        val positiveButton = dialog.findViewById<Button>(R.id.btn_alert_positive)
        val name = with(binding) { "${etSignupLastname.text}${etSignupFirstname.text}" }
        val firstname = binding.etSignupFirstname.text.toString()

        title.text = "${name}님이 맞으신가요?"

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        negativeClickListener(negativeButton, dialog)
        positiveClickListener(positiveButton, dialog, firstname)

        dialog.setCancelable(false)
        dialog.show()
    }

    private fun negativeClickListener(button: Button, dialog: Dialog) {
        button.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun positiveClickListener(button: Button, dialog: Dialog, name: String) {
        button.setOnClickListener {
            Toast.makeText(this, "카드 추가 작성뷰로 이동", Toast.LENGTH_SHORT).show()
        }
    }

    private fun editTextChanged(editText: EditText) {
        editText.addTextChangedListener {
            if (!editText.text.isNullOrEmpty()) {
                editText.background.setTint(getColor(R.color.white_1))
            } else {
                editText.background.setTint(getColor(R.color.white_4))
            }
            buttonColorChanged()
        }
    }

    private fun firstnameCountChanged() {
        with(binding) {
            etSignupFirstname.addTextChangedListener {
                firstnameCount = if (!it.isNullOrEmpty()) "${it.length}/10" else "0/10"
            }
        }
    }

}
