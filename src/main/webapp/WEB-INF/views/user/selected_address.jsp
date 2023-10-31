<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<div style="max-width: 1200px;" class="m-auto pt-5 pb-5">
    <p class="text-center" style="font-size: 23px; font-weight: bold;">GIỎ HÀNG</p>
    <div class="m-auto"
         style="width: 30%; height: 4px; background-color: black;">
    </div>
</div>
<div style="max-width: 1200px; border-radius: 10px;; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;"
        class="m-auto mb-5 p-4">
    <c:if test="${not empty notify}">
        <h4 style="color: #c40100">${notify}</h4>
    </c:if>

    <div class="row">
        <div class="col-sm-6">
            <form action="/order" method="get">
                <c:forEach var="ad" items="${addressUserId}">
                    <div class="row custom-control custom-radio">
                        <div class="col-sm-1">
                            <input type="radio" class="custom-control-input"
                                   id="customControlValidation2" name="idSelect"
                                   style="width: 20px;height: 20px;"
                                   value="${ad.id}">
                        </div>
                        <div class="col-sm-11">
                            <label class="col-sm-12 custom-control-label"
                                   for="customControlValidation2"
                                   style="font-size: larger;">
                                    ${ad.name} | ${ad.phone}
                            </label>
                            <label class="col-sm-12 custom-control-label"
                                   for="customControlValidation2">${ad.detail}</label>
                            <label class="col-sm-12 custom-control-label"
                                   for="customControlValidation2">${ad.district},${ad.province}</label>
                            <label class="custom-control-label"><c:choose>
                                <c:when test="${ad.isUse == 0}"><span
                                        style="color: blue; font-style: italic;">Mặc Định</span></c:when>
                                <c:when test="${ad.isUse == 1}"><span
                                        style="color: blue; font-style: italic;"></span></c:when>
                            </c:choose></label>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
                <button type="submit" class="btn btn-primary" id="btnaddress">Tiếp tục</button>
            </form>
        </div>
        <div class="col-sm-6">
            <form id="register-form" action="/save-address" method="post">
                <div class="box">
                    <h3 class="heading">New Address !!</h3>
                    <%--                    <form class="mb-5"  method="post" id="contactForm" name="contactForm" novalidate="novalidate">--%>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label for="name" class="col-form-label">Họ và tên</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Họ và tên">
                            <p style="color: red;" id="username-error" class="error-message"></p>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="name" class="col-form-label">Số điện thoại</label>
                            <input type="text" class="form-control" name="phone" id="Phone_number"
                                   placeholder="Số điện thoại">
                            <p style="color: red;" id="phone-error" class="error-message"></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <select class="form-select form-select-sm mb-3" name="province" id="city"
                                    aria-label=".form-select-sm">
                                <option value="">Chọn tỉnh thành</option>
                            </select>
                            <select class="form-select form-select-sm mb-3" name="district" id="district"
                                    aria-label=".form-select-sm">
                                <option value="">Chọn quận huyện</option>
                            </select>
                            <select class="form-select form-select-sm" name="ward" id="ward"
                                    aria-label=".form-select-sm">
                                <option value="">Chọn phường xã</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <label for="message" class="col-form-label">Địa chỉ chi tiết</label>
                            <textarea class="form-control" name="detail" id="message" cols="30" rows="2"></textarea>
                            <p style="color: red;" id="detail-error" class="error-message"></p>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="mb-3">
                            <div class="form-check form-check-inline">
                                <input
                                        class="form-check-input" type="radio" name="isUse"
                                        id="inlineRadio1" value="0" checked> <label
                                    class="form-check-label" for="inlineRadio1">Mặc định</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input
                                        class="form-check-input" type="radio" name="isUse"
                                        id="inlineRadio2" value="1"> <label
                                    class="form-check-label" for="inlineRadio2">Địa chỉ phụ</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <input type="submit" value="Send Message"
                                   class="btn btn-block btn-primary rounded-0 py-2 px-4">
                            <span class="submitting"></span>
                        </div>
                    </div>
                    <%-- </form>--%>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    <c:if test="${not empty notify}">
    $(document).ready(function () {
        $.toast({
            text: "${notify}", // Text that is to be shown in the toast
            heading: 'Note', // Optional heading to be shown on the toast
            icon: 'warning', // Type of toast icon
            showHideTransition: 'fade', // fade, slide or plain
            allowToastClose: true, // Boolean value true or false
            hideAfter: 5000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
            stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
            position: 'top-center', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
            textAlign: 'left',  // Text alignment i.e. left, right or center
            loader: true,  // Whether to show loader or not. True by default
            loaderBg: '#9EC600',  // Background color of the toast loader
            beforeShow: function () {
            }, // will be triggered before the toast is shown
            afterShown: function () {
            }, // will be triggered after the toat has been shown
            beforeHide: function () {
            }, // will be triggered before the toast gets hidden
            afterHidden: function () {
            }  // will be triggered after the toast has been hidden
        });

    });
    <%--    <%session.removeAttribute("loginCart");%>--%>
    </c:if>

    <c:if test="${not empty success}">
    $.toast({
        text: "${success}", // Text that is to be shown in the toast
        heading: 'Thông báo!', // Optional heading to be shown on the toast
        icon: 'success', // Type of toast icon
        showHideTransition: 'fade', // fade, slide or plain
        allowToastClose: true, // Boolean value true or false
        hideAfter: 4000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
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
    </c:if>
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
    var citis = document.getElementById("city");
    var districts = document.getElementById("district");
    var wards = document.getElementById("ward");
    var Parameter = {
        url: "../css/user/vietnam.json", //Đường dẫn đến file chứa dữ liệu hoặc api do backend cung cấp
        method: "GET", //do backend cung cấp
        responseType: "application/json", //kiểu Dữ liệu trả về do backend cung cấp
    };
    //gọi ajax = axios => nó trả về cho chúng ta là một promise
    var promise = axios(Parameter);
    //Xử lý khi request thành công
    promise.then(function (result) {
        renderCity(result.data);
    });

    function renderCity(data) {
        for (const x of data) {
            citis.options[citis.options.length] = new Option(x.Name, x.Name);
        }
        // function renderCity(data) {
        //     for (const x of data) {
        //         const option = new Option(x.Name, x.Name); // Tạo một thẻ <option>
        //         if (x.isSelected) {
        //             option.selected = true; // Đặt trạng thái chọn cho thẻ <option>
        //         }
        //         citis.options[citis.options.length] = option; // Thêm thẻ <option> vào dropdown
        //     }
        // }

        citis.addEventListener('change', function () {
            const selectedOption = citis.options[citis.selectedIndex]; // Lấy option mà người dùng chọn

            // Thiết lập thuộc tính selected cho option được chọn
            selectedOption.setAttribute('selected', 'selected');

            // Duyệt qua tất cả các option khác và gỡ bỏ thuộc tính selected
            for (const option of citis.options) {
                if (option !== selectedOption) {
                    option.removeAttribute('selected');
                }
            }
        });
        // xứ lý khi thay đổi tỉnh thành thì sẽ hiển thị ra quận huyện thuộc tỉnh thành đó
        citis.onchange = function () {
            district.length = 1;
            ward.length = 1;
            if (this.value != "") {
                const result = data.filter(n => n.Name === this.value);

                for (const k of result[0].Districts) {
                    district.options[district.options.length] = new Option(k.Name, k.Name);
                }
            }
        };

        // xứ lý khi thay đổi quận huyện thì sẽ hiển thị ra phường xã thuộc quận huyện đó
        district.onchange = function () {
            ward.length = 1;
            const dataCity = data.filter((n) => n.Name === citis.value);
            if (this.value != "") {
                const dataWards = dataCity[0].Districts.filter(n => n.Name === this.value)[0].Wards;

                for (const w of dataWards) {
                    wards.options[wards.options.length] = new Option(w.Name, w.Name);
                }
            }
        };
    }
</script>
<script>
    // Lấy tham chiếu đến thẻ input radio và thẻ button
    const radioInput = document.getElementById('customControlValidation2');
    const buttonElement = document.getElementById('btnaddress'); // Thay 'yourButtonId' bằng ID thực tế của thẻ button

    // Thêm sự kiện 'change' cho thẻ input radio
    radioInput.addEventListener('change', function () {
        // Kiểm tra nếu radio đã được chọn
        if (radioInput.checked) {
            // Bỏ tắt tính năng disable của thẻ button
            buttonElement.disabled = false;
        } else {
            // Nếu radio không được chọn, ẩn thẻ button
            buttonElement.style.display = 'none';
        }
    });
</script>

<script>
    document.getElementById('register-form').addEventListener('submit', function (event) {
        var username = document.getElementsByName('name')[0].value;
        var phone = document.getElementsByName('Phone_number')[0].value;
        // var password = document.getElementsByName('password')[0].value;
        // var name = document.getElementsByName('name')[0].value;
        // var address = document.getElementsByName('address')[0].value;
        // var email = document.getElementsByName('email')[0].value;
        // var phone = document.getElementsByName('phone')[0].value;

        var isValid = true;

        // Validate each field
        if (username === '') {
            document.getElementById('username-error').innerText = 'Vui lòng nhập họ tên người nhận.';
            isValid = false;
        } else {
            document.getElementById('username-error').innerText = '';
        }

        if (username === '') {
            document.getElementById('phone-error').innerText = 'Vui lòng nhập số điện thoại.';
            isValid = false;
        } else {
            document.getElementById('phone-error').innerText = '';
        }

        if (username === '') {
            document.getElementById('address-error').innerText = 'Vui lòng nhập đầy đủ địa chỉ.';
            isValid = false;
        } else {
            document.getElementById('address-error').innerText = '';
        }
        if (username === '') {
            document.getElementById('detail-error').innerText = 'Vui lòng nhập địa chỉ cụ thể (Thôn/Xóm,tên đường,số nhà,...).';
            isValid = false;
        } else {
            document.getElementById('detail-error').innerText = '';
        }

        // Prevent form submission if there are errors
        if (!isValid) {
            event.preventDefault();
        }
    });
</script>