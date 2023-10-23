package com.mobiai.app.ui.fragment

import android.app.DatePickerDialog
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mobiai.R
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentSignUpBinding
import java.util.Calendar

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {

    var isChecked:Boolean = true
    companion object {
        fun instance() : SignUpFragment{
            return newInstance(SignUpFragment::class.java)
        }
    }
    override fun initView() {
        binding.edtCalendar.setOnClickListener {
            addAnimation(binding.tvSignIn)
            showDatePickerDialog()
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

        binding.tvSignIn.setOnClickListener {
            addAnimation(binding.tvSignIn)
            replaceFragment(SignInFragment.instance())
        }

        binding.tvSignUp.setOnClickListener {
            addAnimation(binding.tvSignUp)
            if(binding.edtEmailAddress.text.toString().isEmpty() || binding.edtPassWord.text.toString().isEmpty()
                || binding.edtPhoneNumber.text.toString().isEmpty() || binding.edtUserName.text.toString().isEmpty()
                || binding.edtCalendar.text.toString().isEmpty()){
                Toast.makeText(requireContext(), getString(R.string.txt_don_t_blank), Toast.LENGTH_SHORT).show()
            } else {
                addFragment(SetupPinFragment.instance())
            }
        }
    }

    fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                binding.edtCalendar.setText(selectedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
}