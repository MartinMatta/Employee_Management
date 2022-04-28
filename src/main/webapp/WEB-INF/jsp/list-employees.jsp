<%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>

        <div class="container">
            <div>
                <a type="button" class="btn btn-primary btn-md" href="/add-employee">Add Employee</a>
            </div>
            <br>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3>List of Employees</h3>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th width="40%">Name</th>
                                <th width="40%">Date</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${employees}" var="employee">
                                <tr>
                                    <td>${employee.surname}</td>
                                    <td>
                                        <fmt:formatDate value="${employee.date}" pattern="dd/MM/yyyy" />
                                    </td>
                                    <td><a type="button" class="btn btn-success" href="/update-employee?id=${employee.id}">Update</a>
                                        <a type="button" class="btn btn-warning" href="/delete-employee?id=${employee.id}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>