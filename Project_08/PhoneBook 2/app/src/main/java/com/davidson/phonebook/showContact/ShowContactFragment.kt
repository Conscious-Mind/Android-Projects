package com.davidson.phonebook.showContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davidson.phonebook.ContactDatabase
import com.davidson.phonebook.ContactItemAdapter
import com.davidson.phonebook.R
import com.davidson.phonebook.databinding.FragmentShowContactBinding

class ShowContactFragment : Fragment() {
    private var _binding: FragmentShowContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowContactBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = ContactDatabase.getInstance(application).contactDao
        val viewModelFactory = ShowContactViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ShowContactViewModel::class.java)

        binding.showConViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ContactItemAdapter()
        binding.contactsList.adapter = adapter

        viewModel.contacts.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener { addContacts() }
        binding.clearButton.setOnClickListener { binding.showConViewModel?.clearDB() }
    }

    private fun addContacts() {
        findNavController().navigate(R.id.action_showContactFragment_to_addContactFragment)
    }
}