<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
    <div>
        <br>
        <div class="panel panel-primary">
        <div class="panel-heading">
             <h4>Name</h4>
        </div>
        <div class="panel-body">
             ${employee.name}
        </div>
    </div>

    <div>
       <div class="panel panel-primary">
       <div class="panel-heading">
            <h4>Tel. number</h4>
       </div>
       <div class="panel-body">
            ${employee.tel}
       </div>
    </div>

    <div>
       <div class="panel panel-primary">
       <div class="panel-heading">
            <h4>Email</h4>
       </div>
       <div class="panel-body">
            ${employee.email}
       </div>
    </div>

    <div>
       <div class="panel panel-primary">
       <div class="panel-heading">
            <h4>Registration date</h4>
       </div>
       <div class="panel-body">
            <fmt:formatDate value="${employee.date}" pattern="dd/MM/yyyy" />
       </div>
    </div>

</div>