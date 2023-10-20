package com.mobiai.app.ui.fragment.old

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mobiai.R
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentWebBinding

class WebFragment : BaseFragment<FragmentWebBinding>() {
    companion object {
        fun instance(): WebFragment {
            return newInstance(WebFragment::class.java)
        }
    }
    override fun initView() {
        val webView = view?.findViewById<WebView>(R.id.webView)
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("http://google.com/")

    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentWebBinding {
        return FragmentWebBinding.inflate(inflater, container, false)
    }
}