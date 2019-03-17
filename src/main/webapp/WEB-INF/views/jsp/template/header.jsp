<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="admin-themes-lab">
    <meta name="author" content="themes-lab">
    <link rel="shortcut icon" href="/assets/global/images/favicon.png" type="image/png">
    <title>ETS | ${siteTitle}</title>
    <link href="/assets/global/css/style.css" rel="stylesheet">
    <link href="/assets/global/css/theme.css" rel="stylesheet">
    <link href="/assets/global/css/ui.css" rel="stylesheet">
    <link href="/assets/admin/layout4/css/layout.css" rel="stylesheet">
    <link href="/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">
    <link href="/assets/global/plugins/datatables/dataTables.min.css" rel="stylesheet">
    <!-- BEGIN PAGE STYLE -->
    <c:forEach items="${siteCssList}" var="sCss">
        <link href="${sCss}" rel="stylesheet">
    </c:forEach>
    <!-- END PAGE STYLE -->
    <script src="/assets/global/plugins/jquery/jquery-3.1.0.min.js"></script>
    <script src="/assets/global/plugins/jquery/jquery-migrate-3.0.0.min.js"></script>
    <script src="/assets/global/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="/assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<!-- LAYOUT: Apply "submenu-hover" class to body element to have sidebar submenu show on mouse hover -->
<!-- LAYOUT: Apply "sidebar-collapsed" class to body element to have collapsed sidebar -->
<!-- LAYOUT: Apply "sidebar-top" class to body element to have sidebar on top of the page -->
<!-- LAYOUT: Apply "sidebar-hover" class to body element to show sidebar only when your mouse is on left / right corner -->
<!-- LAYOUT: Apply "submenu-hover" class to body element to show sidebar submenu on mouse hover -->
<!-- LAYOUT: Apply "fixed-sidebar" class to body to have fixed sidebar -->
<!-- LAYOUT: Apply "fixed-topbar" class to body to have fixed topbar -->
<!-- LAYOUT: Apply "rtl" class to body to put the sidebar on the right side -->
<!-- LAYOUT: Apply "boxed" class to body to have your page with 1200px max width -->

<!-- THEME STYLE: Apply "theme-sdtl" for Sidebar Dark / Topbar Light -->
<!-- THEME STYLE: Apply  "theme sdtd" for Sidebar Dark / Topbar Dark -->
<!-- THEME STYLE: Apply "theme sltd" for Sidebar Light / Topbar Dark -->
<!-- THEME STYLE: Apply "theme sltl" for Sidebar Light / Topbar Light -->

<!-- THEME COLOR: Apply "color-default" for dark color: #2B2E33 -->
<!-- THEME COLOR: Apply "color-primary" for primary color: #319DB5 -->
<!-- THEME COLOR: Apply "color-red" for red color: #C9625F -->
<!-- THEME COLOR: Apply "color-green" for green color: #18A689 -->
<!-- THEME COLOR: Apply "color-orange" for orange color: #B66D39 -->
<!-- THEME COLOR: Apply "color-purple" for purple color: #6E62B5 -->
<!-- THEME COLOR: Apply "color-blue" for blue color: #4A89DC -->
<!-- BEGIN BODY -->