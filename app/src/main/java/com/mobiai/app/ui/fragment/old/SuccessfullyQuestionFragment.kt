package com.mobiai.app.ui.fragment.old

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobiai.R
import com.mobiai.app.viewmodel.QuestionViewModel
import com.mobiai.base.basecode.ui.fragment.BaseFragment
import com.mobiai.databinding.FragmentSuccessfullyQuestionBinding


class SuccessfullyQuestionFragment : BaseFragment<FragmentSuccessfullyQuestionBinding>() {
    private val viewModel: QuestionViewModel by viewModels()
    override fun initView() {
        viewModel.getListQuestion()
        viewModel.listQuestion.observe(this){
            binding.textViewQuestion.text=it[0].question
            binding.textViewAnswer.text = it[0].answer
        }
        binding.buttonConfirm.setOnClickListener {
            val newFragment = NotesFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_successfully_question, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSuccessfullyQuestionBinding {
        binding = FragmentSuccessfullyQuestionBinding.inflate(inflater, container, false)
        return binding
    }

}