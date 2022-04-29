<%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 ">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Update Employee</div>
                        <div class="panel-body">
                            <form:form method="post" modelAttribute="employee">
                                <form:hidden path="id" />
                                <fieldset class="form-group">
                                    <form:label path="name">Name</form:label>
                                    <form:input path="name" type="text" class="form-control" required="required" />
                                    <form:errors path="name" cssClass="text-warning" />
                                </fieldset>

                                <fieldset class="form-group">
                                    <form:label path="tel">Tel. number</form:label>
                                    <form:input path="tel" type="tel" class="form-control" required="required" />
                                    <form:errors path="tel" cssClass="text-warning" />
                                </fieldset>

                                <fieldset class="form-group">
                                    <form:label path="email">Email</form:label>
                                    <form:input path="email" type="text" class="form-control" required="required" />
                                    <form:errors path="email" cssClass="text-warning" />
                                </fieldset>

                                <button type="submit" class="btn btn-success">Save</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>