package {{ cookiecutter.package_name }}.data.util.resource


sealed class Resource<T>(val data: T?, val error: Throwable ?= null){

    class Idle<T>() : Resource<T>(null)

    class Success<T>(data: T) : Resource<T>(data)

    class Loading<T>(data: T ?= null): Resource<T>(data)

    class Error<T>(error: Throwable, data: T ?= null) : Resource<T>(data, error)

}