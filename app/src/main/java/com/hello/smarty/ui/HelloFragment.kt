package com.hello.smarty.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hello.smarty.HelloViewModel
import com.hello.smarty.R
import kotlinx.android.synthetic.main.fragment_hello.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HelloFragment : Fragment(R.layout.fragment_hello) {

    private lateinit var helloViewModel: HelloViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helloViewModel = ViewModelProvider(this).get(HelloViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            helloViewModel.message.collect {
                helloMessage.text = it
            }
        }

        helloGetMessage.setOnClickListener {
            helloViewModel.sendName(helloInputName.text.trim().toString())
        }
    }
}