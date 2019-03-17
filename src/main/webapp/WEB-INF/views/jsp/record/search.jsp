<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function () {
        oTable = $('#searchTable').dataTable({
            "format": "DD.MM.YYYY HH:mm",
            "aaSorting": [[1, 'desc']]
        });
    });
</script>
<div class="page-content">
    <div class="header">
        <h2><strong>Search</strong> Records</h2>
        <jsp:include page="../template/breadcrumb.jsp"/>
    </div>
    <div class="row">
        <spring:url value="/record/rest/show" var="searchUrl"/>
        <form:form id="rsForm" class="form-validation" method="post" modelAttribute="recordSearchForm"
                   action="${searchUrl}">
            <div class="col-lg-12">
                <div class="panel">
                    <div class="panel-content">
                        <div class="row">
                            <div class="col-md-3">
                                <spring:bind path="email">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="form-label"><strong>E-Mail </strong> </label>
                                        <div class="prepend-icon">
                                            <c:if test="${email == null}"><c:set var="email"
                                                                                 value="Enter employee email address..."/></c:if>
                                            <form:input path="email" type="email" name="email"
                                                        class="form-control"
                                                        placeholder="${email}"
                                                        required="required"/>
                                            <i class="icon-envelope"></i>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="col-md-1" style="margin-top: 25px;">
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button id="recordSearchSubmitButton" type="submit" class="btn btn-primary"><i
                                                class="fa fa-search"></i> Search
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
    <c:if test="${result == 'notfound'}">
        <div class="row">
            <div class="col-lg-12">
                <div id="basic-preview" class="preview active">
                    <div class="alert alert-warning media fade in">
                        <p>No Records has been found for <strong>${email}</strong>.</p>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${result == 'success'}">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel">
                    <div class="panel-content">
                        <table class="table table-hover table-dynamic filter-head" id="searchTable">
                            <thead>
                            <tr>
                                <th>
                                    <div class="m-b-10">Start Date</div>
                                </th>
                                <th>
                                    <div class="m-b-10">End Date</div>
                                </th>
                                <th>
                                    <div class="m-b-10">E-Mail</div>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="trackRecord" items="${trackRecords}">
                                <tr>
                                    <td><fmt:formatDate value="${trackRecord.start}" pattern="${pattern}"/></td>
                                    <td><fmt:formatDate value="${trackRecord.end}" pattern="${pattern}"/></td>
                                    <td>${trackRecord.email}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>