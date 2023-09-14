package com.mobiai.app

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

class MyTextWatcher(private val textView: TextView) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        val text = s.toString()
        if (isNumeric(text)) {
            // Nếu nội dung là số, đặt màu văn bản thành màu trắng
            textView.setTextColor(Color.WHITE)
        } else if (containsMathOperators(text)) {
            // Nếu nội dung chứa dấu phép tính, đặt màu văn bản thành màu xanh
            textView.setTextColor(Color.BLUE)
        } else {
            // Nếu không phải số và không chứa dấu phép tính, có thể đặt màu theo mặc định ở đây
            textView.setTextColor(Color.BLACK)
        }
    }

    private fun isNumeric(text: String): Boolean {
        // Kiểm tra xem chuỗi có phải là số hay không
        return text.matches(Regex("-?\\d+(\\.\\d+)?"))
    }

    private fun containsMathOperators(text: String): Boolean {
        // Kiểm tra xem chuỗi có chứa dấu phép tính hay không (ví dụ: +, -, *, /)
        return text.contains(Regex("[+\\-*/]"))
    }
}
