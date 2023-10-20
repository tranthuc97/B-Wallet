package com.mobiai.app.ui.activity

import android.annotation.SuppressLint
import android.util.Log
import com.mobiai.R
import com.mobiai.base.basecode.ui.activity.BaseActivity
import com.mobiai.databinding.ActivitySplashBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun createView() {
        loadProgressBar()
    }

    @SuppressLint("CheckResult")
    private fun loadProgressBar() {
        val observable = Observable.create<Int> { emitter ->
            // Thực hiện công việc trong luồng riêng ở đây
            for (i in 0..1000){
                Thread.sleep(1)
                emitter.onNext(i)
            }
            emitter.onComplete()    //gọi khi kết thúc luồng riêng

        }

        observable.subscribeOn(Schedulers.io()) // Chạy trên luồng nền
            .observeOn(AndroidSchedulers.mainThread()) // Chạy trên luồng giao diện
            .subscribe(
                { result -> // onNext
                    binding.progressBarHorizontal.max = 1000
                    binding.progressBarHorizontal.progress = result
                },
                { error -> // onError
                    Log.i("TAG","lỗiiiiii")
                    // Xử lý lỗi ở đây
                },
                { // onComplete
                    SignInActivity.instance(this)
                }
            )
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_splash

    override fun getViewBinding(): ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
    }

