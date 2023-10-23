package com.mobiai.app.ui.dialog

import android.content.Context
import android.view.animation.AnimationUtils
import com.mobiai.base.basecode.ui.dialog.BaseDialog
import com.mobiai.databinding.DialogSetupPinTrueBinding

class CheckTrueDialog(context: Context) : BaseDialog<DialogSetupPinTrueBinding>(context) {

    var callback : CallbackTrue? = null
    override fun getViewBinding(): DialogSetupPinTrueBinding? = DialogSetupPinTrueBinding.inflate(layoutInflater)

    override fun initViews() {
        binding!!.vAnimTick.startAnimation(AnimationUtils.loadAnimation(context,com.mobiai.R.anim.anim_spread_out))
        binding!!.tvContinue.setOnClickListener {
            callback?.clickContinue()
        }
    }

    interface CallbackTrue{
        fun clickContinue()
    }
}