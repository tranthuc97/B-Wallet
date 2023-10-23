package com.mobiai.app.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mobiai.R
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentInputOtpBinding


class InputOTPFragment : BaseFragment<FragmentInputOtpBinding>(){

    companion object {
        val PHONE_NUMBER = "PHONE_NUMBER"
        lateinit var phone:String
        fun instance(phoneNumber:String) : InputOTPFragment{
            Bundle().apply {
                putString(PHONE_NUMBER, phoneNumber)
                return newInstance(InputOTPFragment::class.java, this)
            }

        }
    }

    override fun initView() {
        getData()
        focusOTPEditText()

        binding.ivBack.setOnClickListener {
            addAnimation(binding.ivBack)
            closeFragment(this)
        }
    }

    private fun showToastAlert(){
        val layout = layoutInflater.inflate(R.layout.item_custom_toast_alert_otp, requireActivity().findViewById(R.id.lnAlertToast))
        val toast = Toast(requireContext())
        toast.view = layout
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    private fun focusOTPEditText() {
        binding.edtOTP1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //do no thing
            }

            override fun afterTextChanged(s: Editable?) {
                if(s?.isNotEmpty() == true){
                    binding.edtOTP2.requestFocus()
                }
            }
        })

        binding.edtOTP2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //do no thing
            }

            override fun afterTextChanged(s: Editable?) {
                if(s?.isNotEmpty() == true){
                    binding.edtOTP3.requestFocus()
                }
            }
        })

        binding.edtOTP3.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //do no thing
            }

            override fun afterTextChanged(s: Editable?) {
                if(s?.isNotEmpty() == true){
                    binding.edtOTP4.requestFocus()
                }
            }
        })
    }

    private fun getData() {
        arguments.let {
            phone = it?.getString(PHONE_NUMBER)!!
        }
        binding.tvPhoneNumber.text = phone
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInputOtpBinding = FragmentInputOtpBinding.inflate(layoutInflater, container, false)
}