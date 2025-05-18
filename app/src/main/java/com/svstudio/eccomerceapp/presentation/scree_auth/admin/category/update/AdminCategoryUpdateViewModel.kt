package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.categories.CategoriesUseCase
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.mapper.toCategory
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.mapper.toCategory
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ComposeFileProvider
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryUpdateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val savedStateHandler: SavedStateHandle,
    @ApplicationContext private val context: Context
    ): ViewModel(){
        var state by mutableStateOf(AdminCategoryUpdateState())
            private set
        var categoryResponse by mutableStateOf<Resource<Category>?>(null)

        var file: File? = null
        val resultingActivityHandler = ResultingActivityHandler()
    fun onUpdate(){
        if(file != null){
            updateCategoryWithImage()
        }else{
            updateCategory()
        }
    }

    fun updateCategory() = viewModelScope.launch {
       categoryResponse = Resource.Loading
       val result = categoriesUseCase.updateCategory(category.id!!,state.toCategory())
        categoryResponse = result
    }
    fun updateCategoryWithImage() = viewModelScope.launch {
        categoryResponse = Resource.Loading
        val result = categoriesUseCase.updateCategoryWithImage(category.id!!,state.toCategory(),file !!)
        categoryResponse = result
    }
    fun pickImage() = viewModelScope.launch {
     val result  = resultingActivityHandler.getContent( "image/*" )
       if(result != null){
          file = ComposeFileProvider.createFileFromUri(context, result)
         state = state.copy(image = result.toString())
       }
    }
    fun takePhoto() = viewModelScope.launch {

      val  result =  resultingActivityHandler.takePicturePreview()
       if(result != null){
           state = state.copy( image = ComposeFileProvider.getPathFromBitmap(context,result))
           file = File(state.image)
        }
    }
    var data = savedStateHandler.get<String>("category")
    val category = Category.fromJson(data!!)
    init {
        state = state.copy(
            name = category.name,
            image = category.image!!,
            description = category.description

        )
    }
    fun onNameInput(input: String){
        state = state.copy(name = input)
    }
    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }
}