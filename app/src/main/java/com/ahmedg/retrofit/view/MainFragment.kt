package com.ahmedg.retrofit.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import com.ahmedg.retrofit.R
import com.ahmedg.retrofit.data.ApiMovies
import com.ahmedg.retrofit.data.IApiMovies
import com.ahmedg.retrofit.model.ItemAdapter
import com.ahmedg.retrofit.model.MoviesPogoResult
import com.ahmedg.retrofit.model.Result
import kotlinx.android.synthetic.main.fragment_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    //    lateinit var adapter: ItemAdapter
    lateinit var result: List<Result>
    var moviesList = mutableListOf<Result>()
    lateinit var btnShow: Button
    lateinit var grView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        grView = view.gvMovies
        return view
    }

    override fun onStart() {
        super.onStart()
        val request = ApiMovies.movies.create(IApiMovies::class.java)
        val call = request.getMovies("837aa67b269303622a476bbe24283a57")
        call.enqueue(object : Callback<MoviesPogoResult> {
            override fun onResponse(
                call: Call<MoviesPogoResult>,
                response: Response<MoviesPogoResult>
            ) {
                if (response.isSuccessful) {
                    result = response.body()!!.results
                    val adapter = ItemAdapter(result)
                    grView.adapter = adapter
                    Log.i("TAG", "onResponse: ${response.body()!!.results}")
                }
            }

            override fun onFailure(call: Call<MoviesPogoResult>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.i("TAG", "onFailure: ${t.message}")

            }
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}