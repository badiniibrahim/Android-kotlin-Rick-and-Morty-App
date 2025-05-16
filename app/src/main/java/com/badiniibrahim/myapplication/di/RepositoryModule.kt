package com.badiniibrahim.myapplication.di

import com.badiniibrahim.myapplication.data.repository.RickAndMortyRepositoryImpl
import com.badiniibrahim.myapplication.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providerRepositoryModule(impl: RickAndMortyRepositoryImpl):RickAndMortyRepository
}