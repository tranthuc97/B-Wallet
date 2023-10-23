package com.mobiai.app.ui.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobiai.R
import com.mobiai.app.ui.dialog.CheckFailDialog
import com.mobiai.app.ui.dialog.CheckTrueDialog
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentSetupPinBinding

class SetupPinFragment : BaseFragment<FragmentSetupPinBinding>() {

    var pin = ""

    companion object {
        fun instance() : SetupPinFragment{
            return newInstance(SetupPinFragment::class.java)
        }
    }
    override fun initView() {
        clickNumber()
    }

    private fun clickNumber() {
        binding.tv1.setOnClickListener {
            addAnimation(binding.tv1)
            pin += binding.tv1.tag.toString()
            changeDotRate()
        }

        binding.tv2.setOnClickListener {
            addAnimation(binding.tv2)
            pin += binding.tv2.tag.toString()
            changeDotRate()
        }

        binding.tv3.setOnClickListener {
            addAnimation(binding.tv3)
            pin += binding.tv3.tag.toString()
            changeDotRate()
        }

        binding.tv4.setOnClickListener {
            pin += binding.tv4.tag.toString()
            changeDotRate()
        }

        binding.tv5.setOnClickListener {
            pin += binding.tv5.tag.toString()
            changeDotRate()
        }

        binding.tv6.setOnClickListener {
            pin += binding.tv6.tag.toString()
            changeDotRate()
        }

        binding.tv7.setOnClickListener {
            pin += binding.tv7.tag.toString()
            changeDotRate()
        }

        binding.tv8.setOnClickListener {
            pin += binding.tv8.tag.toString()
            changeDotRate()
        }

        binding.tv9.setOnClickListener {
            pin += binding.tv9.tag.toString()
            changeDotRate()
        }

        binding.tv0.setOnClickListener {
            pin += binding.tv0.tag.toString()
            changeDotRate()
        }

        binding.tvClear.setOnClickListener {
            pin = pin.removeCharAtIndex(pin.length - 1)
            changeDotRate()
        }
    }

    private fun changeDotRate() {
        if(pin.isEmpty()){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }


        if(pin.length == 1){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }

        if(pin.length == 2){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }

        if(pin.length == 3){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }

        if(pin.length == 4){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_purple)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }

        if(pin.length == 5){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_purple)
        }

        if(pin.length == 6){
            binding.ivDot1.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot2.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot3.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot4.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot5.setImageResource(R.drawable.ic_dot_white)
            binding.ivDot6.setImageResource(R.drawable.ic_dot_white)
            var dialogCheck = CheckTrueDialog(requireContext())
            dialogCheck.callback = object : CheckTrueDialog.CallbackTrue{
                override fun clickContinue() {
                    dialogCheck.dismiss()
                }
            }
            dialogCheck.show()

        }

        pin = pin.limitTo(6)    //pin litmit = 6
        Log.i("TAG","mã pin nhập: $pin")
    }

    fun String.removeCharAtIndex(index: Int): String {
        //xóa kí tự ở vị trí thứ
        if (index < 0 || index >= this.length) {
            return this
        }
        val stringBuilder = StringBuilder(this)
        stringBuilder.deleteCharAt(index)
        return stringBuilder.toString()
    }

    fun String.limitTo(maxLength: Int): String {
        //giới hạn độ dài của chuỗi
        return if (this.length > maxLength) {
            this.substring(0, maxLength)
        } else {
            this
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSetupPinBinding = FragmentSetupPinBinding.inflate(inflater, container, false)
}