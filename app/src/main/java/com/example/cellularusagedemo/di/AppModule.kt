package com.example.cellularusagedemo.di

import android.content.Context
import com.example.cellularusagedemo.data.datastore.ThemePreference
import com.example.cellularusagedemo.data.repository.UsageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsageRepository(): UsageRepository = UsageRepository()

    @Provides
    @Singleton
    fun provideThemePreference(@ApplicationContext context: Context): ThemePreference =
        ThemePreference(context)
}