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
    }

    private fun setClickListener() {
        negativeButtonClickListener()
        positiveButtonClickListener()
    }

    private fun setTextView() {
        val welcomeText = intent.getStringExtra("welcomeText")
        val title = setGradientText(welcomeText!!)
        val message = setGradientText(binding.tvSetnamefinishedMessage.text.toString())
    }

    private fun setGradientText(welcomeText: String): Spannable? {
        val green = getColor(R.color.main_green)
        val purple = getColor(R.color.main_purple)
        val spannable = welcomeText?.toSpannable()
        spannable?.set(
            0..welcomeText.length,
            LinearGradientSpan(welcomeText, welcomeText, green, purple)
        )
        with(binding) {
            tvSetnamefinishedTitle.text = spannable
        }
        return spannable
    }

    private fun setSleep() {
        Thread.sleep(2000L)
    }

    private fun negativeButtonClickListener() {
        //EmptyView -> 메인 페이지 이동
    }

    private fun positiveButtonClickListener() {
        //카드나 작성뷰로 이동
    }
}