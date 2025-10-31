package {{cookiecutter.package_name}}.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class {{ cookiecutter.app_name }}Application: Application() {

}