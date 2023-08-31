package com.curso.android.app.practica.pruebatp



import org.junit.Assert.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.curso.android.app.practica.pruebatp.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun textSame() = runTest {

        launch {
            viewModel.compareText("hola","hola")
         }

        advanceUntilIdle()
        assertEquals("Los textos ingresados son iguales", viewModel.compareResult.value)
    }

    @Test
    fun textDiff() = runTest {

        launch {
            viewModel.compareText("hola","chau")
        }

        advanceUntilIdle()
        assertEquals("Los textos ingresados son diferentes", viewModel.compareResult.value)
    }
    
}