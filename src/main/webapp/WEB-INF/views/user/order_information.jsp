<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="max-width: 1200px;" class="m-auto pt-5 pb-5">
    <p class="text-center" style="font-size: 23px; font-weight: bold;">GIỎ HÀNG</p>
    <div class="m-auto" style="width: 30%; height: 4px; background-color: black;"></div>
</div>

<div style="max-width: 1200px;" class="m-auto">

    <!-- product -->
    <form action="/saveorder" method="post">
        <div class="row mb-5">
            <div class="col-sm-10 p-4"
                 style="margin: 0px auto;box-shadow:rgba(255, 255, 255, 0.05) 0px 0px 0px 1px,rgba(0, 0, 0, 0.1) 0px 2px 4px 0px,
                 rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
                <h4 style="text-align: center; font-weight: bold;">THÔNG TIN ĐƠN HÀNG</h4>

                <%--                <div class="row">--%>
                <%--                    <div class="col-sm-6">--%>
                <%--                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
                <%--                                data-bs-target="#exampleModalLong">--%>
                <%--                            Launch demo modal--%>
                <%--                        </button>--%>
                <%--                        <div class="modal fade" id="exampleModalLong" tabindex="-1"--%>
                <%--                             aria-labelledby="exampleModalLongTitle" style="display: none;" aria-hidden="true">--%>
                <%--                            <div class="modal-dialog">--%>
                <%--                                <div class="modal-content">--%>
                <%--                                    <div class="modal-header">--%>
                <%--                                        <h1 class="modal-title fs-5" id="exampleModalLongTitle">Chọn địa chỉ bạn muốn--%>
                <%--                                            giao hàng</h1>--%>
                <%--                                        <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
                <%--                                                aria-label="Close"></button>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="modal-body" style="min-height: 500px">--%>
                <%--                                        <div class="form-group">--%>

                <%--                                        </div>--%>
                <%--                                    </div>--%>
                <%--                                    <div class="modal-footer">--%>
                <%--                                    </div>--%>
                <%--                                </div>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>
            <div class="col-sm-10 p-4"
                 style="margin: 0px auto;box-shadow:rgba(255, 255, 255, 0.05) 0px 0px 0px 1px,rgba(0, 0, 0, 0.1) 0px 2px 4px 0px,
                 rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
                <div class="row">
                    <i class="material-icons" style="font-size:48px;color:red">place</i>
                    <h4>Địa chỉ nhận hàng</h4>
                </div>
                <h6>${addressSelect.name}</h6>
                <h6>${addressSelect.phone}</h6>
                <h6>${addressSelect.country},${addressSelect.province},${addressSelect.district}</h6>
                <h6>${addressSelect.detail}</h6>
            </div>
            <div class="col-sm-10 p-4"
                 style="margin: 0px auto;box-shadow:
                 rgba(255, 255, 255, 0.05) 0px 0px 0px 1px,
                 rgba(0, 0, 0, 0.1) 0px 2px 4px 0px,
                 rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ẢNH</th>
                        <th>TÊN SẢN PHẨM</th>
                        <th>GIÁ</th>
                        <th>SỐ LƯỢNG</th>
                        <th>TỔNG</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${viewProduct}" var="productCart">
                        <form action="/sumQty">
                            <input type="hidden" name="id" class="idproduct"
                                   value="${productCart.id}">
                            <tr>
                                <th><img src="/image/${productCart.img}"
                                         style="width: 100px;" alt=""> <br>
                                </th>
                                <td>${productCart.name}</td>
                                <td><fmt:formatNumber value="${productCart.price}"
                                                      pattern="###,###,###.##"/>đ
                                </td>
                                <td>
                                    <div style="width: 120px; margin: 0 auto;">
                                            <%--                                        <button type="submit" name="${productCart.id}"--%>
                                            <%--                                                class="input-group-text decrease-quantity btnTru"--%>
                                            <%--                                                style="border-radius: 0;">---%>
                                            <%--                                        </button>--%>
                                        <h6>${productCart.qty}</h6>
                                            <%--                                        <button onclick="getValue(this)" name="${productCart.id}"--%>
                                            <%--                                                type="submit" style="border-radius: 0;"--%>
                                            <%--                                                class="input-group-text increase-quantity btnCong">+--%>
                                            <%--                                        </button>--%>
                                    </div>
                                </td>
                                <td><fmt:formatNumber
                                        value="${productCart.price * productCart.qty}"
                                        pattern="###,###,###.##"/>đ
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-10 p-4"
                 style="margin: 0px auto;
                 box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px, rgba(0, 0, 0, 0.1) 0px 2px 4px 0px, rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
                <div class="row">
                    <div class="col-sm-6">
                        <h6>Tạm tính:</h6>
                    </div>
                    <div class="col-sm-6 text-right">
                        <h6 style="text-align: right; color:red" ;><fmt:formatNumber value="${totalCart}"
                                                                                     pattern="###,###,###.##"/>
                            đ</h6>
                    </div>
                    <div class="col-sm-6">
                        <h6 style=color:red;">Giảm giá:</h6>
                    </div>
                    <div class="col-sm-6 text-right">
                        <h6 style="text-align: right;">0</h6>
                    </div>
                    <hr>
                    <div class="col-sm-6">
                        <h3>TỔNG CỘNG:</h3>
                    </div>
                    <div class="col-sm-6 text-right">
                        <h3 style="text-align: right; color:red"><fmt:formatNumber value="${totalCart}"
                                                                                   pattern="###,###,###.##"/>
                            đ</h3>
                    </div>
                    <input type="hidden" value="${addressSelect.id}" name="idAddress">
                    <button style="background-color: rgb(205, 192, 50); border-radius: 0px; color: white; font-weight: bold;"
                            type="submit" class="btn py-2" value="">
                        Đặt hàng
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

<script>
    function updateSelectedAddress(addressId) {
        document.getElementById('selectedAddress').value = addressId;
    }
</script>