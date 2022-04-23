package com.scribblex.creditscore.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

open class BaseUnitTest {

    @get:Rule
    var instantExecutorRule =
        InstantTaskExecutorRule() // allows execution of background work on main thread sequentially
}