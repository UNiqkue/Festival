<#include "parts/security.ftl">

<#import "parts/pattern.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                   placeholder="Поиск по тегу">
            <button type="submit" class="btn btn-primary ml-2">Поиск</button>
        </form>
    </div>
</div>

    <#if isAdmin>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Новая запись
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="title" placeholder="Название"/>
            </div>
            <div class="form-group">
                <textarea type="text" class="form-control" rows="20" name="text"
                          placeholder="Введите сообщение"></textarea>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="type" placeholder="Раздел">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="tag" placeholder="Тэг">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Выбрать файл</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>
    </#if>


<#--<div>-->
    <#--<div class="container my-3">-->
        <#--<div class="row">-->
            <#--<div class="col">-->
                <#--<div class="card">-->
                    <#--<div class="card-body">-->
                        <#--<div class="card-header"><div class="card-title"><h2>Ваши фестивали</h2></div></div>-->
                        <#--<h3 class="card-text">-->
                            <#--<a href="/user/festivals/${user.id}">${countFestivals}</a>-->
                        <#--</h3>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->


<div class="card text-center">
     <div class="card-header"><h1>Festivals</h1></div>
    <#list festivals as festival>
        <div class="card my-3">

            <div class="card-header"> <h2>${festival.title}</h2></div>
              <#if festival.filename??>
       <div class="img"> <img src="/img/${festival.filename}" class="card-img-top"></div>
              </#if>
            <div><h4>Тип: ${festival.type}</h4></div>
            <div><span>${festival.text}</span></div>
           <div> <i><br/>#${festival.tag}</i></div>
            <p>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1175.906045269856!2d27.662785617299658!3d53.881768537551324!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbcdde4d0db2a7%3A0x44eab1b1e63ba685!2z0YPQu9C40YbQsCDQkNC70YLQsNC50YHQutCw0Y8gMTY2LzIsINCc0LjQvdGB0Lo!5e0!3m2!1sru!2sby!4v1536874340991" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe></p>

        <#--<div class="card-footer text-muted">-->
                <#--${festival.getUsers().size()}-->
            <#--</div>-->
            <div class="card-footer text-muted"><button type="submit" class="btn btn-info">Пойти</button> </div>
           </div>


    <#else>
    По вашему запросу сообщений не найдено
    </#list>
</div>
</@c.page>
