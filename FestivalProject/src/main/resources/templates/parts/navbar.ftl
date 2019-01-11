<#include "security.ftl">
<#import "loginform.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark bd-navbar >
    <a class="navbar-brand" href="/">DA VINCI</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Главная</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Личная страница</a>
            </li>
                <#--<#if isAdmin>-->
             <#--<li class="nav-item">-->
                 <#--<a class="nav-link" href="/user/speakers">Справочник спикеров</a>-->
                <#--</#if>-->
             </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>

        <@l.logout />

    </div>
</nav>
