package elton.com.simplestacktest.feature

import elton.com.simplestacktest.BaseApplication
import elton.com.simplestacktest.di.component.DaggerNetComponent
import elton.com.simplestacktest.di.module.AppModule
import elton.com.simplestacktest.di.module.NetModule
import okhttp3.mockwebserver.MockWebServer

import android.support.annotation.NonNull
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins

import org.junit.BeforeClass
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

/**
 * Created by elton on 12/6/2018.
 *
 * Setup the Application for unit test.
 *
 * For test application components are created using mock instance.
 * Example is MockWebServer for Retrofit. The response can then be set for test case usage.
 **/
class TestBaseApplication: BaseApplication() {
    val mockWebServer = MockWebServer()

    companion object {
        /**
         * Method to setup schedulers for RxJava in test case usage.
         *
         * This should be called before the test case setup.
         */
        @BeforeClass
        fun setuUpRxSchedulers() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(@NonNull run: Runnable, delay: Long, @NonNull unit: TimeUnit): Disposable {
                    // this prevents StackOverflowErrors when scheduling with a delay
                    return super.scheduleDirect(run, 0, unit)
                }

                override fun createWorker(): Scheduler.Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
                }
            }

            RxJavaPlugins.setInitIoSchedulerHandler { _ -> immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { _ -> immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { _ -> immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { _ -> immediate }
//            RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> immediate }
        }
    }

    override fun createComponent() {
        mAppModule = AppModule(this)
        mNetModule = NetModule(mockWebServer.url("").toString())

        mNetComponent = DaggerNetComponent.builder()
                .appModule(mAppModule)
                .netModule(mNetModule)
                .build()
    }
}