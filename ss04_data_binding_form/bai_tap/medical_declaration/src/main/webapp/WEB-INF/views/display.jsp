<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link rel="stylesheet" href="bootstrap-5.0.2/css/bootstrap.min.css">
</head>
<body>
<h2 class="text-center">Danh sách tờ khai y tế</h2>
<h4>${message}</h4>
<table class="table table-light">
    <tr class="bg-primary">
        <th>STT</th>
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc gia</th>
        <th>Số CMND</th>
        <th>Phương tiện</th>
        <th>Số hiệu</th>
        <th>Số chỗ ngồi</th>
        <th>Ngày khởi hành</th>
        <th>Tháng khởi hành</th>
        <th>Năm khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Tháng kết thúc</th>
        <th>Năm kết thúc</th>
        <th>Thông tin di chuyển</th>
        <th>Chỉnh sửa</th>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="medical" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${medical.name}</td>
            <td>${medical.birthDay}</td>
            <td>${medical.gender}</td>
            <td>${medical.country}</td>
            <td>${medical.identity}</td>
            <td>${medical.vehicle}</td>
            <td>${medical.numberVehicle}</td>
            <td>${medical.numberSeat}</td>
            <td>${medical.dayStart}</td>
            <td>${medical.monthStart}</td>
            <td>${medical.yearStart}</td>
            <td>${medical.dayEnd}</td>
            <td>${medical.monthEnd}</td>
            <td>${medical.yearEnd}</td>
            <td>${medical.informationMove}</td>
            <td>
                <a href="/update?identity=${medical.identity}">
                    <button class="btn btn-info">
                        Sửa
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="container-fluid">
    <div class="row">
        <a href="/create">
            <button class="btn btn-info">
                Thêm mới
            </button>
        </a>
    </div>

</div>
<script src="bootstrap-5.0.2/js/bootstrap.min.js"></script>
</body>
</html>
