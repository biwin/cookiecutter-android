package {{cookiecutter.package_name}}.ui.{{cookiecutter.fragment_one.split('.')[0]}}

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class {{cookiecutter.fragment_one.split('.')[1]}}ViewModel @Inject constructor() : ViewModel() {

}