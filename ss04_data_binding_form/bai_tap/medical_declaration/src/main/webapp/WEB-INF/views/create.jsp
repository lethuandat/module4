<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link rel="stylesheet" href="bootstrap-5.0.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row text-center mt-5">
        <h2>TỜ KHAI Y TẾ</h2>
    </div>
    <div class="row text-center mt-2">
        <h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH
            BỆNH TRUYỀN NHIỄM</h6>
    </div>
    <div class="row text-center text-danger mt-2">
        <h6>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h6>
    </div>
</div>

<div class="container-fluid mt-5">
    <form:form modelAttribute="medicalDeclaration" method="post" action="/create">
        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Họ tên (ghi chữ IN HOA) </label>
                <label class="text-danger">(*)</label>
                <form:input path="name" cssClass="form-control" required="true" pattern="[A-Z\\s]+"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-4">
                <label class="fw-bold">Năm sinh </label>
                <label class="text-danger">(*)</label>
                <form:select path="birthDay" items="${birthDay}" cssClass="form-select" required="true"/>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Giới tính </label>
                <label class="text-danger">(*)</label>
                <form:select path="gender" items="${gender}" cssClass="form-select" required="true"/>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Quốc tịch </label>
                <label class="text-danger">(*)</label>
                <form:select path="country" items="${country}" cssClass="form-select" required="true"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác </label>
                <label class="text-danger">(*)</label>
                <form:input path="identity" cssClass="form-control" required="true" pattern="[1-9]{1}[0-9]{8}"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Thông tin đi lại </label>
                <label class="text-danger">(*)</label>
                <form:radiobuttons path="vehicle" items="${vehicle}" cssClass="form-check-inline fw-bold mx-2"
                                   required="true"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-6">
                <label class="fw-bold">Số hiệu phương tiện</label>
                <form:input path="numberVehicle" cssClass="form-control" alt="VD: VN123"/>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Số ghế</label>
                <form:input path="numberSeat" cssClass="form-control"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <label class="fw-bold">Ngày khởi hành </label>
                        <label class="text-danger">(*)</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <form:select path="dayStart" items="${dayStart}" cssClass="form-select" required="true"/>
                    </div>
                    <div class="col-lg-4">
                        <form:select path="monthStart" items="${monthStart}" cssClass="form-select" required="true"/>
                    </div>
                    <div class="col-lg-4">
                        <form:select path="yearStart" items="${yearStart}" cssClass="form-select" required="true"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <label class="fw-bold">Ngày kết thúc </label>
                        <label class="text-danger">(*)</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <form:select path="dayEnd" items="${dayEnd}" cssClass="form-select" required="true"/>
                    </div>
                    <div class="col-lg-4">
                        <form:select path="monthEnd" items="${monthEnd}" cssClass="form-select" required="true"/>
                    </div>
                    <div class="col-lg-4">
                        <form:select path="yearEnd" items="${yearEnd}" cssClass="form-select" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? </label>
                <label class="text-danger">(*)</label>
                <form:input path="informationMove" cssClass="form-control" required="true"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <p class="text-danger fw-bold">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng
                    chống dịch,
                    thuộc quản lý của Ban chỉ đạo quốc gia về phòng chống dịch Covid-19</p>
                <p class="text-danger fw-bold">Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12 text-center">
                <form:button class="btn btn-success">
                    Tạo mới
                </form:button>
            </div>
        </div>
    </form:form>
</div>

</body>

<script src="bootstrap-5.0.2/js/bootstrap.min.js"></script>
</html>
