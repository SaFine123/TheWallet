package com.douglasqueiroz.thewallet.feature.currencylist.logic

import app.cash.turbine.test
import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CurrencyListViewModelTest {


    private val currencyDaoFlow = MutableStateFlow(emptyList<Currency>())

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = UnconfinedTestDispatcher()

    @MockK
    private lateinit var navRouter: NavRouter

    @MockK(relaxed = true)
    private lateinit var currencyDao: CurrencyDao

    private lateinit var target: CurrencyListViewModel

    @BeforeEach
    fun setUp() {

        Dispatchers.setMain(dispatcher)

        MockKAnnotations.init(this)

        every {
            currencyDao.getAll()
        }.returns(currencyDaoFlow)

        target = CurrencyListViewModel(
            navRouter = navRouter,
            currencyDao = currencyDao
        )
    }

    @Test
    fun `init() - when Dao emits one currency then show the currency`() = runBlocking {
        val currency = mockk<Currency>(relaxed = true)

        currencyDaoFlow.emit(listOf(currency))

        target.stateFlow.test {
            assertEquals(1, expectMostRecentItem().currencyList.size)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `init() - when Dao emits a currency with name is A then show a currency with name A`() = runBlocking {
        val currencyName = "A"

        val currency = mockk<Currency>(relaxed = true)

        every {
            currency.name
        }.returns(currencyName)

        currencyDaoFlow.emit(listOf(currency))

        target.stateFlow.test {
            assertEquals(currencyName, expectMostRecentItem().currencyList.first().currencyName)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `init() - when Dao emits currency with symbol A then show a currency with symbol A`() = runBlocking {
        val currencySymbol = "$/A"

        val currency = mockk<Currency>(relaxed = true)

        every {
            currency.symbol
        }.returns(currencySymbol)

        currencyDaoFlow.emit(listOf(currency))

        target.stateFlow.test {
            assertEquals(currencySymbol, expectMostRecentItem().currencyList.first().currencySymbol)
            cancelAndIgnoreRemainingEvents()
        }
    }
}