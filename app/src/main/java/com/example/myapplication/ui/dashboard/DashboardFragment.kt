package com.example.myapplication.ui.dashboard

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MarsPhotosApplication
import com.example.myapplication.databinding.FragmentDashboardBinding
import java.net.HttpURLConnection
import java.net.URL


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val application = activity?.application as MarsPhotosApplication
        val marsPhotosRepository = application.container.marsPhotosRepository

        val dashboardViewModel = DashboardViewModel(marsPhotosRepository = marsPhotosRepository)
        processData(dashboardViewModel.marsUiState)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun processData(marsUiState: MarsUiState) {
        val recyclerView: RecyclerView = binding.recyclerView
        when (marsUiState) {
            is MarsUiState.Loading -> {}
            is MarsUiState.Success -> {
                val customAdapter = CustomAdapter(marsUiState.photos)
                recyclerView.layoutManager = LinearLayoutManager(context);
                recyclerView.adapter = customAdapter
            }

            is MarsUiState.Error -> {}
        }
    }
}