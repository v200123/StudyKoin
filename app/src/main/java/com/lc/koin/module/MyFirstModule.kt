package com.lc.koin.module

import com.lc.koin.bean.testBean
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 *@author LC
 *@createTime 2020/7/12 15:10
 *@description
 */
val personModule = module {
    factory {(name:String) -> testBean(name,51) }
}