package com.fly.fox.project.databus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlin.collections.Map.Entry

class LiveDataBus private constructor() {

    private var map = HashMap<String, LiveDataX<Any>>()

    @Synchronized
    fun <T> with(key: String, type: Class<T>): LiveDataX<T> {

        if (!map.containsKey(key)) {

            map[key] = LiveDataX()

        }

        return map[key] as LiveDataX<T>

    }

    companion object {

        val instance: LiveDataBus by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LiveDataBus()
        }
    }

}

class LiveDataX<T> : MutableLiveData<T>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)
        //hook 源码 解决数据粘性问题
        hook(observer)
    }


    private fun hook(observer: Observer<in T>) {
        /**s
         * SafeIterableMap<Observer<? super T>, ObserverWrapper> mObservers
         *considerNotify(ObserverWrapper observer)
         * observer.mLastVersion
         */

        //1、得到 mLastVersion

        val liveDataClass = LiveData::class.java
        val mObserversFile = liveDataClass.getDeclaredField("mObservers")
        mObserversFile.isAccessible = true
        //获得Map类的成员对象
        var mObserversObject = mObserversFile.get(this)
        mObserversFile.isAccessible = false
        //获得该Map类的成员class
        var mObserversClass = mObserversObject.javaClass
        //Map get 方法
        val methodGet = mObserversClass.getDeclaredMethod("get", Any::class.java)
        //map 中的Entry 对象
        methodGet.isAccessible = true
        var objectWrapperEntry = methodGet.invoke(mObserversObject, observer)
        methodGet.isAccessible = false

        var objectWrapper: Any? = null
        if (objectWrapperEntry != null && objectWrapperEntry is Entry<*, *>) {
            objectWrapper = objectWrapperEntry.value
        }

        if (objectWrapper == null) {
            throw  NullPointerException("Wrapper can not be bull!")
        }

        var classObserverWrapper: Class<in Any>? = objectWrapper.javaClass.superclass

        var mLastVersion = classObserverWrapper?.getDeclaredField("mLastVersion")

        //2、得到 mVersion
        val mVersion = liveDataClass.getDeclaredField("mVersion")
        mVersion.isAccessible = true
        var mVersionObject = mVersion.get(this)
        mVersion.isAccessible = false

        //3、mLastVersion == mVersion
        mLastVersion?.let {

            it.isAccessible = true
            it.set(objectWrapper, mVersionObject)
            it.isAccessible = false
        }

    }


}