<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #ui-datepicker-div {
        position: absolute !important;
        z-index: 9999 !important;
    }
</style>
<script>
    $(document).ready(function ($) {

        $("#recordNewStartDateTime").datetimepicker({
            dateFormat: 'dd.mm.yy',
            timeFormat: 'HH:mm',
            maxDate: '0',
            onSelect: function (dateStr) {
                var minD = $(this).datetimepicker('getDate');
                $("#recordNewEndDateTime").datetimepicker('option', 'minDate', minD || '0');
            }
        });

        $("#recordNewEndDateTime").datetimepicker({dateFormat: 'dd.mm.yy', timeFormat: 'HH:mm', maxDate: '0'});
    });
</script>
<div class="page-content">
    <div class="header">
        <h2><strong>New</strong> Record</h2>
        <jsp:include page="../template/breadcrumb.jsp"/>
    </div>
    <div class="row">
        <spring:url value="/record/new" var="addUrl"/>
        <form:form class="form-validation" method="post" modelAttribute="recordAddForm" action="${addUrl}">
        <div class="col-lg-12">
            <div class="panel">
                <div class="panel-content">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="row">
                                <div class="col-md-12">
                                    <spring:bind path="email">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <label class="form-label"><strong>E-Mail </strong> </label>
                                            <div class="prepend-icon">
                                                <c:if test="${email == null}"><c:set var="email"
                                                                                     value="Enter employee email address..."/></c:if>
                                                <form:input path="email" type="email" id="recordNewEmail"
                                                            name="email"
                                                            class="form-control"
                                                            placeholder="${email}"
                                                            required="required"/>
                                                <form:errors path="email" class="control-label" cssClass="form-error"
                                                             element="div"/>
                                                <i class="icon-envelope"></i>
                                            </div>
                                        </div>
                                    </spring:bind>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <spring:bind path="start">
                                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                                    <label class="form-label"><strong>Start </strong> Date & Time
                                                        Picker</label>
                                                    <div class="prepend-icon">
                                                        <c:if test="${recordNewStartDateTime == null}"><c:set
                                                                var="recordNewStartDateTime"
                                                                value="Choose a date..."/></c:if>
                                                        <form:input path="start" type="datetime"
                                                                    id="recordNewStartDateTime"
                                                                    name="start"
                                                                    class="datetimepicker form-control"
                                                                    placeholder="${recordNewStartDateTime}"
                                                                    required="required"
                                                                    readonly="true"/>
                                                        <form:errors path="start" class="control-label"
                                                                     cssClass="form-error" element="div"/>
                                                        <i class="icon-clock"></i>
                                                    </div>
                                                </div>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6">
                                            <spring:bind path="end">
                                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                                    <label class="form-label"><strong>Start </strong> Date & Time
                                                        Picker</label>
                                                    <div class="prepend-icon">
                                                        <c:if test="${recordNewEndDateTime == null}"><c:set
                                                                var="recordNewEndDateTime"
                                                                value="Choose a date..."/></c:if>
                                                        <form:input path="end" type="datetime"
                                                                    id="recordNewEndDateTime"
                                                                    name="end"
                                                                    class="datetimepicker form-control"
                                                                    placeholder="${recordNewEndDateTime}"
                                                                    required="required"
                                                                    readonly="true"/>
                                                        <form:errors path="end" class="control-label"
                                                                     cssClass="form-error"
                                                                     element="div"/>
                                                        <i class="icon-clock"></i>
                                                    </div>
                                                </div>
                                            </spring:bind>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group"
                                 style="display: flex;align-items: center;justify-content: center;margin-top: 15px;">
                                <button id="recordNewSaveButton" type="submit"
                                        class="btn btn-lg btn-success btn-embossed"><i
                                        class="fa fa-save"></i> Save
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
            <c:if test="${resultStatus == 'success'}">
                <div class="row">
                    <div class="col-lg-12">
                        <div id="basic-preview" class="preview active">
                            <div class="alert alert-success media fade in">
                                <p><strong>${successEmail}</strong> has been added successfully.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${resultStatus == 'error' || result == 'notfound'}">
                <div class="row">
                    <div class="col-lg-12">
                        <div id="basic-preview" class="preview active">
                            <div class="alert alert-danger media fade in">
                                <p>Please check your credentials for <strong>${errorEmail}</strong> again.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>