package com.mega.kotlinapp.postAPIKotlin.postapimvp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mega.kotlinapp.databinding.FragmentHomeBinding

import com.mega.kotlinapp.postAPIKotlin.postapimvp.network.API
import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.StoreListModel
import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.Stores
import com.mega.kotlinapp.postAPIKotlin.postapimvp.presenter.ReqAndRes
import com.mega.kotlinapp.postAPIKotlin.postapimvp.view.adapter.StoreAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {


    lateinit var androidId: String
    lateinit var binding: FragmentHomeBinding
    var postBody : PostBodyModel = PostBodyModel()

    @SuppressLint("HardwareIds")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(inflater,container,false)


        binding.recview.layoutManager = LinearLayoutManager(context)


        postBody.stores="All"

        androidId = Settings.Secure.getString(
            requireContext().contentResolver,
            Settings.Secure.ANDROID_ID
        )


        postBody()

        return binding.root
    }

    private fun postBody() {

        val api= API()
        val pathAndQuery: ReqAndRes? = api.postBody(androidId)?.let {
            it.create(ReqAndRes::class.java)
        }
        val call: Call<StoreListModel>? = pathAndQuery?.let {
            it.postData(37907, postBody)
        }
        call?.let { it.enqueue(object : Callback<StoreListModel> {
            override fun onResponse(
                call: Call<StoreListModel>,
                response: Response<StoreListModel>
            ) {
                Log.v("Check", "Code Checking" + response.code() + response.body())
                if (response.isSuccessful) {
                    val storeListModel = response.body()

                    val storeList: ArrayList<Stores>? = storeListModel?.let {
                        it.stores
                    }
                    val adapter = context?.let { it1 -> StoreAdapter(it1, storeList) }
                    binding.recview.adapter = adapter
                } else {
                    when (response.code()) {
                        400 -> {
                            Toast.makeText(
                                context,
                                "Server returned error: User not found",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.v("400", "Server returned error: User not found")
                        }
                        401 -> {
                            Toast.makeText(
                                context,
                                "Server returned error: Require user authentication",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.v("401", "Server returned error: Require user authentication")
                        }
                        404 -> {
                            Log.v(
                                "404",
                                "Server returned error:Server cannot find requested resource"
                            )
                            Toast.makeText(
                                context,
                                "Server cannot find requested resource",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        500 -> {
                            Log.v("500", "Server returned error: Server is broken")
                            Toast.makeText(
                                context,
                                "Server returned error: Server is broken",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> Log.v("default", "Server returned error: There might be some issue")
                    }
                }
            }

            override fun onFailure(call: Call<StoreListModel>, t: Throwable) {
                Log.v("Failure", "something went wrong$t")
                Toast.makeText(
                    context,
                    "Hi something went wrong$t",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        }
    }


}