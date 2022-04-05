package com.example.sharedviewmodelforfragmentcommunication

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.sharedviewmodelforfragmentcommunication.databinding.FragmentABinding

class fragmentA : Fragment(){

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    private var viewModel:SharedViewModel? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentABinding.inflate(layoutInflater,container,false)
        val view = binding.root

        binding.btnSend.setOnClickListener{
            viewModel!!.setText(binding.etName.text.toString())
        }


        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        viewModel!!.getText().observe(viewLifecycleOwner , Observer {

            Log.d("Fragment A","$it")
            binding.etName.setText(it)  // this way you can  set text to editText android
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}