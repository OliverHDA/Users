package com.example.users.screens.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.users.data.repository.RemoteRepository
import com.example.users.databinding.FragmentAuthBinding
import com.example.users.model.Response
import com.example.users.model.User
import com.example.users.utils.ISchedulers
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class AuthFragment : MvpAppCompatFragment(), AuthView {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var remoteRepository: RemoteRepository

    @Inject
    lateinit var schedulers: ISchedulers

    private val presenter: AuthPresenter by moxyPresenter {
        AuthPresenter(router, remoteRepository, schedulers)
    }

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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun setUsers(users: List<User>) {
        val adapter = context?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_item, users.map { user ->
                user.user
            })
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.users.adapter = adapter
        binding.users.setSelection(0, false)
        if (users.isNotEmpty()) {
            presenter.setCurrentUser(users[0])
        }
        binding.users.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                presenter.setCurrentUser(users[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                if (users.isNotEmpty()) {
                    presenter.setCurrentUser(users[0])
                }
            }
        }
    }

    override fun signIn(response: Response) {
        if (response.code == null) {
            if (presenter.getCurrentUser() != null && response.authentication != null) {
                presenter.signIn(response.authentication)
            }
        } else {
            Toast.makeText(context, "Ошибка авторизации код: ${response.code}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    override fun initSignInButton(uid: String) {
        binding.signInButton.setOnClickListener {
            presenter.onSignInClick(uid, binding.passwordEditText.toString())
        }
    }

    companion object {
        fun newInstance() = AuthFragment()
    }
}