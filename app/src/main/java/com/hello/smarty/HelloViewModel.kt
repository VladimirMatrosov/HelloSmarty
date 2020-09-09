package com.hello.smarty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HelloViewModel : ViewModel() {

    private val messageChannel = BroadcastChannel<String>(Channel.CONFLATED)
    val message
        get() = messageChannel.asFlow()

    fun sendName(name: String) {
        viewModelScope.launch {
            messageChannel.offer(NetworkService.getHelloMessage(name))
        }
    }
}