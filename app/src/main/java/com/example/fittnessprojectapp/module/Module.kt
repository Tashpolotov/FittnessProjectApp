package com.example.fittnessprojectapp.module

import com.example.data.FitnessRepositoryMock
import com.example.domain.repository.FitnessRepository
import com.example.domain.usecase.FitnessUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideRepository():FitnessRepository{
        return FitnessRepositoryMock()
    }

    fun provideUseCase(repository: FitnessRepository):FitnessUseCase{
        return FitnessUseCase(repository)
    }
}