package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list

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
class AdminCategoryListViewModel @Inject constructor(
    private  val categoriesUseCase: CategoriesUseCase
): ViewModel() {
    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)
        private  set
    var deleteCategoriesResponse by mutableStateOf<Resource<Unit>?>(null)
        private  set
    init {
        getCategories()
    }
    fun getCategories () =  viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoriesUseCase.getCategories().collect () {  data ->
            categoriesResponse =data

        }
    }
    fun deleteCategory(id: String) = viewModelScope.launch {
        deleteCategoriesResponse = Resource.Loading
        val result = categoriesUseCase.deleteCategory(id)
        deleteCategoriesResponse = result
    }
}