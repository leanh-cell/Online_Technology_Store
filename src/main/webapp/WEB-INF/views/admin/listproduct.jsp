<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    .table {
        table-layout: fixed;
        width: 100%;
        text-align: center;
        /* align-items: center; */
    }

    .table th, .table td {
        width: 25%;
        text-align: center;
        vertical-align: middle;
        font-weight: 650;
        /* font-size: 10px; */
    }
</style>
<section class="content">
    <div class="container-fluid">
        <div class="p-5"
             style="box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px; border-radius: 20px; background-color: #ffff;">
            <a href="/admin/add-new-product" class="btn btn-primary mb-4">+</a>
            <form class="d-flex mb-3" action="/admin/list-product" method="get">
                <input name="keyword" style="width: 300px;" class="form-control me-2" type="search"
                       placeholder="Nhập tên sản phẩm, mã sản phẩm..." aria-label="Search">
                <button class="btn btn-outline-success ml-3" type="submit">Tìm kiếm</button>
            </form>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">MÃ SẢN PHẨM</th>
                    <th scope="col">TÊN SẢN PHẨM</th>
                    <th scope="col">GIÁ</th>
                    <th scope="col">SỐ LƯỢNG</th>
                    <th scope="col">GIẢM GIÁ</th>
                    <th scope="col">ẢNH</th>
                    <th scope="col">LOẠI</th>
                    <th scope="col">NHÀ SẢN XUẤT</th>
                    <th scope="col"></th>
<%--                    <th scope="col"></th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listProduct.content}" var="product">
                    <tr>
                        <th scope="row">${product.id}</th>
                        <td>${product.name}</td>
                        <td><fmt:formatNumber value="${product.price}"
                                              pattern="###,###,###.##"/>đ
                        </td>
                        <td>${product.qty}</td>
                        <td>${product.discount}</td>
                        <td>
                            <c:forEach items="${fn:split(product.img, ',')}" var="image" varStatus="status">
                                <c:if test="${status.index == 0}">
                                    <div class="fit-image-container" style="display: inline-block; margin-right: 10px;">
                                        <img src="/image/${image}" class="fit-image" style="width: 100px;height: 100px;"
                                             alt="...">
                                    </div>
                                </c:if>
                            </c:forEach>
<%--                		<img src="/image/${product.img}" style="width: 100px;" alt="">--%>
                        </td>
                        <td>${product.category.name}</td>
                        <td>${product.brand.name}</td>
                        <td><a class="btn btn-primary" href="/admin/edit-product?id=${product.id}">Edit</a>
                            <a class="btn btn-danger" href="/admin/delete-product?id=${product.id}">Delete</a></td>
<%--                        <td><a class="btn btn-primary" href="/admin/delete-product?id=${product.id}">Delete</a></td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <nav aria-label="Page navigation">
                    <ul class="pagination" id="pagination"></ul>
                </nav>
                <form id="sumitForm" action="/admin/list-product" method="get">
                    <input id="page" name="p" type="hidden">
                </form>
            </div>
        </div>
    </div>
</section>
<script>
    <%--var totalPages = ${listProduct.totalPages}; // Tổng số trang--%>
    <%--var itemsPerPage = ${listProduct.size}; // Số lượng sản phẩm trên mỗi trang--%>
    <%--var visiblePages = Math.min(totalPages, Math.ceil(totalPages / itemsPerPage));--%>

    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: ${listProduct.totalPages},
            visiblePages: 5,
            startPage: ${listProduct.number+1},
            onPageClick: function (event, page) {
                console.info(page)

                if (page !=${listProduct.number+1}) {
                    $('#page').val(parseInt(page - 1));
                    $('#sumitForm').submit();
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
<script>
    <c:if test="${message != null}">
    $(document).ready(function () {
        $.toast({
            text: "${message}.", // Text that is to be shown in the toast
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

    </c:if>
</script>
