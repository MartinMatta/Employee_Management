<%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 ">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Add Employee</div>
                        <div class="panel-body">
                            <form:form method="post" modelAttribute="employee">
                                <form:hidden path="id" />
                                <fieldset class="form-group">
                                    <form:label path="surname">Surname</form:label>
                                    <form:input path="surname" type="text" class="form-control" required="required" />
                                    <form:errors path="surname" cssClass="text-warning" />
                                </fieldset>

                                <fieldset class="form-group">
                                    <form:label path="date">Target Date</form:label>
                                    <form:input path="date" type="text" class="form-control" required="required" />
                                    <form:errors path="date" cssClass="text-warning" />
                                </fieldset>

                                <button type="submit" class="btn btn-success">Save</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>