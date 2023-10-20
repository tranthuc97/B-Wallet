package com.mobiai.app.ui.fragment.old

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobiai.R
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentWarningBinding


class WarningFragment : BaseFragment<FragmentWarningBinding>() {
    companion object {
        fun instance(): WarningFragment {
            return newInstance(WarningFragment::class.java)
        }
    }
    override fun initView() {
        binding.buttonConfirm.setOnClickListener {
            val newFragment = AddFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_warning, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWarningBinding {
        binding = FragmentWarningBinding.inflate(inflater, container, false)
        return binding
    }

}