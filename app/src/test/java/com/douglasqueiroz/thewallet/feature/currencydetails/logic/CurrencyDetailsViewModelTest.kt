package com.douglasqueiroz.thewallet.feature.currencydetails.logic

import app.cash.turbine.test
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyDetailsEvent
import com.douglasqueiroz.thewallet.util.StringResUtil
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CurrencyDetailsViewModelTest {

    @MockK(relaxed = true)
    private lateinit var stringResUtil: StringResUtil

    private lateinit var target: CurrencyDetailsViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        target = initTarget()
    }

    private fun initTarget(currency: Currency? = null) = CurrencyDetailsViewModel(
        stringResUtil = stringResUtil,
        currency = currency
    )

    @Test
    fun `init() - when currency with name ABC then fulfil name filed`() = runBlocking {
        val currencyName = "ABC"

        target = initTarget(
            currency = Currency(
                id = 1,
                name = currencyName,
                symbol = "A",
                defaultCurrency = false
            )
        )

        target.state.test {
            assertEquals(currencyName, expectMostRecentItem().currencyName)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `init() - when currency with symbol ABC then fulfil symbol filed`() = runBlocking {
        val currencySymbol = "A"

        target = initTarget(
            currency = Currency(
                id = 1,
                name = "ABC",
                symbol = currencySymbol,
                defaultCurrency = false
            )
        )

        target.state.test {
            assertEquals(currencySymbol, expectMostRecentItem().currencySymbol)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `init() - when currency is the default currency then check the checkbox`() = runBlocking {
        val defaultCurrency = true

        target = initTarget(
            currency = Currency(
                id = 1,
                name = "ABC",
                symbol = "A",
                defaultCurrency = defaultCurrency
            )
        )

        target.state.test {
            assertEquals(defaultCurrency, expectMostRecentItem().defaultCurrency)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onEvent(OnNameChange) - when name is ABC then show name ABC`() = runBlocking {
        val name = "ABC"

        target.onEvent(
            CurrencyDetailsEvent.OnNameChange(newValue = name)
        )

        target.state.test {
            assertEquals(name, expectMostRecentItem().currencyName)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onEvent(OnNameChange) - when name is empty then show an error msg on the name field`() = runBlocking {
        val name = ""
        val errorMessage = "Error message"

        every {
            stringResUtil.getString(R.string.mandatory_field_error)
        }returns errorMessage

        target.onEvent(
            CurrencyDetailsEvent.OnNameChange(newValue = name)
        )

        target.state.test {
            assertEquals(errorMessage, expectMostRecentItem().currencyNameErrorMsg)
            cancelAndIgnoreRemainingEvents()
        }
    }
}