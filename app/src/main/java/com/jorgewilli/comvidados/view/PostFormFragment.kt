package com.jorgewilli.comvidados.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.databinding.PostFormFragmentBinding
import com.jorgewilli.comvidados.view.adapter.PostAdapter
import com.jorgewilli.comvidados.viewmodel.PostFormViewModel

class PostFormFragment : Fragment() {

    private var _binding: PostFormFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mViewModel: PostFormViewModel
    private val mAdapter: PostAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, s: Bundle?
    ): View? {
        mViewModel =
            ViewModelProvider(this)[PostFormViewModel::class.java]

        _binding = PostFormFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // * Recycle
        // 1- Obter a recycler
        val recycle = root.findViewById<RecyclerView>(R.id.recycle_posts)

        // 2- Definir layout
        recycle.layoutManager = LinearLayoutManager(context)

        // 3- Definir um adpter
        recycle.adapter = mAdapter

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()

        //carrega Post's
        mViewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        mViewModel.posttList.observe(viewLifecycleOwner, Observer {
            mAdapter.updatePost(it)
        })
    }

}