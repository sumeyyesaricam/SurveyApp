package com.mindorks.framework.mvp.ui.base.presenter

import com.sumeyye.projetakip.ui.base.interactor.BaseInteractor
import com.sumeyye.projetakip.ui.base.view.BaseView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : BaseView, I : BaseInteractor> internal constructor(protected var interactor: I?) : IBasePresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        //view = null
        //interactor = null
    }

}