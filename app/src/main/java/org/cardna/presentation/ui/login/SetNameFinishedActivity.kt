package org.cardna.presentation.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.view.View
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.core.view.isVisible
import com.example.cardna.R
import com.example.cardna.databinding.ActivitySetNameFinishedBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.util.LinearGradientSpan

class SetNameFinishedActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySetNameFinishedBinding>(R.layout.activity_set_name_finished) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        setSleep()
        setClickListener()
        setTextView()
    }

    private fun setClickListener() {
        negativeButtonClickListener()
        positiveButtonClickListener()
    }

    private fun setTextView() {
        val welcomeText = intent.getStringExtra("welcomeText")

        with(binding) {
            tvSetnamefinishedTitle.text = setGradientText(welcomeText!!)
            tvSetnamefinishedMessage1.text = setGradientText("캬드를")
            tvSetnamefinishedMessage2.text = setGradientText("추가하러")
            tvSetnamefinishedMessage3.text = setGradientText("가볼까요?")
        }

    }

    private fun setGradientText(welcomeText: String): Spannable? {
        val green = getColor(R.color.main_green)
        val purple = getColor(R.color.main_purple)
        val spannable = welcomeText?.toSpannable()
        spannable?.set(
            0..welcomeText.length,
            LinearGradientSpan(welcomeText, welcomeText, green, purple)
        )
        return spannable
    }

    private fun setSleep() {

    }

    private fun negativeButtonClickListener() {
        //EmptyView -> 메인 페이지 이동
    }

    private fun positiveButtonClickListener() {
        //카드나 작성뷰로 이동
    }
}