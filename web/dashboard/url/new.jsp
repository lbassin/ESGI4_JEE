<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/layout/head.jsp"/>

<div uk-grid class="uk-child-width-1-1@s uk-child-width-2-3@l">
    <div class="uk-width-1-1@s uk-width-1-5@l uk-width-1-3@xl"></div>
    <div class="uk-width-1-1@s uk-width-3-5@l uk-width-1-3@xl">
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <h2 class="uk-text-center">Nouvelle URL</h2>
                <form method="post" action="${pageContext.request.contextPath}/url">
                    <fieldset class="uk-fieldset">
                        <div class="uk-margin">
                            <input name="url" class="uk-input" type="text" placeholder="URL">
                        </div>
                    </fieldset>
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">1 - Protection</legend>

                        <div class="uk-margin">
                            <p style="display: flex; justify-content: space-between">
                                <label>
                                    <input class="uk-radio radio-captcha" type="radio" name="secure" value="captcha"
                                           checked>
                                    Sécuriser avec un captcha
                                </label>

                                <label>
                                    <input class="uk-radio radio-password" type="radio" name="secure" value="password">
                                    Sécuriser avec un mot de passe
                                </label>
                            </p>
                        </div>
                        <div class="uk-margin">
                            <textarea name="password"
                                      class="uk-textarea"
                                      placeholder="Password (One by row)"
                                      rows="5"
                                      style="display: none;"
                            ></textarea>
                        </div>

                        <legend class="uk-legend">2 - Date</legend>

                        <div class="uk-margin">
                            <p>
                                <label>
                                    <input class="uk-checkbox" type="checkbox" name="time-limit">
                                    Limiter dans le temps
                                </label>
                            </p>
                        </div>

                        <div class="uk-margin date" style="display: none;">
                            <input name="startDate" class="uk-input uk-width-1-2" type="text"
                                   placeholder="Début (DD/MM/JJJJ)"
                                   style="width: 50%">
                            <input name="endDate" class="uk-input uk-width-1-2" type="text"
                                   placeholder="Fin (DD/MM/JJJJ)"
                                   style="width: 50%">
                        </div>

                        <legend class="uk-legend">3 - Share</legend>

                        <div class="uk-margin">
                            <input name="email" class="uk-input" type="text" placeholder="Email">
                        </div>

                        <div class="uk-margin uk-text-center">
                            <button id="submit" class="uk-button uk-button-default">Raccourcir</button>
                        </div>
                        <div id="output-short-url" class="uk-margin" style="display: none;">
                            <label class="uk-form-label" for="form-horizontal-text">Votre url raccourcie</label>
                            <div class="uk-form-controls">
                                <input class="uk-input" id="form-horizontal-text" type="text" disabled>
                            </div>
                        </div>
                    </fieldset>
                </form>
                <div class="uk-margin" id="response">

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.querySelector('.radio-password').addEventListener('change', function () {
        document.querySelector('[name=password]').style.display = 'block';
    });

    document.querySelector('.radio-captcha').addEventListener('change', function () {
        document.querySelector('[name=password]').style.display = 'none';
    });

    document.querySelector('[name=time-limit]').addEventListener('change', function () {
        if (this.checked) {
            document.querySelector('.date').style.display = 'flex';
        } else {
            document.querySelector('.date').style.display = 'none';
        }
    });


    document.querySelector('#submit').addEventListener('click', function (event) {
        event.preventDefault();
        var button = this;
        // button.disabled = true;

        var request = new XMLHttpRequest();

        request.addEventListener("load", function (data) {
            button.disabled = false;
            var response = JSON.parse(data.target.responseText);
            document.querySelector('#output-short-url').style.display = 'block';
            document.querySelector('#output-short-url input').value = response.url;
        }, false);

        var params = {
            url: document.querySelector('[name=url]').value,
            captcha: document.querySelector('[name="secure"]:checked').value === 'captcha',
            password: document.querySelector('[name=password]').value,
            timeLimit: document.querySelector('[name="time-limit"]:checked') !== null,
            startDate: document.querySelector('[name=startDate]').value,
            endDate: document.querySelector('[name=endDate]').value,
            email: document.querySelector('[name=email').value
        };

        if (!params.url) {
            button.disabled = false;
            event.preventDefault();
            return;
        }

        var searchParams = Object.keys(params).map(function (key) {
            return encodeURIComponent(key) + '=' + encodeURIComponent(params[key]);
        }).join('&');

        request.open('POST', document.location.href, false);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(searchParams);
    });
</script>


<jsp:include page="/WEB-INF/layout/foot.jsp"/>
