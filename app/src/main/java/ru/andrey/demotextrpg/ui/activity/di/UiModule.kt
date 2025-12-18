package ru.andrey.demotextrpg.ui.activity.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import ru.andrey.demotextrpg.ui.splash.viewmodel.SplashViewModel
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
class UiModule {

    @Provides
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindMyViewModel(networkSource: NetworkSource): ViewModel = SplashViewModel(networkSource)
}