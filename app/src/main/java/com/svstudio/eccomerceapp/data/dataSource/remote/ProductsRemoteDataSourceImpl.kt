package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.data.dataSource.remote.service.ProductsService
import com.svstudio.eccomerceapp.domain.model.Product
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class ProductsRemoteDataSourceImpl(private  val productsService: ProductsService): ProductsRemoteDataSource {
    override suspend fun findAll(): Response<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun findByCategory(idCategory: String): Response<List<Product>> = productsService.findByCategory(idCategory)

    override suspend fun create(
        product: Product,
        files: List<File>
    ): Response<Product> {
        val images = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"
        files.forEachIndexed { index,file ->
            val  conection = file.toURI().toURL().openConnection()
            val mimeType = conection.contentType
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images [index]= MultipartBody.Part.createFormData("files[]",file.name,requestFile)

        }

        val nameData = product.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = product.description.toRequestBody(contentType.toMediaTypeOrNull())
        val ideCategoryData = product.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        val priceData = product.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        return  productsService.create(images, nameData, descriptionData,ideCategoryData,priceData)
    }

    override suspend fun update(
        id: String,
        product: Product,
        files: List<File>?
    ): Response<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}