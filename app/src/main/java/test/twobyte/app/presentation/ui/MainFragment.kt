package test.twobyte.app.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import test.twobyte.app.databinding.MainFragmentBinding
import test.twobyte.app.presentation.ui.adapter.MyRecycleAdapter
import test.twobyte.app.presentation.viewmodel.MainViewModel
import test.twobyte.app.presentation.viewmodel.MainViewModelFactory

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModelFactory())
            .get(MainViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        val myRecycleAdapter = MyRecycleAdapter()
        binding.recycleView.layoutManager = LinearLayoutManager(context)

        viewModel.dataNewsApi.onEach {
            it?.let {
                myRecycleAdapter.setData(newsApi = it)
                binding.recycleView.adapter = myRecycleAdapter
            }
        }.launchIn(lifecycleScope)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}