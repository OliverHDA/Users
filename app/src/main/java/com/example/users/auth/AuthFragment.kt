package com.example.users.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.users.databinding.FragmentAuthBinding
import com.example.users.model.User
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class AuthFragment : MvpAppCompatFragment(), AuthView {

    @Inject
    lateinit var router: Router

    private val presenter: AuthPresenter by moxyPresenter {
        AuthPresenter(router)
    }

    private var selectedUser: User? = null

    private var _binding: FragmentAuthBinding? = null
    private val binding: FragmentAuthBinding
        get() = _binding!!

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedUser = User("user", "uid", "")
        binding.signInButton.setOnClickListener {
            selectedUser?.let {
                presenter.signIn(it)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun setUsers(users: List<User>) {
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = AuthFragment()
    }
}