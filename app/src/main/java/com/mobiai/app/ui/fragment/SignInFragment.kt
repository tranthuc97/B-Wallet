package com.mobiai.app.ui.fragment

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobiai.R
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentSignInBinding


class SignInFragment : BaseFragment<FragmentSignInBinding>(){

    var isChecked:Boolean = true

    companion object {
        fun instance() : SignInFragment{
            return newInstance(SignInFragment::class.java)
        }
    }

    override fun initView() {
        binding.tvSignIn.setOnClickListener {
            addFragment(InputOTPFragment.instance(binding.edtUserName.text.toString()))
        }

        binding.ivEye.setOnClickListener {
            if(isChecked){
                binding.edtPassWord.inputType = InputType.TYPE_CLASS_TEXT
                binding.ivEye.setImageResource(R.drawable.ic_eye_show)
                isChecked = false
            }else{
                binding.edtPassWord.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.ivEye.setImageResource(R.drawable.icon_eye_hide)
                isChecked = true
            }
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignInBinding = FragmentSignInBinding.inflate(layoutInflater, container, false)
}