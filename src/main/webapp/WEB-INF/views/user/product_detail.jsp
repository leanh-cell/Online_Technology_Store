<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    .fit-image-container {
        width: 120px; /* Đặt kích thước của container */
        height: 120px;
        overflow: hidden; /* Để ảnh không tràn ra khỏi container */
        border-radius: 8px;
    }

    .fit-image {
        width: 100%; /* Kích thước ảnh sẽ chiếm 100% của container */
        height: 100%;
        object-fit: cover; /* Hiển thị ảnh mà không làm thay đổi tỉ lệ khung hình */
        border-radius: 8px; /* Độ cong góc */
    }
</style>
<div style="max-width: 1200px;" class="m-auto mt-5">

    <!-- product -->
    <div class="row mb-5"
         style="background-color: white; padding: 10px; border-radius: 30px; box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px, rgba(0, 0, 0, 0.1) 0px 2px 4px 0px, rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
        <div class="col-sm-6">
            <div id="demo" class="carousel slide" data-bs-ride="carousel">
                <!-- Indicators/dots -->
                <div class="carousel-indicators">
                    <c:forEach items="${fn:split(productDetail.img, ',')}" var="image" varStatus="status">
                        <button type="button" data-bs-target="#demo" data-bs-slide-to="${status.index}" class="${status.index == 0 ? 'active' : ''}"></button>
                    </c:forEach>
                </div>

                <!-- The slideshow/carousel -->
                <div class="carousel-inner">
                    <c:forEach items="${fn:split(productDetail.img, ',')}" var="image" varStatus="status">
                        <div class="${status.index == 0 ? 'carousel-item active' : 'carousel-item'} " data-bs-interval="10000">
                            <div class="d-flex justify-content-center align-items-center" style="height: 500px; background-color: #f0f0f0;">
                                <img src="/image/${image}" class="img-fluid" style="max-height: 100%; max-width: 100%;" alt="...">
                            </div>
<%--                            <img src="/image/${image}" class="img-fluid" style="height: 500px;" alt="...">--%>
                        </div>
                    </c:forEach>
                </div>

                <!-- Left and right controls/icons -->
                <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" style="color: #0a0e14"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
<%--            <img src="image/${productDetail.img}" style="width: 100%;" class="img-fluid" alt="">--%>
        </div>
        <div class="col-sm-6 p-3">
            <h4 style="font-weight: 600;">${productDetail.name}</h4>

            <div class="row">
                <h5 class="col-sm-4 mt-4 mb-4" style="font-weight: 600; color:red">
                    <fmt:formatNumber value="${productDetail.price - productDetail.discount}" pattern="###,###,###.##"/>đ
                </h5>
                <span class="col-sm-6 mt-4 mb-4">
                    <c:if test="${productDetail.discount > 0}">
                        (Giá gốc :<fmt:formatNumber value="${productDetail.price}"
                                          pattern="###,###,###.##"/>đ)
                    </c:if>

                </span>

            </div>



            <button id="${productDetail.id}" type="button" class="btn btn-primary mt-3 button-details">Thêm vào giỏ
                hàng
            </button>
            <br>
            <br>

        </div>
        <div class="col-sm-12 mt-2">
            <p>${productDetail.description}</p>
        </div>
    </div>


    <div style="max-width: 1200px;" class="m-auto pt-5 pb-5">
        <div class="container-category pt-4">
            <div class="category mt-4 mb-2">
                <!-- <p>fmdkk</p -->
                <div class="row mb-3">
                    <div class="col-sm-6">
                        <p class="text1 m-0 ">
                            <a href="">SẢN PHẨM CÙNG LOẠI</a>
                        </p>
                    </div>
                    <div class="col-sm-6 ">
                        <p class="text2 m-0 ">
                            <a style="font-weight: 400; font-size: 18px;"
                               href="/productcategory?id=${productDetail.category.id}">Xem thêm...</a>
                        </p>
                    </div>
                </div>
                <div style="width: 100%; height: 2px; background-color: black;"></div>
            </div>
        </div>
    </div>

    <div class="m-auto" style="max-width: 1200px;">
        <div class="row">
            <c:forEach items="${productCategoryId}" var="product">
                <div class="col-md-3 col-sm-6 mb-3">
                    <div class="product-grid">
                        <div class="product-image">
                            <a href="#" class="image"> <img class="pic-1 p-4"
                                                            src="/image/${product.img}">
                            </a> <span class="product-discount-label">0</span>
                            <ul class="product-links">
                                <a class="button-detail"
                                   href="/productdetail?productId=${product.id}&categoryId=${product.category.id}"
                                   type="button" class="btn btn-outline-success">Chi tiết</a>
                            </ul>
                        </div>
                        <div class="product-content">
                            <ul class="rating">
                                <li class="fas fa-star"></li>
                                <li class="fas fa-star"></li>
                                <li class="fas fa-star"></li>
                                <li class="far fa-star"></li>
                                <li class="far fa-star"></li>
                            </ul>
                            <h3 class="title">
                                <a href="#">${product.name}</a>
                            </h3>
                            <div class="price">
                                <fmt:formatNumber value="${product.price}"
                                                  pattern="###,###,###.##"/>
                                đ
                            </div>

                            <a href="/add/${product.id}" class="add-to-cart" href="#">Thêm vào giỏ</a>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>
<script>
    $('.button-details').click(function () {
        console.log('Hello');
        var id = $(this).attr('id');
        console.log(id);

        $.ajax({
            url: '/add/' + id,
            type: 'GET',
            success: function (data) {
                console.log("DỮ LIỆU", data);
                $('#lblCartCount').html('');
                $('#lblCartCount').append(data);
            },
            error: function () {
                console.log('Lỗi');
            }
        });
        $.toast({
            text: "Thêm vào giỏ hàng thành công.", // Text that is to be shown in the toast
            heading: 'Thông báo!', // Optional heading to be shown on the toast
            icon: 'success', // Type of toast icon
            showHideTransition: 'fade', // fade, slide or plain
            allowToastClose: true, // Boolean value true or false
            hideAfter: 3000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
            stack: false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
            position: 'top-right', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
            textAlign: 'left', // Text alignment i.e. left, right or center
            loader: true, // Whether to show loader or not. True by default
            loaderBg: '#9EC600', // Background color of the toast loader
            beforeShow: function () {
            }, // will be triggered before the toast is shown
            afterShown: function () {
            }, // will be triggered after the toat has been shown
            beforeHide: function () {
            }, // will be triggered before the toast gets hidden
            afterHidden: function () {
            } // will be triggered after the toast has been hidden
        });

    });
</script>