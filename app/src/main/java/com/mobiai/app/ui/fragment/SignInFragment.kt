package com.mobiai.app.ui.fragment

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mobiai.R
import com.mobiai.app.ui.dialog.CheckFailDialog
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
            addAnimation(binding.tvSignIn)
            if(binding.edtUserName.text.toString().isEmpty() || binding.edtPassWord.text.toString().isEmpty()){
                Toast.makeText(requireContext(), getString(R.string.txt_don_t_leave_your_account_or_password_blank), Toast.LENGTH_SHORT).show()
            } else {
                addFragment(InputOTPFragment.instance(binding.edtUserName.text.toString()))
            }
        }

        binding.ivEye.setOnClickListener {
            addAnimation(binding.ivEye)
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

        binding.tvSignUp.setOnClickListener {
            addAnimation(binding.tvSignIn)
            replaceFragment(SignUpFragment.instance())
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignInBinding = FragmentSignInBinding.inflate(layoutInflater, container, false)
}