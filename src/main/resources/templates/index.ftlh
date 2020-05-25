<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Labaratory72</title>

    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div class="container">
    <form action="/sms/add" method="post" id="sms-form">
        <h2>Send sms</h2>
        <div>
            <label for="value">sms </label>
            <input name="value" id="value">
            <a href="" id="sms-add">Send</a>
        </div>
        <div>


            <#if cartItems??>
                <#list cartItems as item>
                    <p>${item}</p>
                </#list>
<#--                <form action="/sms/empty" method="post">-->
<#--                    <button>Delete all sms</button>-->
<#--                </form>-->
            <#else>
                <p>nothing!</p>
            </#if>
<#--            <a href="/sms/add" class="value-cell">refresh</a>-->
        </div>
    </form>

</div>

<script>
    'use strict';

    window.addEventListener('load', function () {


        async function SendSms(e) {
            e.preventDefault();
            e.stopPropagation();

            const form = document.getElementById("sms-form");
            const options = {
                method: 'post',
                body: new FormData(form)
            };

            await fetch("/sms/add", options);
        }

        setInterval(function () {
            window.location.pathname = "/sms/add/";
        }, 10000);


        const updateElement = document.getElementById("sms-add");
        updateElement.addEventListener('click', SendSms);

    })

</script>

</body>
</html>