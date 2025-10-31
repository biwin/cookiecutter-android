package {{ cookiecutter.package_name }}.data.util.resource

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map


inline fun <ResultType, RequestType> networkBoundResource(
    // query database
    crossinline query: () -> Flow<ResultType>,

    // fetch from the network resource
    crossinline fetch: suspend () -> RequestType,

    // saves the fetched resources to the database
    crossinline saveFetchResult: suspend (RequestType) -> Unit,

    // flags weather to fetch the resource
    crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {

    val data = query().first()

    val flow: Flow<Resource<ResultType>> = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            // save the result fetched from api
            saveFetchResult(fetch())
            // fetch from db
            query().map { Resource.Success(it) }
        } catch (t: Throwable) {
            // fetch from db with error
            Log.d("debug", "throwable $t : ");
            query().map { Resource.Error(t, it) }
        }
    } else {
        // fetch from db
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}