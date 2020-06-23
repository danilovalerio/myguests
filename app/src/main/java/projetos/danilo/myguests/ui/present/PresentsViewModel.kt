package projetos.danilo.myguests.ui.present

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Presents Fragment"
    }
    val text: LiveData<String> = _text
}