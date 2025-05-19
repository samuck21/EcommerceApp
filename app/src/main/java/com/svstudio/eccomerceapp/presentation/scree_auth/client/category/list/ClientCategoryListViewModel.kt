package com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list

import androidx.annotation.HalfFloat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.categories.CategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ClientCategoryListViewModel @Inject constructor(private  val categoriesUseCase: CategoriesUseCase): ViewModel(){
var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)
    private set

    init {
        getCategories()
    }
    fun getCategories() = viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoriesUseCase.getCategories().collect {
            categoriesResponse = it
        }
    }
}