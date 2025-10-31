package {{cookiecutter.package_name}}.ui.{{cookiecutter.fragment_two.split('.')[0]}}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import {{ cookiecutter.package_name }}.databinding.Fragment{{ cookiecutter.fragment_two.split('.')[1]}}Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class {{ cookiecutter.fragment_two.split('.')[1]}}Fragment : Fragment() {

    private var _binding: Fragment{{ cookiecutter.fragment_two.split('.')[1]}}Binding? = null
    private val binding get() = _binding!!
    private val homeViewModel: {{ cookiecutter.fragment_two.split('.')[1]}}ViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Fragment{{ cookiecutter.fragment_two.split('.')[1]}}Binding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}