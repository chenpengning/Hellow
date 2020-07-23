import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun <T> applyWidgetSchedulers(windowDuration: Long = 1L): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.throttleFirst(windowDuration, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applyWidgetSchedulersForMilliSeconds(windowDuration: Long = 1L): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.throttleFirst(windowDuration, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulers(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulersOnFlowable(): FlowableTransformer<T, T> {
    return FlowableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulersOnSingle(): SingleTransformer<T, T> {
    return SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
