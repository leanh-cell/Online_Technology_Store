<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="m-auto mt-5 mb-5 "
     style="max-width: 1200px; border-radius: 20px; padding: 20px; box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px, rgba(0, 0, 0, 0.1) 0px 2px 4px 0px, rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
    <div class="row">
        <div class="col-sm-3">
            <ul class="list-group">
                <a style="text-decoration: none;" href="/userinfo">
                    <li style="font-weight: 500;"
                        class="list-group-item d-flex justify-content-between align-items-center">
                        Thông tin cá nhân
                    </li>
                </a>
                <a style="text-decoration: none;" href="/user-order">
                    <li
                            style="font-weight: 500;"
                            class="list-group-item d-flex justify-content-between align-items-center">
                        Đơn hàng
                    </li>
                </a>
                <a style="text-decoration: none;" href="">
                    <li style="background-color: aquamarine; background-color: rgb(242, 223, 16); font-weight: 500;"
                        class="list-group-item d-flex justify-content-between align-items-center">
                        Danh sách Địa chỉ
                    </li>
                </a>
            </ul>
        </div>
        <div class="box">
            <h3 class="heading">New Address !!</h3>
            <form class="mb-5" action="/save-address" method="post" id="contactForm" name="contactForm" novalidate="novalidate">
                <input type="hidden" name="screen" value="addressList">
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="name" class="col-form-label">Họ và tên</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Họ và tên">
                        <p style="color: red;" id="username-error" class="error-message"></p>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="name" class="col-form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="Phone_number" id="Phone_number" placeholder="Số điện thoại">
                        <p style="color: red;" id="phone-error" class="error-message"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="email" class="col-form-label">Tỉnh/thành phố, Quận/Huyện, Phường/Xã</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="Your email address">
                        <p style="color: red;" id="address-error" class="error-message"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="message" class="col-form-label">Địa chỉ chi tiết</label>
                        <textarea class="form-control" name="message" id="message" cols="30" rows="7"></textarea>
                        <p style="color: red;" id="detail-error" class="error-message"></p>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="mb-3">
                        <div class="form-check form-check-inline">
                            <input
                                    class="form-check-input" type="radio" name="role"
                                    id="inlineRadio1" value="true" checked> <label
                                class="form-check-label" for="inlineRadio1">Mặc định</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input
                                    class="form-check-input" type="radio" name="role"
                                    id="inlineRadio2" value="false"> <label
                                class="form-check-label" for="inlineRadio2">Địa chỉ phụ</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <input type="submit" value="Send Message" class="btn btn-block btn-primary rounded-0 py-2 px-4">
                        <span class="submitting"></span>
                    </div>
                </div>
            </form>
        </div>
<%--    </form>--%>

        </div>
    </div>
    <h6 class="mt-3"></h6>
</div>
<%--<script>--%>
<%--  <c:if test="${not empty sessionScope.cancalorder}">--%>
<%--  $(document).ready(function() {--%>
<%--    $.toast({--%>
<%--      text : "${cancalorder}", // Text that is to be shown in the toast--%>
<%--      heading : 'Thông báo!', // Optional heading to be shown on the toast--%>
<%--      icon : 'success', // Type of toast icon--%>
<%--      showHideTransition : 'fade', // fade, slide or plain--%>
<%--      allowToastClose : true, // Boolean value true or false--%>
<%--      hideAfter : 3000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden--%>
<%--      stack : false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time--%>
<%--      position : 'top-right', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values--%>
<%--      textAlign : 'left', // Text alignment i.e. left, right or center--%>
<%--      loader : true, // Whether to show loader or not. True by default--%>
<%--      loaderBg : '#9EC600', // Background color of the toast loader--%>
<%--      beforeShow : function() {--%>
<%--      }, // will be triggered before the toast is shown--%>
<%--      afterShown : function() {--%>
<%--      }, // will be triggered after the toat has been shown--%>
<%--      beforeHide : function() {--%>
<%--      }, // will be triggered before the toast gets hidden--%>
<%--      afterHidden : function() {--%>
<%--      } // will be triggered after the toast has been hidden--%>
<%--    });--%>

<%--  });--%>
<%--  <%--%>
<%--  session.removeAttribute("cancalorder");--%>
<%--  %>--%>
<%--  </c:if>--%>
<%--</script>--%>
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