package com.example.users.screens.visit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.users.databinding.FragmentVisitHistoryBinding
import com.example.users.model.Authentication

class VisitHistoryFragment : Fragment() {

    private var _binding: FragmentVisitHistoryBinding? = null
    private val binding: FragmentVisitHistoryBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVisitHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(user: String, authentication: Authentication) =
            VisitHistoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AUTH_ARG, authentication)
                    putString(USER_ARG, user)
                }
            }

        private const val AUTH_ARG = "authentication"
        private const val USER_ARG = "user"
    }
}