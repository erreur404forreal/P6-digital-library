<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>E-library - Emprunts</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link " href="${pageContext.request.contextPath}/home">Home</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/searchwork">Oeuvres</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/borrowing/list">Emprunts</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/member/profile">Profil</a>
                <c:choose>
                    <c:when test = "${sessionScope.loggedin}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/library/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class= "nav-link" href="${pageContext.request.contextPath}/home">Login</a>
                    </c:otherwise>
                </c:choose>
            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">${loggedmember.username}, Voilà vos emprunts</h1>

        <c:choose>
            <c:when test="${borrowingList==null || borrowingList.size() == 0}">
                <p> Aucun Resultat trouvé, réessayez</p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${borrowingList}" var="borrowing">
                    <ul>
                        <li>
                            Titre du livre : ${borrowing.titleofbook}
                            <br>
                            Indentifiant de l'emprunt : ${borrowing.idborrow}
                            <br>
                            Date d'emprunt : ${borrowing.issueDate}
                            <br>
                            Date de retour du livre : ${borrowing.returnDate}
                            <br>
                            Status de l'emprunt : ${borrowing.status}
                            <br>
                        </li>

                        <c:choose>

                            <c:when test = "${borrowing.extended==true && borrowing.status!='Prêt terminé'}">
                                <td><a href="${pageContext.request.contextPath}/borrowing/handover/${borrowing.idborrow}"> <button  class="btn btn-outline-info" data-toggle="popover" data-trigger="focus" title="Cliquez ici pour remettre le livre" data-content="Buy">Rendre</button></a>
                                    </c:when>
                            <c:when test = "${borrowing.extended==false && borrowing.status!='Prêt terminé'}">
                                <td><a href="${pageContext.request.contextPath}/borrowing/extend/${borrowing.idborrow}"> <button  class="btn btn-outline-warning" data-toggle="popover" data-trigger="focus" title="Cliquez ici pour prolonger le prêt" data-content="Buy">Prolonger</button></a>
                                <td><a href="${pageContext.request.contextPath}/borrowing/handover/${borrowing.idborrow}"> <button  class="btn btn-outline-info" data-toggle="popover" data-trigger="focus" title="Cliquez ici pour remettre le livre" data-content="Buy">Rendre</button></a>
                            </c:when>

                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>


                        </td>


                    </ul>

                </c:forEach>
            </c:otherwise>
        </c:choose>
        <div>${msg}</div>
    </main>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p></p>
        </div>
    </footer>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>
</body>
</html>
