package com.platzi.android.rickandmorty.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.platzi.android.rickandmorty.views.RecyclerViewItemDecoration

fun Context.showLongToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.showLongToast(@StringRes resourceId: Int){
    Toast.makeText(this, resourceId, Toast.LENGTH_LONG).show()
}

inline fun <reified T : Activity> Context.startActivity(body: Intent.() -> Unit) {
    startActivity(Intent(this, T::class.java).apply(body))
}

fun RecyclerView.setItemDecorationSpacing(padding: Float) {
    addItemDecoration(RecyclerViewItemDecoration(padding.toInt()))
}

fun <T : ViewDataBinding> ViewGroup.bindingInflate(
    @LayoutRes layoutRes: Int,
    attachToRoot: Boolean = true
): T = DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, this, attachToRoot)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline factory: () -> T): T {

    val viewModelFactory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this.viewModelStore, viewModelFactory)[T::class.java]
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {

    val viewModelFactory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this.viewModelStore, viewModelFactory)[T::class.java]
}

inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}