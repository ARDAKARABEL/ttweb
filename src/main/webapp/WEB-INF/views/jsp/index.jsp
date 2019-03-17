<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/header.jsp" />
<body class="sidebar-top fixed-topbar fixed-sidebar theme-sdtl color-default">
<![endif]-->
<section>
    <!-- BEGIN SIDEBAR -->
    <jsp:include page="template/sidebar.jsp" />
    <!-- END SIDEBAR -->
    <div class="main-content">
        <!-- BEGIN TOPBAR -->
        <jsp:include page="template/topbar.jsp" />
        <!-- END TOPBAR -->
        <!-- BEGIN PAGE CONTENT -->
        <jsp:include page='<%=request.getAttribute("view").toString()%>'/>
        <!-- END PAGE CONTENT -->
    </div>
    <!-- END MAIN CONTENT -->
    <!-- BEGIN BUILDER -->
    <jsp:include page="template/builder.jsp" />
    <!-- END BUILDER -->
</section>
<!-- BEGIN PRELOADER -->
<div class="loader-overlay">
    <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>
<!-- END PRELOADER -->
<jsp:include page="template/footer.jsp" />
</body>
</html>