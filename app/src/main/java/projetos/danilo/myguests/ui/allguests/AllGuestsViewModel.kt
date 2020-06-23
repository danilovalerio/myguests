package projetos.danilo.myguests.ui.allguests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllGuestsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All GuestsFragment"
    }
    val text: LiveData<String> = _text
}