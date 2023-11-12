<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    .error-message {
        color: red;
    }
</style>
<div class="col-sm-12 m-auto p-0 m-0" style="background-color: #f9f8f7;">
    <a href="/admin/list-product" class="btn btn-primary ml-2 mb-2">Quay lại</a>
    <div class="container-user p-4 ml-2 mr-2"
         style="background-color: #fff; box-shadow: rgba(165, 163, 163, 0.24) 0px 3px 8px;">
        <form action="/admin/update-product" method="POST"
              enctype="multipart/form-data" onsubmit="return validateForm()">
            <div class="row">
                <div class="col-sm-8">
                    <div class="row">

                        <div class="col-sm-12">
                            <div class="mb-3">
                                <label for="nameInput" class="form-label">TÊN SẢN PHẨM<img
                                        src="image source" class="img-fluid rounded-top" alt=""></label>
                                <input value="${formProduct.name}" name="name" id="nameInput"
                                       type="text" class="form-control">
                                <p id="nameError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="idInput" class="form-label">MÃ SẢN PHẨM<img
                                        src="image source" class="img-fluid rounded-top" alt=""></label>
                                <input readonly value="${formProduct.id}" name="id" id="idInput"
                                       type="text" class="form-control">
                                <p id="idError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="priceInput" class="form-label">GIÁ <img
                                        src="image source" class="img-fluid rounded-top" alt=""></label>
                                <input value="${formProduct.price}" name="price" id="priceInput"
                                       type="number" class="form-control">
                                <p id="priceError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="qtyInput" class="form-label">SỐ LƯỢNG <img
                                        src="image source" class="img-fluid rounded-top" alt=""></label>
                                <input value="${formProduct.qty}" name="qty" id="qtyInput"
                                       type="number" class="form-control">
                                <p id="qtyError" class="error-message"></p>
                            </div>
                        </div>
<%--                        <div class="col-sm-6">--%>
<%--                            <div class="mb-3">--%>
<%--                                <label for="imageInput" class="form-label">ẢNH SẢN PHẨM</label>--%>
<%--                                <input onchange="chooseFile(this)" value="" class="form-control"--%>
<%--                                       name="image" type="file" id="imageInput">--%>
<%--                                <p id="imageError" class="error-message"></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <input value="${formProduct.img}" name="img" type="hidden">--%>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="categoryInput" class="form-label">LOẠI SẢN
                                    PHẨM</label>
                                <div data-bs-spy="scroll" data-bs-target="#my-select"
                                     class="scrollspy-example">
                                    <select name="category.id" id="categoryInput"
                                            class="form-select" data-bs-select="on" data-bs-size="2">
                                        <option value="" selected>Chọn</option>
                                        <c:forEach var="listcbocategory" items="${listcbocategory}">
                                            <option
                                                ${formProduct.category.id == listcbocategory.id ? "selected" : ""}
                                                    value="${listcbocategory.id}">${listcbocategory.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <p id="categoryError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="brandInput" class="form-label">NHÀ SẢN XUẤT</label>
                                <div data-bs-spy="scroll" data-bs-target="#my-select"
                                     class="scrollspy-example">
                                    <select name="brand.id" id="brandInput" class="form-select"
                                            data-bs-select="on" data-bs-size="2">
                                        <option value="" selected>Chọn</option>
                                        <c:forEach var="listcbobrand" items="${listcbobrand}">
                                            <option
                                                ${formProduct.brand.id == listcbobrand.id ? "selected" : ""}
                                                    value="${listcbobrand.id}">${listcbobrand.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <p id="brandError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="mb-3">
                                <label for="priceInput" class="form-label">GIẢM GIÁ <img
                                        src="image source" class="img-fluid rounded-top" alt=""></label>
                                <input value="${formProduct.discount > 0 ? formProduct.discount : 0}" name="discount" id="discountInput"
                                       type="number" class="form-control">
                                <p id="discountError" class="error-message"></p>
                            </div>
                        </div>
                        <div class="mb-3 col-sm-12">
                            <label for="descriptionInput" class="form-label">GHI CHÚ</label>
                            <textarea value="" name="description"
                                      id="descriptionInput" class="example form-control"
                                      placeholder="Nhập ghi chú (nếu )" rows="3">
                                <c:out value="${formProduct.description}" >
                                </c:out>
                            </textarea>
                        </div>
                    </div>
                    <h4>${message}</h4>
                    <div class="row">
                        <div style="text-align: center;" class="col-sm-4">
                            <button type="submit" class="btn btn-primary">
                                <i class="bi bi-file-earmark-check"></i> Update
                            </button>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="mb-3">
                        <label for="imageInput" class="form-label">ẢNH SẢN PHẨM
                            <span style="color: gray;font-style: italic;font-weight: 300;">
                &nbsp; (Lưu ý để hiển thị tốt nhất bạn nên dùng ảnh 600x600)
            </span>
                        </label>
                        <input onchange="chooseFile(this)" value="" class="form-control"
                               name="image" type="file" id="imageInput" multiple>
                        <p id="imageError" class="error-message"></p>
                    </div>

                    <div class="col-sm-12" id="imageContainer"
                         style="overflow-x: auto; overflow-y: hidden; white-space: nowrap; scrollbar-color: #e0e0e0 #6969dd; ">
                        <!-- Kiểm tra nếu danh sách ảnh sản phẩm không rỗng -->
                        <c:if test="${not empty fn:split(formProduct.img, ',')}">
                            <!-- Hiển thị ảnh ban đầu từ danh sách sản phẩm -->
                            <c:forEach items="${fn:split(formProduct.img, ',')}" var="image">
                                <div style="display: inline-block;margin-right: 10px; width:200px;height: 300px">
                                    <img src="/image/${image}" class="d-block" style="width: 100%;height: 100%;border-radius: 8px;" alt="...">
                                </div>
                            </c:forEach>
                        </c:if>
                        <!-- Nếu danh sách ảnh sản phẩm rỗng, hiển thị ảnh mặc định hoặc thông báo -->
                        <c:if test="${empty fn:split(formProduct.img, ',')}">
                            <!-- Hiển thị ảnh mặc định hoặc thông báo -->
                            <div style="margin-right: 10px;">
<%--                                <img src="/path/to/default/image.jpg" class="d-block w-100 h-100" alt="...">--%>
                                <h6>sản phẩm này chưa có ảnh nào</h6>
                                <!-- Hoặc hiển thị thông báo -->
                                <!-- <p>Chưa có ảnh cho sản phẩm này.</p> -->
                            </div>
                        </c:if>
                    </div>
                </div>
<%--                <div class="col-sm-4">--%>
<%--                    <div class="mb-3">--%>
<%--                        <label for="imageInput" class="form-label">ẢNH SẢN PHẨM</label>--%>
<%--                        <input onchange="chooseFile(this)" value="" class="form-control"--%>
<%--                               name="image" type="file" id="imageInput" multiple>--%>
<%--                        <p id="imageError" class="error-message"></p>--%>
<%--                    </div>--%>
<%--                    <div class="col-sm-12" id="imageContainer"--%>
<%--                         style="overflow-x: auto; white-space: nowrap;scrollbar-color: #e0e0e0 #6969dd">--%>
<%--                        <c:forEach items="${fn:split(formProduct.img, ',')}" var="image" varStatus="status">--%>
<%--                            <div id="image" style="width: 100%; height: 100%; object-fit: contain;"  data-bs-interval="10000">--%>
<%--                                <img src="/image/${image}" class="d-block w-100 h-100" alt="...">--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                        <img --%>
<%--                             style="width: 100%; height: 100%; object-fit: contain;"--%>
<%--                             src="/image/${formProduct.img}" alt="">--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <div style="background-color: rgb(241, 241, 241); height: 400px;">--%>
<%--                           --%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <input value="${formProduct.img}" name="img" type="hidden">--%>

<%--            </div>--%>
        </form>

    </div>
</div>

<script>
    $(document).ready(function (){
    $(".example").richText();
    });
</script>
<script>
        var textarea = document.getElementById('descriptionInput');
        textarea.textContent = ${formProduct.description};
</script>
<script>
        function validateForm() {
            var id = document.getElementById('idInput').value;
            var name = document.getElementById('nameInput').value;
            var price = document.getElementById('priceInput').value;
            var qty = document.getElementById('qtyInput').value;
            var category = document.getElementById('categoryInput').value;
            var brand = document.getElementById('brandInput').value;

            var isValid = true;

            var errorMessages = document.getElementsByClassName('error-message');
            for (var i = 0; i < errorMessages.length; i++) {
                errorMessages[i].innerText = '';
            }


            if (id.trim() === '') {
                document.getElementById('idError').innerText = 'Vui lòng nhập mã sản phẩm';
                isValid = false;
            }


            if (name.trim() === '') {
                document.getElementById('nameError').innerText = 'Vui lòng nhập tên sản phẩm';
                isValid = false;
            }


            if (price.trim() === '' || isNaN(price)) {
                document.getElementById('priceError').innerText = 'Vui lòng nhập giá sản phẩm hợp lệ';
                isValid = false;
            }

            if (qty.trim() === '' || isNaN(qty)) {
                document.getElementById('qtyError').innerText = 'Vui lòng nhập số lượng hợp lệ';
                isValid = false;
            }

            if (category.trim() === '') {
                document.getElementById('categoryError').innerText = 'Vui lòng chọn loại sản phẩm';
                isValid = false;
            }

            if (brand.trim() === '') {
                document.getElementById('brandError').innerText = 'Vui lòng chọn nhà sản xuất';
                isValid = false;
            }

            return isValid;
        }

        // chooseFile = (fileInput) => {
        //     if (fileInput.files && fileInput.files[0]) {
        //         var reader = new FileReader();
        //         reader.onload = (e) => {
        //             $('#image').attr('src', e.target.result);
        //         }
        //         reader.readAsDataURL(fileInput.files[0]);
        //     }
        // }
        // document.getElementById("imageInput").addEventListener("change", function (event) {
        //     var imageContainer = document.getElementById("imageContainer");
        //     imageContainer.innerHTML = ""; // Xóa nội dung trước đó
        //
        //     var selectedFiles = event.target.files;
        //     for (var i = 0; i < selectedFiles.length; i++) {
        //         var file = selectedFiles[i];
        //         if (file.type.startsWith("image/")) {
        //             var img = document.createElement("img");
        //             img.classList.add("preview-image");
        //
        //             var reader = new FileReader();
        //             reader.onload = (function (imgElement) {
        //                 return function (e) {
        //                     imgElement.src = e.target.result;
        //                     imgElement.width = 200;
        //                     imgElement.style.marginLeft = '10px'
        //                     imgElement.style.borderRadius = '8px'
        //                 };
        //             })(img);
        //
        //             reader.readAsDataURL(file);
        //             imageContainer.appendChild(img);
        //         }
        //     }
        // });
    </script>
<script>
    // Hàm hiển thị ảnh khi chọn file
    function chooseFile(fileInput) {
        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = (e) => {
                $('#image').attr('src', e.target.result);
            }
            reader.readAsDataURL(fileInput.files[0]);
        }
    }

    // Sự kiện thay đổi khi chọn ảnh mới
    document.getElementById("imageInput").addEventListener("change", function (event) {
        var imageContainer = document.getElementById("imageContainer");
        imageContainer.innerHTML = ""; // Xóa nội dung trước đó

        var selectedFiles = event.target.files;
        for (var i = 0; i < selectedFiles.length; i++) {
            var file = selectedFiles[i];
            if (file.type.startsWith("image/")) {
                var img = document.createElement("img");
                img.classList.add("preview-image");

                var reader = new FileReader();
                reader.onload = (function (imgElement) {
                    return function (e) {
                        imgElement.src = e.target.result;
                        imgElement.width = 200;
                        imgElement.style.marginLeft = '10px';
                        imgElement.style.borderRadius = '8px';
                    };
                })(img);

                reader.readAsDataURL(file);
                imageContainer.appendChild(img);
            }
        }
    });
</script>