package com.mindorks.framework.mvp.ui.base.presenter

import com.sumeyye.projetakip.ui.base.interactor.BaseInteractor
import com.sumeyye.projetakip.ui.base.view.BaseView

interface IBasePresenter<V : BaseView, I : BaseInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}