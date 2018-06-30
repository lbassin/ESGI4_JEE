<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <h2 class="uk-text-center">Breizhlink</h2>
                <% if (request.getAttribute("longUrl") != null) { %>
                <div class="uk-margin uk-text-center">
                    Lien demandé :
                    <a href="<%= request.getAttribute("longUrl") %>">
                        <%= request.getAttribute("longUrl") %>
                    </a>
                </div>
                <div class="uk-margin uk-text-center">
                    <a href="<%= request.getAttribute("longUrl") %>" class="uk-button uk-button-default">S'y rendre</a>
                </div>
                <% } else { %>
                <div class="uk-margin uk-text-center">
                    <p>La ressource n'existe pas</p>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
