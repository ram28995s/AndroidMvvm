package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.databinding.DataBindingUtil


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity() {

    protected abstract fun getBindingVariable(): Int

    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewMolel(): V

    private var mViewDataBinding: T? = null

    private var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBiding()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    fun performDataBiding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getViewMolel() else mViewModel
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.executePendingBindings()
    }

    protected fun getViewDataBidingVariable(): T? {
        return mViewDataBinding
    }

    fun getModelVariable(): V? {
        return mViewModel
    }
}