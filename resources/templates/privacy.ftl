<#import "common/base.ftl" as base>

<@base.page>
    <header>
        <h1>Privacy Policy</h1>
        <#if policies?? && (policies?size > 0)>
            <ul>
            <#list policies as policy>
                <li>${policy}</li>
            </#list>
            </ul>
        </#if>
        <p>Etiam quis viverra lorem, in semper lorem.</p>
        <p><a href="https://www.freeprivacypolicy.com/">Free Privacy Policy Generator</a></p>
    </header>
</@base.page>