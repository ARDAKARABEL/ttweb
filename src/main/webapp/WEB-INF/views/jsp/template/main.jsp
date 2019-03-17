<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function () {
        oTable = $('#dashboardTable').dataTable({
            "format": "DD.MM.YYYY HH:mm",
            "aaSorting": [[1, 'desc']]
        });
    });
</script>
<div class="page-content">
    <div class="header">
        <h2><strong>Welcome to</strong> Employee Tracking System</h2>
        <div class="breadcrumb-wrapper">
            <ol class="breadcrumb">
                <li>ETS</li>
                <li class="active">${breadcrumbList.get(0)}</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 portlets">
            <div class="panel">
                <div class="panel-header">
                    <h3><i class="icon-home"></i> <strong>DB CACHED LAST SEARCHES </strong></h3>
                </div>
                <div class="panel-content">
                    <table class="table table-hover table-dynamic filter-head" id="dashboardTable">
                        <thead>
                        <tr>
                            <th><div class="m-b-10">Start Date</div></th>
                            <th><div class="m-b-10">End Date</div></th>
                            <th><div class="m-b-10">E-Mail</div></th>
                            <th><div class="m-b-10">Last Update</div></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="trackRecord" items="${trackRecords}">
                            <tr>
                                <td><fmt:formatDate value="${trackRecord.start}" pattern="${pattern}" /></td>
                                <td><fmt:formatDate value="${trackRecord.end}" pattern="${pattern}" /></td>
                                <td>${trackRecord.email}</td>
                                <td>${trackRecord.timestamp}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>