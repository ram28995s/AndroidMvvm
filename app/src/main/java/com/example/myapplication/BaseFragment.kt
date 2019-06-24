package com.example.myapplication

import android.app.Activity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import android.view.View
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment() {

    private var mActivity: BaseActivity<*, *>? = null
    private var mRootView: View? = null
    private var mViewDataBinding: T? = null
    private var mViewModel: V? = null

    protected abstract fun getBindingVariable(): Int

    protected abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)

        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<*, *>
            this.mActivity = activity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel();
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding?.getRoot();
        return mRootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding?.executePendingBindings();
    }

    fun getBaseActivity(): BaseActivity<*, *>? {
        return mActivity
    }

    protected fun getViewDataBinding(): T? {
        return mViewDataBinding
    }

    protected fun getModelVariable(): V? {
        return mViewModel
    }

}