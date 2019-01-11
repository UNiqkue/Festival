<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        isSpeaker = user.isSpeaker()
    >
<#else>
    <#assign
        name = "Вы можете зарегистрироваться -> "
        isAdmin = false
        isSpeaker = false
    >
</#if>
