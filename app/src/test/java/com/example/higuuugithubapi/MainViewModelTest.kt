package com.example.higuuugithubapi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.higuuugithubapi.data.UserRepoResponse
import com.example.higuuugithubapi.main.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var clientApiRepository: ClientApiRepository
    @RelaxedMockK
    private lateinit var observer: Observer<List<UserRepoResponse>>

    private lateinit var mainActivityViewModel: MainViewModel

    @Before
    fun setup () {
        MockKAnnotations.init(this)
        mainActivityViewModel = MainViewModel(clientApiRepository)
    }

    @Test
    fun successTest() {
        val user = "higuuu"
        val userRepos = listOf(UserRepoResponse("1","higuuu","https"))
        every {
            clientApiRepository.getUser(
                user
            )
        } returns Single.just(userRepos)

        mainActivityViewModel.userRepos.observeForever(observer)
        mainActivityViewModel.getUser(user)
        verify(exactly = 1){observer.onChanged(userRepos)}
    }
}