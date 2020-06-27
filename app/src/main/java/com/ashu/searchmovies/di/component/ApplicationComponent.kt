package com.ashu.searchmovies.di.component

import com.ashu.searchmovies.MovieApplication
import com.ashu.searchmovies.di.module.ActivityBuilder
import com.ashu.searchmovies.di.module.ApplicationModule
import com.ashu.searchmovies.di.module.FragmentModule
import com.ashu.searchmovies.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (NetworkModule::class),
        (ApplicationModule::class),
        (ActivityBuilder::class),
        (FragmentModule::class)]
)

interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MovieApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MovieApplication)
}
