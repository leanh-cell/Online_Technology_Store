<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="m-auto mt-5 mb-5 "
     style="max-width: 1200px; border-radius: 20px; padding: 20px; box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px, rgba(0, 0, 0, 0.1) 0px 2px 4px 0px, rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
    <div class="row">
        <div class="col-sm-3">
            <ul class="list-group">
                <a style="text-decoration: none;border-top-left-radius: 12px;border-top-right-radius: 12px;"
                   href="/userinfo">
                    <li style="font-weight: 500;" class="list-group-item d-flex justify-content-between align-items-center">
                        Thông tin cá nhân
                    </li>
                </a>
                <a style="text-decoration: none;" href="/user-order">
                    <li style="font-weight: 500;" class="list-group-item d-flex justify-content-between align-items-center">
                        Đơn hàng
                    </li>
                </a>
                <a style="text-decoration: none;border-bottom-left-radius: 12px;border-bottom-right-radius: 12px;" href="">
                    <li style="background-color: aquamarine;
                        background-color: rgb(242, 223, 16); font-weight: 500;"
                        class="list-group-item d-flex justify-content-between align-items-center">
                        Danh sách Địa chỉ
                    </li>
                </a>
            </ul>
        </div>
        <c:if test="${deliveryAddress != null}">
            <div class="col-sm-9">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Tỉnh/Thành Phố</th>
                        <th scope="col">Quận/Huyện</th>
                        <th scope="col">Đường/Phố</th>
                        <th scope="col">Trạng thái</th>
                            <%--          <th scope="col">Chi tiết</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${deliveryAddress}" var="dla">
                        <tr>
                            <th scope="row">${dla.province}</th>
                            <td>${dla.district}</td>
                            <td>${dla.detail}</td>
                            <td><c:choose>
                                <c:when test="${dla.isUse == 0}"><span
                                        style="color: blue; font-style: italic;">Mặc Định</span></c:when>
                                <c:when test="${dla.isUse == 1}"><span
                                        style="color: blue; font-style: italic;"></span></c:when>
                            </c:choose></td>

                                <%--            <td><a href="/user-order-details?idorder=${order.id}"--%>
                                <%--                   class="btn btn-primary">Chi tiết</a> <c:if--%>
                                <%--                    test="${order.status=='X'}">--%>
                                <%--              <a href="/cancelorder?id=${order.id}"--%>
                                <%--                 class="btn btn-outline-danger">Hủy</a>--%>
                                <%--            </c:if></td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="/add-new-address"
                   class="btn btn-outline-success">
                    Thêm địa chỉ
                </a>
            </div>
<%--            <div class="col-sm-2" style="margin-left: inherit;">--%>
<%--                <a href="/add-new-address"--%>
<%--                   class="btn btn-outline-success">--%>
<%--                    Thêm địa chỉ--%>
<%--                </a>--%>
<%--            </div>--%>
        </c:if>
        <c:if test="${not empty notfound}"> ${notfound}</c:if>
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