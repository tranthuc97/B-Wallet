package com.mobiai.app.ui.activity

import android.content.Context
import android.content.Intent
import com.mobiai.R
import com.mobiai.app.ui.fragment.SignInFragment
import com.mobiai.base.basecode.ui.activity.BaseActivity
import com.mobiai.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity<ActivitySignInBinding>() {

    companion object {
        fun instance(context:Context){
            Intent(context, SignInActivity::class.java).apply {
                putExtra("key", "some data")
                context.startActivity(this)
            }
        }
    }
    override fun getLayoutResourceId(): Int = R.layout.activity_sign_in

    override fun getViewBinding(): ActivitySignInBinding = ActivitySignInBinding.inflate(layoutInflater)

    override fun createView() {
        addFragment(SignInFragment.instance())
    }
}