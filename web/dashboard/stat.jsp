<%@ page import="utils.Url" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-1@l uk-width-1-1@xl">
        <div>
            <% Url url = (Url) request.getAttribute("url"); %>
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
                        <a href="${pageContext.request.contextPath}/dashboard/url">Retour</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-1@l uk-width-1-1@xl">
        <div>
            <canvas id="myChart"></canvas>
            <script>
                var ctx = document.getElementById("myChart").getContext('2d');
                new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Decembre'],
                        datasets: [{
                            label: 'Number of clicks',
                            data: [<%= request.getAttribute("chartData") %>],
                            fill: false
                        }]
                    },
                    options: {
                        responsive: true,
                        title: {
                            display: true,
                            text: 'Statistiques'
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: false
                        },
                        hover: {
                            mode: 'nearest',
                            intersect: true
                        },
                        scales: {
                            xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Month'
                                }
                            }],
                            yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: false,
                                }
                            }]
                        }
                    }
                });
            </script>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/foot.jsp"/>
