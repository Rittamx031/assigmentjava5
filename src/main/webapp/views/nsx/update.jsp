<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="utf-8" language="java" %>
<html lang="en">
<head>
    <title>Update</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <style>
		.errors {color:red}
	</style>
</head>
<body>
        <aside id="sidebar" class="sidebar">
                <ul class="sidebar-nav" id="sidebar-nav">
                  <li class="nav-item">
                    <a class="nav-link " href="index.html">
                      <i class="bi bi-grid"></i>
                      <span>Home</span>
                    </a>
                  </li><!-- End Dashboard Nav -->
                  <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                      <i class="bi bi-menu-button-wide"></i><span>Quản Lý</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <!-- BEGIN Quản lý nav -->
                    <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                      <li>
                        <a href="components-alerts.html">
                          <i class="bi bi-circle"></i><span>Sản Phẩm</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-accordion.html">
                          <i class="bi bi-circle"></i><span>Dòng Sản Phẩm</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-modal.html">
                          <i class="bi bi-circle"></i><span>Chi Tiết Sản Phẩm</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-badges.html">
                          <i class="bi bi-circle"></i><span>Cửa Hàng</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-breadcrumbs.html">
                          <i class="bi bi-circle"></i><span>Nhà Sản Xuất</span>
                        </a>
                      </li>
                      <li>
                        <a href="/nhanvien/index">
                          <i class="bi bi-circle"></i><span>Nhân Viên</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-carousel.html">
                          <i class="bi bi-circle"></i><span>Màu Sắc</span>
                        </a>
                      </li>
                      <li>
                        <a href="components-list-group.html">
                          <i class="bi bi-circle"></i><span>Chức Vụ</span>
                        </a>
                      </li>
                    </ul>
                    <!-- END Quản lý nav -->
                  </li><!-- End Components Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                      <i class="bi bi-journal-text"></i><span>Khách Hàng</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                      <li>
                        <a href="forms-elements.html">
                          <i class="bi bi-circle"></i><span>Khách Hàng</span>
                        </a>
                      </li>
                    </ul>
                  </li><!-- End Forms Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                      <i class="bi bi-layout-text-window-reverse"></i><span>Doanh Thu</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                      <!-- <li>
                        <a href="tables-general.html">
                          <i class="bi bi-circle"></i><span>General Tables</span>
                        </a>
                      </li>
                      <li>
                        <a href="tables-data.html">
                          <i class="bi bi-circle"></i><span>Data Tables</span>
                        </a>
                      </li> -->
                    </ul>
                  </li><!-- End Tables Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                      <i class="bi bi-bar-chart"></i><span>Quản lý Bán Hàng</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                      <li>
                        <a href="charts-chartjs.html">
                          <i class="bi bi-circle"></i><span>Hóa Đơn</span>
                        </a>
                      </li>
                      <li>
                        <a href="charts-apexcharts.html">
                          <i class="bi bi-circle"></i><span>Hóa Đơn Chi Tiết</span>
                        </a>
                      </li>
                    </ul>
                  </li><!-- End Charts Nav -->
            
                  <li class="nav-heading">Pages</li>
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="users-profile.html">
                      <i class="bi bi-person"></i>
                      <span>Profile</span>
                    </a>
                  </li><!-- End Profile Page Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-faq.html">
                      <i class="bi bi-question-circle"></i>
                      <span>F.A.Q</span>
                    </a>
                  </li><!-- End F.A.Q Page Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-contact.html">
                      <i class="bi bi-envelope"></i>
                      <span>Contact</span>
                    </a>
                  </li><!-- End Contact Page Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-register.html">
                      <i class="bi bi-card-list"></i>
                      <span>Register</span>
                    </a>
                  </li><!-- End Register Page Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-login.html">
                      <i class="bi bi-box-arrow-in-right"></i>
                      <span>Login</span>
                    </a>
                  </li><!-- End Login Page Nav -->
            
                  <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-error-404.html">
                      <i class="bi bi-dash-circle"></i>
                      <span>Error 404</span>
                    </a>
                  </li><!-- End Error 404 Page Nav -->
                </ul>
              </aside><!-- End Sidebar-->
            
        <!-- form store new cuahang -->
<!-- <form:form action="/cuahang/update" method="post" modelAttribute="cuahang">
    <lable>Ten Cua Hang: </lable>
    <form:errors path="id" cssClass="errors"/>
    <form:input type="hidden"  path="id"/>
    <form:input type="text"  path="ten"/>
    <form:errors path="ten" cssClass="errors"/>
    <br>
    <lable>Mã Cua Hang: </lable>
    <form:input type="text"  path="Ma"/>
    <form:errors path="Ma" cssClass="errors"/>
    <br>
    <lable>Địa chỉ: </lable>
    <form:input type="text"  path="diaChi"/>
    <form:errors path="diaChi" cssClass="errors"/>
    <br>
    <lable>Thành phố: </lable>
    <form:input type="text"  path="thanhPho"/>
    <form:errors path="thanhPho" cssClass="errors"/>
    <br>
    <lable>Quốc gia: </lable>
    <form:input type="text"  path="quocGia"/>
    <form:errors path="quocGia" cssClass="errors"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form> -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"
></script>
</body>
</html>