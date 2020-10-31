package com.android.youtubesearch.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.youtubesearch.R
import com.android.youtubesearch.adapters.YoutubeSearchAdapter
import com.android.youtubesearch.models.ResponseModel
import com.android.youtubesearch.models.VideoModel
import com.android.youtubesearch.network.APIClient
import com.android.youtubesearch.network.APIClient.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home){

    private lateinit var mConstraintLayoutHome: ConstraintLayout
    private lateinit var mRecyclerViewHome: RecyclerView

    private lateinit var mYoutubeSearchAdapter: YoutubeSearchAdapter
    private var mVideoModelList: ArrayList<VideoModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mConstraintLayoutHome = view.findViewById(R.id.constraintLayoutHome)
        mRecyclerViewHome = view.findViewById(R.id.recyclerViewHome)

        //setHasOptionsMenu(true)
        getSearchResult()
    }

    fun getSearchResult(){
        context?.let {
            APIClient.instance.searchVideo(
                API_KEY,
                "Salman"
            ).enqueue(object : Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {

                    if (response.isSuccessful) {
                        val mResponseModel: ResponseModel? = response.body()
                        if (mResponseModel != null) {

                            mVideoModelList.addAll(mResponseModel.items)
                            mYoutubeSearchAdapter = YoutubeSearchAdapter(
                                it,
                                mVideoModelList
                            )

                            mRecyclerViewHome.adapter = mYoutubeSearchAdapter

                        } else {
                            Toast.makeText(it, "No Data Found", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Toast.makeText(it, "Please Check network connection", Toast.LENGTH_SHORT)
                        .show()
                }

            })


        }

    }


/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.action_menu, menu)

        val mMenuItem : MenuItem = menu.findItem(R.id.action_search)

        val mSearchView : androidx.appcompat.widget.SearchView = mMenuItem.actionView as androidx.appcompat.widget.SearchView
        mSearchView.queryHint = "Search Youtube Videos"

        mSearchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { getSearchResult(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mSearchWord = newText.toString()

                getSearchResult(mSearchWord)

                return true
            }

        })
    }
*/
}