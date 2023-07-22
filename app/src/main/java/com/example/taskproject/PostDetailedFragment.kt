package com.example.taskproject

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class PostDetailedFragment : Fragment() {
private lateinit var postsItem: PostsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the Post object passed as arguments
        postsItem = arguments?.getParcelable(ARG_POSTITEM) ?: throw IllegalArgumentException("Post argument not found")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post_detailed, container, false)

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val bodyTextView: TextView = view.findViewById(R.id.bodyTextView)

        titleTextView.text = postsItem.title
        bodyTextView.text = postsItem.body

        return view
    }

//    companion object {
        private val ARG_POSTITEM = "postItem"

        fun newInstance(postsItem: PostsItem): PostDetailedFragment {
            val fragment = PostDetailedFragment()
            val args = Bundle()
            args.putParcelable(ARG_POSTITEM,postsItem)
            fragment.arguments = args
            return fragment
        }
    }
