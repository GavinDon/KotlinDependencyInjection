package com.gavin.kotlindependencyinjection.fuel

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

/**
 * description:使用密封类来限制子类的行为
 *
 * <pr>一个密封类是自身抽象的，它不能直接实例化并可以有抽象（abstract）成员。
 * 密封类不允许有非-private 构造函数（其构造函数默认为 private）。
 * 请注意，扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中。</pr>
 *
 * Created by liNan on 2018/10/11 17:09

 */
sealed class FuelApi : FuelRouting {
    override val basePath: String = ""

    companion object {
        val HOME = "article/list/0/json"
    }

    class fuelFor(val location: String) : FuelApi() {
        override val body: String?
            get() = ""
        override val headers: Map<String, String>? = null
        override val method: Method
            get() = Method.GET
        override val params: List<Pair<String, Any?>>?
            get() = null
        override val path: String
            get() = "api/${location}/search/"

    }

}