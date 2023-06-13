package com.douglasqueiroz.thewallet.feature.currencylist.logic

import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CurrencyListViewModelTest {

    @MockK
    private lateinit var navRouter: NavRouter

    @MockK(relaxed = true)
    private lateinit var currencyDao: CurrencyDao

    private lateinit var target: CurrencyListViewModel

    @BeforeEach
    fun setUp() {

        MockKAnnotations.init(this)

        target = CurrencyListViewModel(
            navRouter = navRouter,
            currencyDao = currencyDao
        )
    }

    @Test
    fun `init() - when Dao emits one currency then show the currency`() {
        val currency = mockk<Currency>(relaxed = true)

        every {
            currencyDao.getAll()
        }.returns(flowOf(listOf(currency)))

        target.loadCurrencies()

        val result = target.state.currencyList

        assertEquals(1, result.size)
    }

    @Test
    fun `init() - when has no currency name is A then show a currency with name A`() {
        val currencyName = "A"

        val currency = mockk<Currency>(relaxed = true)

        every {
            currency.name
        }.returns(currencyName)

        every {
            currencyDao.getAll()
        }.returns(flowOf(listOf(currency)))

        target.loadCurrencies()

        val result = target.state.currencyList

        assertEquals(currencyName, result.first().currencyName)
    }

    @Test
    fun `init() - when has no currency symbol A then show a currency with symbol A`() {
        val currencySymbol = "$/A"



        val currency = mockk<Currency>(relaxed = true)

        every {
            currency.symbol
        }.returns(currencySymbol)

        every {
            currencyDao.getAll()
        }.returns(flowOf(listOf(currency)))

        target.loadCurrencies()

        val result = target.state.currencyList

        assertEquals(currencySymbol, result.first().currencySymbol)



    }
}