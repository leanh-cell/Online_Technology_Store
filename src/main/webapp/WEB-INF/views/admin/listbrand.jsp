<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
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
			style="box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px; border-radius: 20px;">
			<div class="row">
				<a href="/admin/form-insert-brand"  class="col-lg-1 btn btn-primary mb-4">+</a>

				<form class="col-sm-7 d-flex mb-3" action="/admin/list-brand" method="get">
					<input name="keyword" style="width: 300px;" class="form-control me-2" type="search" placeholder="Nhập tên nhà sản xuất" aria-label="Search">
					<button class="btn btn-outline-success ml-3" type="submit">Tìm kiếm</button>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">TÊN NHÀ SẢN XUẤT</th>
						<th scope="col">ẢNH</th>
						<th scope="col">Edit</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="brand" items="${brand.content}" >
					<tr>
						<th scope="row">${brand.id}</th>
						<td>${brand.name}</td>
						<td><img src="/image/${brand.img}" style="width: 100px;" alt=""></td>
						<td>
							<a class="btn btn-primary" href="/admin/form-update-brand?id=${brand.id}">Edit</a>
							<a class="btn btn-danger" href="/admin/delete-brand?id=${brand.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation" class="mt-5">
				<ul class="pagination" id="pagination"></ul>
			</nav>
			<form id="sumitForm" action="/admin/list-brand" method="get">
				<input id="page" name="p" type="hidden">
			</form>
		</div>

	</div>
</section>
<script>
	<%--var totalPages = ${listProduct.totalPages}; // Tổng số trang--%>
	<%--var itemsPerPage = ${listProduct.size}; // Số lượng sản phẩm trên mỗi trang--%>
	<%--var visiblePages = Math.min(totalPages, Math.ceil(totalPages / itemsPerPage));--%>

	$(function () {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: ${brand.totalPages},
			visiblePages: 5,
			startPage: ${brand.number+1},
			onPageClick: function (event, page) {
				console.info(page)

				if(page!=${brand.number+1}){
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
	<c:if test="${success != null}">
	$(document).ready(function() {
		$.toast({
			text : "${success}.", // Text that is to be shown in the toast
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

	</c:if>
</script>
