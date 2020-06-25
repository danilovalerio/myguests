package projetos.danilo.myguests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import projetos.danilo.myguests.R
import projetos.danilo.myguests.viewmodel.GuestsViewModel

class PresentsFragment : Fragment() {

    private lateinit var guestsViewModel: GuestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guestsViewModel =
            ViewModelProvider(this).get(GuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_presents, container, false)

        return root
    }
}
