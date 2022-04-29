package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.DetailImages
import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.repository.ProductDetailRepository
import com.example.sidedish.model.RepresentImages
import com.example.sidedish.ui.common.ButtonState
import com.example.sidedish.ui.common.ThrowableState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
) :
    ViewModel() {

    private val _productDetail = MutableLiveData<ProductDetail>()
    val productDetail: LiveData<ProductDetail> = _productDetail

    private val _representImage = MutableLiveData<List<RepresentImages>>()
    val representImage: LiveData<List<RepresentImages>> = _representImage

    private val _detailImage = MutableLiveData<List<DetailImages>>()
    val detailImage: LiveData<List<DetailImages>> = _detailImage

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage

    private val _error = MutableLiveData<Pair<Throwable, ThrowableState>>()
    val error: LiveData<Pair<Throwable, ThrowableState>> = _error

    init {
        _quantity.value = 1
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.stackTrace

        when (throwable) {
            is SocketException -> _error.value = Pair(throwable, ThrowableState.SOCKET_EXCEPTION)
            is HttpException -> _error.value = Pair(throwable, ThrowableState.HTTP_EXCEPTION)
            is UnknownHostException -> _error.value = Pair(throwable, ThrowableState.UNKNOWN_HOST_EXCEPTION)
            else -> _error.value = Pair(throwable, ThrowableState.EXCEPTION)
        }
    }

    fun loadProductDetail(productId: Int) {
        viewModelScope.launch(exceptionHandler) {
            val detail = productDetailRepository.loadProductDetail(productId)
            detail?.let {
                _productDetail.value = it
                _representImage.value = it.representImages
                _detailImage.value = it.detailImages
            }
        }
    }

    fun postProductCount(postRequest: PostRequest) {
        viewModelScope.launch(exceptionHandler) {
            val errorMessage = productDetailRepository.orderProduct(postRequest)
            errorMessage?.let {
                _errorMessage.value = it
            }
        }
    }

    fun setQuantity(buttonState: ButtonState) {
        when (buttonState) {
            ButtonState.PLUS -> _quantity.value = _quantity.value?.plus(1)
            ButtonState.MINUS -> _quantity.value = _quantity.value?.minus(1)
        }
    }
}