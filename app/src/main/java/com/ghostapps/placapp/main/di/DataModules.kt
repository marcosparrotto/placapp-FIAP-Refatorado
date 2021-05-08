package com.ghostapps.placapp.main.di

import org.koin.dsl.module
import com.ghostapps.placapp.data.records.local.useCases.DeleteLocalRegister
import com.ghostapps.placapp.data.records.local.useCases.GetAllLocalRegister
import com.ghostapps.placapp.data.records.local.useCases.InsertLocalRegister

object DataModules {
    val modules = module {

        factory {
            InsertLocalRegister(get())
        }

        factory {
            DeleteLocalRegister(get())
        }

        factory {
            GetAllLocalRegister(get())
        }

    }
}