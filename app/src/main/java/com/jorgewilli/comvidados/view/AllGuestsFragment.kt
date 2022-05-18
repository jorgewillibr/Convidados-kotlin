package com.jorgewilli.comvidados.view

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
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.databinding.FragmentAllBinding
import com.jorgewilli.comvidados.service.constants.GuestConstans
import com.jorgewilli.comvidados.service.model.GuestModel
import com.jorgewilli.comvidados.view.adapter.GuestAdapter
import com.jorgewilli.comvidados.view.listener.GuestListener
import com.jorgewilli.comvidados.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mViewModel: GuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, s: Bundle?
    ): View? {
        mViewModel =
            ViewModelProvider(this)[GuestsViewModel::class.java]

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // * Recycle
        // 1- Obter a recycler
        val recycle = root.findViewById<RecyclerView>(R.id.recycle_all_guests)

        // 2- Definir layout
        recycle.layoutManager = LinearLayoutManager(context)

        // 3- Definir um adpter
        recycle.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstans.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(guest: GuestModel) {
                mViewModel.delete(guest)
                mViewModel.load(GuestConstans.FILTER.EMPTY)
            }

        }
        mAdapter.attachListener(mListener)

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()

        //carrega Guest's
        mViewModel.load(GuestConstans.FILTER.EMPTY)
    }

    private fun observer() {
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}