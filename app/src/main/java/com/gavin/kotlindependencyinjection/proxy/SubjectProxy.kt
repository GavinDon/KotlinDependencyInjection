package com.gavin.kotlindependencyinjection.proxy

/**
 * description:代理类，通过其访问委托的实现
 * Created by liNan on 2018/9/30 9:42

 */
class SubjectProxy(subject:ISubject) :ISubject by subject