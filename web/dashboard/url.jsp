<%@ page import="utils.Url" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-1@l uk-width-1-1@xl">
        <div>
            <table class="uk-table uk-table-striped">
                <thead>
                <tr>
                    <th>Short URL</th>
                    <th>Long URL</th>
                    <th>Creation Date</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <% for (Url url : (ArrayList<Url>) request.getAttribute("urls")) { %>
                <tr>
                    <td>
                        <a href="<%= url.getFullUrlShort() %>">
                            <%= url.getFullUrlShort() %>
                        </a>
                    </td>
                    <td>
                        <a href="<%= url.getUrlLong() %>">
                            <%= url.getUrlLong() %>
                        </a>
                    </td>
                    <td>
                        <%= url.getCreatedAt() %>
                    </td>
                    <td>
                        <a href="/dashboard/url/<%= url.getId() %>">Stats</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
