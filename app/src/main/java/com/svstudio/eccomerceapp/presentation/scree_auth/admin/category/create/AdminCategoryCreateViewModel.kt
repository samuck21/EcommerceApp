package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create

import android.content.Context
import android.speech.RecognizerResultsIntent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.categories.CategoriesUseCase
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.mapper.toCategory
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ComposeFileProvider
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    @ApplicationContext private val context: Context
    ): ViewModel(){
        var state by mutableStateOf(AdminCategoryCreateState())
            private set
        var categoryResponse by mutableStateOf<Resource<Category>?>(null)

        var file: File? = null
        val resultingActivityHandler = ResultingActivityHandler()
    fun createCategory() = viewModelScope.launch {
       categoryResponse = Resource.Loading
       val result = categoriesUseCase.createCategory(state.toCategory(),file !!)
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
    fun clearForm(){
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse =  null
    }

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }
    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }
}