package projetos.danilo.myguests.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import projetos.danilo.myguests.R
import projetos.danilo.myguests.service.constants.GuestConstants
import projetos.danilo.myguests.view.adapter.GuestAdapter
import projetos.danilo.myguests.view.listener.GuestListener
import projetos.danilo.myguests.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var guestsViewModel: GuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        guestsViewModel =
                ViewModelProvider(this).get(GuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_allguests, container, false)

        //Configuração do recycler
        val recycler = root.findViewById<RecyclerView>(R.id.rv_allguests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {

                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST_ID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                guestsViewModel.delete(id)
                guestsViewModel.load()
            }
        }

        mAdapter.attachListener(mListener)

        setupObserve()

        guestsViewModel.load()

        return root
    }

    /**Quando o fragment recebe o foco novamente*/
    override fun onResume() {
        super.onResume()

        guestsViewModel.load()
    }

    private fun setupObserve() {
        guestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListGuest(it)
        })
    }
}
