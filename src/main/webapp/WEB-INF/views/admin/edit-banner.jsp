<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="content">
    <div class="container-fluid">
        <div class="p-5"
             style="box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px; border-radius: 20px;background-color: #ffff;">

<%--            <c:forEach items="${listImg}" var="item">--%>
<%--                <form action="/admin/save-banner" method="post" enctype="multipart/form-data">--%>
<%--                    <div class="row">--%>
<%--                        <input type="hidden" name="id" value="${item.id}">--%>
<%--                        <div class="col-sm-5">--%>
<%--                            <input onchange="chooseFile(this, ${item.id})" value="" class="form-control"--%>
<%--                                   name="newImage" type="file" id="imageInput-${item.id}" multiple>--%>
<%--                            <div class="col-sm-12" id="imageContainer-${item.id}">--%>
<%--                                <c:if test="${not empty item.imgUrl}">--%>
<%--                                    <div style="height: 350px;width: 1000px">--%>
<%--                                        <img src="/image/${item.imgUrl}" width="100%" height="300px" class="col-sm-6">--%>
<%--                                    </div>--%>
<%--                                </c:if>--%>
<%--                            </div>--%>
<%--                            <button type="submit" class="btn btn-primary">save</button>--%>
<%--                            <br>--%>
<%--                            <hr>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </c:forEach>--%>

            <c:forEach items="${listImg}" var="item">
                <form action="/admin/save-banner" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <input type="hidden" name="id" value="${item.id}">
                        <div class="col-sm-5">
                            <input onchange="chooseFile(this, ${item.id})" value="" class="form-control"
                                   name="newImage" type="file" id="imageInput-${item.id}" multiple>
                            <div class="col-sm-12" id="imageContainer-${item.id}">
                                <c:if test="${not empty item.imgUrl}">
                                    <div style="height: 350px;width: 1000px">
                                        <img src="/image/${item.imgUrl}" width="100%" height="300px" class="col-sm-6"
                                             id="preview-${item.id}">
                                    </div>
                                </c:if>
                            </div>
                            <button type="submit" class="btn btn-primary">save</button>
                            <br>
                            <hr>
                        </div>
                    </div>
                </form>
            </c:forEach>


        </div>
    </div>
</section>
<script>
    var oldImage = {};

    chooseFile = (fileInput, id) => {
        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();

            reader.onload = (e) => {
                // Hiển thị ảnh mới
                var imageContainer = document.getElementById(`imageContainer-${id}`);
                imageContainer.innerHTML = "";

                var img = document.createElement("img");
                img.src = e.target.result;
                img.width = 200;
                img.style.marginLeft = '10px';
                img.style.borderRadius = '8px';

                imageContainer.appendChild(img);

                // Lưu đường dẫn của ảnh mới vào biến oldImage
                oldImage[id] = e.target.result;
            };

            reader.readAsDataURL(fileInput.files[0]);
        } else {
            // Nếu không có ảnh mới, hiển thị ảnh cũ
            var imageContainer = document.getElementById(`imageContainer-${id}`);
            imageContainer.innerHTML = "";

            var img = document.createElement("img");
            img.src = oldImage[id];
            img.width = 200;
            img.style.marginLeft = '10px';
            img.style.borderRadius = '8px';

            imageContainer.appendChild(img);
        }
    }
</script>

<%--<script>--%>
<%--    chooseFile = (fileInput) => {--%>
<%--        if (fileInput.files && fileInput.files[0]) {--%>
<%--            var reader = new FileReader();--%>
<%--            reader.onload = (e) => {--%>
<%--                $('#image').attr('src', e.target.result);--%>
<%--            }--%>
<%--            reader.readAsDataURL(fileInput.files[0]);--%>
<%--        }--%>
<%--    }--%>
<%--    document.getElementById("imageInput").addEventListener("change", function (event) {--%>
<%--        var imageContainer = document.getElementById("imageContainer");--%>
<%--        imageContainer.innerHTML = ""; // Xóa nội dung trước đó--%>

<%--        var selectedFiles = event.target.files;--%>
<%--        for (var i = 0; i < selectedFiles.length; i++) {--%>
<%--            var file = selectedFiles[i];--%>
<%--            if (file.type.startsWith("image/")) {--%>
<%--                var img = document.createElement("img");--%>
<%--                img.classList.add("newImages");--%>

<%--                var reader = new FileReader();--%>
<%--                reader.onload = (function (imgElement) {--%>
<%--                    return function (e) {--%>
<%--                        imgElement.src = e.target.result;--%>
<%--                        imgElement.width = 200;--%>
<%--                        imgElement.style.marginLeft = '10px'--%>
<%--                        imgElement.style.borderRadius = '8px'--%>
<%--                    };--%>
<%--                })(img);--%>

<%--                reader.readAsDataURL(file);--%>
<%--                imageContainer.appendChild(img);--%>
<%--            }--%>
<%--        }--%>
<%--    });--%>

<%--    &lt;%&ndash;function previewImage(input, id) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;    if (input.files && input.files[0]) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;        var reader = new FileReader();&ndash;%&gt;--%>

<%--    &lt;%&ndash;        reader.onload = function (e) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;            var imagePreview = document.getElementById(`imagePreview-${id}`);&ndash;%&gt;--%>
<%--    &lt;%&ndash;            imagePreview.src = e.target.result;&ndash;%&gt;--%>
<%--    &lt;%&ndash;        };&ndash;%&gt;--%>

<%--    &lt;%&ndash;        reader.readAsDataURL(input.files[0]);&ndash;%&gt;--%>
<%--    &lt;%&ndash;    }&ndash;%&gt;--%>
<%--    &lt;%&ndash;}&ndash;%&gt;--%>
<%--</script>--%>
<script>
    <c:if test="${not empty success}">
    $(document).ready(function () {
        $.toast({
            text: "${success}.", // Text that is to be shown in the toast
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