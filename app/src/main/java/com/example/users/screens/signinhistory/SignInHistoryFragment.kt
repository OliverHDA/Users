package com.example.users.screens.signinhistory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.users.data.repository.LocalRepository
import com.example.users.databinding.FragmentSignInHistoryBinding
import com.example.users.model.Authentication
import com.example.users.utils.ISchedulers
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class SignInHistoryFragment : MvpAppCompatFragment(), SignInHistoryView {

    @Inject
    lateinit var schedulers: ISchedulers

    @Inject
    lateinit var repository: LocalRepository

    private val newAuthentication by lazy {
        arguments?.get(AUTH_ARG) as Authentication
    }

    private val user by lazy {
        arguments?.getString(USER_ARG)
    }

    private val uid by lazy {
        arguments?.getString(UID_ARG).orEmpty()
    }

    private lateinit var historyAdapter: SignInHistoryRVAdapter

    private var _binding: FragmentSignInHistoryBinding? = null
    private val binding: FragmentSignInHistoryBinding
        get() = _binding!!

    private val presenter: SignInHistoryPresenter by moxyPresenter {
        SignInHistoryPresenter(schedulers, repository, uid, newAuthentication)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun show(list: List<Authentication>) {
        binding.userTitle.text = user
        historyAdapter = SignInHistoryRVAdapter(list).also {
            binding.historyRecyclerView.adapter = it
        }
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(user: String, uid: String, authentication: Authentication) =
            SignInHistoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AUTH_ARG, authentication)
                    putString(USER_ARG, user)
                    putString(UID_ARG, uid)
                }
            }

        private const val AUTH_ARG = "authentication"
        private const val USER_ARG = "user"
        private const val UID_ARG = "uid"
    }
}