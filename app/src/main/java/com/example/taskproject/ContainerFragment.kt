package com.example.taskproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskproject.adapter.PostAdapter
import com.example.taskproject.databinding.ActivityMainBinding
import com.example.taskproject.viewmodel.MainViewModel
import com.example.taskproject.viewmodel.MainViewModelFactory

class ContainerFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: PostAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_container, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.Recyclerview)
        val repository = (activity?.application as PostApplication).postRepository
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.posts.observe(viewLifecycleOwner, Observer {

            adapter = PostAdapter(it)
            recyclerView.adapter = adapter

            adapter.OnItemClick = {

                showPostDetails(it)
                adapter.notifyDataSetChanged()
            }
        })

        return view

    }

    private fun showPostDetails(postsItem: PostsItem) {
        val postDetailFragment = PostDetailedFragment().newInstance(postsItem)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, postDetailFragment)
            .addToBackStack(null)
            .commit()
    }

}

