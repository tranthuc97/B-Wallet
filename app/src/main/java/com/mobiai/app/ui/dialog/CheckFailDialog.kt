package com.mobiai.app.ui.dialog

import android.content.Context
import android.view.animation.AnimationUtils
import com.mobiai.base.basecode.ui.dialog.BaseDialog
import com.mobiai.databinding.DialogSetupPinFailBinding

class CheckFailDialog(context: Context) : BaseDialog<DialogSetupPinFailBinding>(context) {

    var callback : CallbackFail? = null
    override fun getViewBinding(): DialogSetupPinFailBinding? = DialogSetupPinFailBinding.inflate(layoutInflater)

    override fun initViews() {
        binding!!.vAnimX.startAnimation(AnimationUtils.loadAnimation(context,com.mobiai.R.anim.anim_spread_out))
        binding!!.tvOke.setOnClickListener {
            callback?.clickOk()
        }
    }

    interface CallbackFail{
        fun clickOk()
    }
}