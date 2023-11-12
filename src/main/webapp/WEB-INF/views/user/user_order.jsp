<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	.active {
		/*background-color: #226dc4; !* Màu sắc của nút khi được chọn *!*/
		color: #CF5763; /* Màu văn bản khi được chọn */
	}
	.active a {
		color: #CF5763;
	}
	.active a div{
		border: #CF5763 solid;
	}
</style>

<div class="m-auto mt-5 mb-5 "
	style="max-width: 1200px; border-radius: 20px; padding: 20px; box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px, rgba(0, 0, 0, 0.1) 0px 2px 4px 0px, rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;">
	<div class="row">
		<div class="col-sm-3">
			<ul class="list-group">
				<a style="text-decoration: none;border-top-left-radius: 12px;border-top-right-radius: 12px;" href="/userinfo">
					<li style="font-weight: 500;"
					class="list-group-item d-flex justify-content-between align-items-center">
						Thông tin cá nhân</li>
				</a>
				<a style="text-decoration: none;" href="">
					<li
					style="background-color: aquamarine; background-color: rgb(242, 223, 16); font-weight: 500;"
					class="list-group-item d-flex justify-content-between align-items-center">
						Đơn hàng</li>
				</a>
				<a style="text-decoration: none;border-bottom-left-radius: 12px;border-bottom-right-radius: 12px;" href="/user-delivery-address">
					<li style="font-weight: 500;" class="list-group-item d-flex justify-content-between align-items-center">
						Danh sách Địa chỉ
					</li>
				</a>
			</ul>
		</div>
		<div class="col-sm-9">

			<c:if test="${not empty informationOrder}">
				<div class="row mb-3">
					<a style="text-decoration: none;color:${active == 'a' || active == null ? '#CF5763' : '#226dc4'};" class="col menu-button" href="/user-order?status=&active=a">
						<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: ${active == 'a' || active == null ? '#CF5763' : '#226dc4'} solid">
							<h5>
								Tất cả đơn hàng
							</h5>
						</div>
					</a>
					<a style="text-decoration: none;color:${active == 'x' ? '#CF5763' : '#226dc4'};" class="col menu-button" aria-valuenow="x" href="/user-order?status=X&active=x">
						<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: ${active == 'x' ? '#CF5763' : '#226dc4'} solid">
							<h5>
								Đang xử lý
							</h5>
						</div>
					</a>
					<a style="text-decoration: none;color:${active == 'n' ? '#CF5763' : '#226dc4'};" class="col menu-button" aria-valuenow="n" href="/user-order?status=N&active=n">
						<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: ${active == 'n' ? '#CF5763' : '#226dc4'} solid">
							<h5>
								Đã nhận
							</h5>
						</div>
					</a>
					<a style="text-decoration: none;color:${active == 'h' ? '#CF5763' : '#226dc4'};" class="col menu-button" aria-valuenow="h" href="/user-order?status=H&active=h">
						<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: ${active == 'h' ? '#CF5763' : '#226dc4'} solid">
							<h5>
								Đã huỷ
							</h5>
						</div>
					</a>
				</div>
				<table class="table">
					<thead>
					<tr>
						<th scope="col">Mã đơn hàng</th>
						<th scope="col">Thời gian mua</th>
						<th scope="col">Tổng tiền</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Chi tiết</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${informationOrder.content}" var="order">
						<tr>

							<th scope="row">${order.orderCode}</th>
							<td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy" /></td>
							<td><fmt:formatNumber value="${order.total}"
												  pattern="###,###,###.##" />đ</td>
							<td><c:choose>
								<c:when test="${order.status == 'X'}"><span style="color: blue; font-style: italic;">Đang xử lí</span></c:when>
								<c:when test="${order.status == 'N'}"><span style="color: green; font-style: italic;">Đã nhận hàng</span></c:when>
								<c:when test="${order.status == 'H'}"><span style="color: red; font-style: italic;">Đã hủy</span></c:when>
							</c:choose></td>

							<td><a href="/user-order-details?idorder=${order.id}"
								   class="btn btn-primary">Chi tiết</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<nav aria-label="Page navigation" class="mt-5">
						<ul class="pagination" id="pagination"></ul>
					</nav>
					<form id="sumitForm" action="/user-order" method="get">
						<input id="page" name="pg" type="hidden">
					</form>
				</div>
			</c:if>
			<c:if test="${empty informationOrder}">
				<h4>
					Bạn chưa có đơn hàng nào hãy vào trang chủ và đặt hàng để có thể xem thông tin
				</h4>
			</c:if>
<%--			<div class="row mb-3">--%>
<%--				<a style="text-decoration: none;color: #226dc4;" class="col menu-button" href="/user-order?status=">--%>
<%--					<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: #226dc4 solid">--%>
<%--						<h5>--%>
<%--							Tất cả đơn hàng--%>
<%--						</h5>--%>
<%--					</div>--%>
<%--				</a>--%>
<%--				<a style="text-decoration: none;color: #226dc4;" class="col menu-button" href="/user-order?status=X">--%>
<%--					<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: #226dc4 solid">--%>
<%--						<h5>--%>
<%--							Đang xử lý--%>
<%--						</h5>--%>
<%--					</div>--%>
<%--				</a>--%>
<%--				<a style="text-decoration: none;color: #226dc4;" class="col menu-button" href="/user-order?status=N">--%>
<%--					<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: #226dc4 solid">--%>
<%--						<h5>--%>
<%--							Đã nhận--%>
<%--						</h5>--%>
<%--					</div>--%>
<%--				</a>--%>
<%--				<a style="text-decoration: none;color: #226dc4;" class="col menu-button" href="/user-order?status=H">--%>
<%--					<div style="text-align: center;padding-top: 10px;padding-bottom: 10px;border-radius: 8px;border: #226dc4 solid">--%>
<%--						<h5>--%>
<%--							Đã huỷ--%>
<%--						</h5>--%>
<%--					</div>--%>
<%--				</a>--%>
<%--			</div>--%>
<%--			<table class="table">--%>
<%--				<thead>--%>
<%--					<tr>--%>
<%--						<th scope="col">Mã đơn hàng</th>--%>
<%--						<th scope="col">Thời gian mua</th>--%>
<%--						<th scope="col">Tổng tiền</th>--%>
<%--						<th scope="col">Trạng thái</th>--%>
<%--						<th scope="col">Chi tiết</th>--%>
<%--					</tr>--%>
<%--				</thead>--%>
<%--				<tbody>--%>
<%--					<c:forEach items="${informationOrder.content}" var="order">--%>
<%--						<tr>--%>
<%--						--%>
<%--							<th scope="row">${order.orderCode}</th>--%>
<%--							<td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy" /></td>--%>
<%--							<td><fmt:formatNumber value="${order.total}"--%>
<%--									pattern="###,###,###.##" />đ</td>--%>
<%--							<td><c:choose>--%>
<%--									<c:when test="${order.status == 'X'}"><span style="color: blue; font-style: italic;">Đang xử lí</span></c:when>--%>
<%--									<c:when test="${order.status == 'N'}"><span style="color: green; font-style: italic;">Đã nhận hàng</span></c:when>--%>
<%--									<c:when test="${order.status == 'H'}"><span style="color: red; font-style: italic;">Đã hủy</span></c:when>--%>
<%--								</c:choose></td>--%>

<%--							<td><a href="/user-order-details?idorder=${order.id}"--%>
<%--								class="btn btn-primary">Chi tiết</a></td>--%>
<%--						</tr>--%>
<%--					</c:forEach>--%>
<%--				</tbody>--%>
<%--			</table>--%>
<%--			<div class="row">--%>
<%--				<nav aria-label="Page navigation" class="mt-5">--%>
<%--					<ul class="pagination" id="pagination"></ul>--%>
<%--				</nav>--%>
<%--				<form id="sumitForm" action="/user-order" method="get">--%>
<%--					<input id="page" name="p" type="hidden">--%>
<%--				</form>--%>
<%--			</div>--%>
		</div>
	</div>
<%--	<h6 class="mt-3"></h6>--%>
</div>

<script>
	<%--var totalPages = ${listProduct.totalPages}; // Tổng số trang--%>
	<%--var itemsPerPage = ${listProduct.size}; // Số lượng sản phẩm trên mỗi trang--%>
	<%--var visiblePages = Math.min(totalPages, Math.ceil(totalPages / itemsPerPage));--%>

	$(function () {
		<%--console.log("Giá trị của x là: " + ${order.totalPages});--%>
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: ${informationOrder.totalPages},
			visiblePages: 5,
			startPage: ${informationOrder.number+1},
			onPageClick: function (event, page) {
				console.info(page)

				if(page!=${informationOrder.number+1}){
					$('#page').val(parseInt(page-1));
					$('#sumitForm').submit();
				}
			}
		}).on('page', function (event, page) {
			console.info(page + ' (from event listening)');
		});
	});
</script>

<script>
<c:if test="${not empty sessionScope.cancalorder}">
$(document).ready(function() {
	$.toast({
		text : "${cancalorder}", // Text that is to be shown in the toast
		heading : 'Thông báo!', // Optional heading to be shown on the toast
		icon : 'success', // Type of toast icon
		showHideTransition : 'fade', // fade, slide or plain
		allowToastClose : true, // Boolean value true or false
		hideAfter : 3000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
		stack : false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
		position : 'top-right', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
		textAlign : 'left', // Text alignment i.e. left, right or center
		loader : true, // Whether to show loader or not. True by default
		loaderBg : '#9EC600', // Background color of the toast loader
		beforeShow : function() {
		}, // will be triggered before the toast is shown
		afterShown : function() {
		}, // will be triggered after the toat has been shown
		beforeHide : function() {
		}, // will be triggered before the toast gets hidden
		afterHidden : function() {
		} // will be triggered after the toast has been hidden
	});

});
<%
session.removeAttribute("cancalorder");
%>
</c:if>
</script>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		// Lấy tất cả các nút menu
		var menuButtons = document.querySelectorAll(".menu-button");

		// Xử lý sự kiện khi người dùng nhấn vào nút
		menuButtons.forEach(function(button) {
			button.addEventListener("click", function() {
				// Bỏ lớp "active" khỏi tất cả các nút menu
				menuButtons.forEach(function(btn) {
					btn.classList.remove("active");
				});

				// Thêm lớp "active" vào nút được chọn
				button.classList.add("active");
			});
		});
	});
</script>
