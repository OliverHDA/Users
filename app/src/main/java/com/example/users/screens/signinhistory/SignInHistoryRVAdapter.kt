package com.example.users.screens.signinhistory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.users.databinding.ItemHistoryBinding
import com.example.users.model.Authentication

class SignInHistoryRVAdapter(private val data: List<Authentication>) :
    RecyclerView.Adapter<SignInHistoryRVAdapter.SignInHistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignInHistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SignInHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SignInHistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class SignInHistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(authentication: Authentication) {
            with(binding) {
                response.text = authentication.response.toString()
                continueWork.text = authentication.continueWork.toString()
                photoHash.text = authentication.photoHash
                currentDate.text = authentication.currentDate
            }
        }
    }
}