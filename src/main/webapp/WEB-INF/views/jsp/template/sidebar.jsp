<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
    <div class="logopanel">
        <h1>
            <a href="<c:url value="/" />"></a>
        </h1>
    </div>
    <div class="sidebar-inner">
        <ul class="nav nav-sidebar">
            <% String tmp = request.getAttribute("active").toString(); %>
            <li class="<%=(tmp.equalsIgnoreCase("main")) ? "nav-active active":"" %>"><a href="<c:url value="/" />"><i class="icon-home"></i><span>Dashboard</span></a></li>
            <li class="<%=(tmp.equalsIgnoreCase("recordNew")) ? "nav-active active":"" %>"><a href="<c:url value="/record/new" />"><i class="icon-note"></i><span>New Record</span></a></li>
            <li class="<%=(tmp.equalsIgnoreCase("recordShow")) ? "nav-active active":"" %>"><a href="<c:url value="/record/search" />"><i class="icon-clock"></i><span>Search Records</span></a></li>
        </ul>
        <div class="sidebar-footer clearfix">
            <a class="pull-left footer-settings" href="#" data-rel="tooltip" data-placement="top" data-original-title="Settings">
                <i class="icon-settings"></i></a>
            <a class="pull-left toggle_fullscreen" href="#" data-rel="tooltip" data-placement="top" data-original-title="Fullscreen">
                <i class="icon-size-fullscreen"></i></a>
            <a class="pull-left" href="#" data-rel="tooltip" data-placement="top" data-original-title="Lockscreen">
                <i class="icon-lock"></i></a>
            <a class="pull-left btn-effect" href="#" data-modal="modal-1" data-rel="tooltip" data-placement="top" data-original-title="Logout">
                <i class="icon-power"></i></a>
        </div>
    </div>
</div>