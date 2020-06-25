package projetos.danilo.myguests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import projetos.danilo.myguests.R
import projetos.danilo.myguests.view.adapter.GuestAdapter
import projetos.danilo.myguests.view.listener.GuestListener
import projetos.danilo.myguests.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel =
                ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_allguests, container, false)

        //Configuração do recycler
        val recycler = root.findViewById<RecyclerView>(R.id.rv_allguests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {

            }

        }

        mAdapter.attachListener(mListener)

        setupObserve()

        allGuestsViewModel.load()

        return root
    }

    /**Quando o fragment recebe o foco novamente*/
    override fun onResume() {
        super.onResume()

        allGuestsViewModel.load()
    }

    private fun setupObserve() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListGuest(it)
        })
    }
}
