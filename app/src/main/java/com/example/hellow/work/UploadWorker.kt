package com.example.hellow.work

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {




    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.
        //uploadImages()



        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }



//    val uploadWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
//        .build()

    //orkManager.getInstance(myContext).enqueue(uploadWorkRequest)


}