<#-- @ftlvariable name="RequestParameters.error" type="String" -->
<#-- @ftlvariable name="RequestParameters.logout" type="String" -->

<@layout title="User Sign In">
<#if (RequestParameters.error)?? || (RequestParameters.logout)??>
  <#assign showMessage = true />
  <#assign class = "alert-danger" />
  <#assign message = "用户名密码错误." />
</#if>
<#if (RequestParameters.logout)??>
  <#assign class = "alert-info" />
  <#assign message = "您已经正常退出." />
</#if>
<div class="row">
  <p>&nbsp;</p>
  <#if showMessage??>
    <div class="col-md-offset-4 col-md-4">
      <div class="alert ${class} fade in" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
        <p class="typo em">${message}</p>
      </div>
    </div>
  </#if>
</div>
<div class="row">
  <div class="col-md-offset-4 col-md-4">
    <form action="/login.html" method="post">
      <div class="form-group">
        <input type="text" name="username" class="form-control" placeholder="Nickname or Mobile" />
      </div>
      <div class="form-group">
        <input type="password" name="password" class="form-control" placeholder="Password" />
      </div>
      <button type="submit" class="btn btn-default">点击登录 &#8594; </button>
    </form>
  </div>
</div>
</@layout>
