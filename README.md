已经完成 初版 Easyui Tag 标签的开发、以下是已经支持的标签：
<ul>
	<li>基本标签：RenderSection、Section、Resources、Resource、Hidden；</li>
	<li>EasyUI 基础：SearchBox、Tooltip；</li>
	<li>EasyUI 布局：Body、Panel、Tabs（TagPage）、Accordion（Sheet）、Layout（Dock）；</li>
	<li>EasyUI 窗口：Window、Dialog；</li>
	<li>EasyUI 表格与树：DataGrid（Columns、Column）、DataList、Tree、TreeGrid；</li>
	<li>EasyUI 表单：Form、ValidateBox、TextBox、Combo、ComboBox、ComboTree、ComboGrid、NumberBox、DateBox、DateTimeBox、DateTimeSpinner、Calendar、NumberSpinner、TimeSpinner、</li>
	<li>EasyUI 菜单与按钮：Menu（MenuItem、SubItem）、LinkButton、MenuButton、SplitButton、SwitchButton；</li>
</ul>
<h1>快速开始</h1>
在 jsp 页面顶部位置添加如下代码，即可以使用。
<pre class="EnlighterJSRAW">&lt;%@ taglib prefix="k" uri="http://www.kayura.org/tags/jeasyui"%&gt;</pre>
<h1> 演示标准编辑页面示例</h1>
以下是将会用到的一些标签：
<ul>
	<li>RenderSection、Section 用于 jsp 模板页的开发。</li>
	<li>Resources、Resource 用于导入 js 与 css 资源；</li>
	<li>Body 页面级的布局标签；</li>
	<li>Layout 局部布局标签、Dock 布局中的块；</li>
</ul>
<h2>编辑模板页（_editor.jsp）</h2>
<pre class="EnlighterJSRAW">&lt;%@ page language="java" contentType="text/html; charset=UTF-8"%&gt;
&lt;!DOCTYPE html&gt;
&lt;html&gt;
&lt;head&gt;
    &lt;title&gt;&lt;k:renderSection name="title"/&gt;&lt;/title&gt;
    &lt;k:resources location="res"&gt;
        easyui/themes/${theme}/easyui.css
        easyui/themes/icon.css
        js/juasp.css
        js/jquery.min.js
        easyui/jquery.easyui.min.js
        easyui/easyui-lang-zh_CN.js
        js/juasp-core.js
        js/juasp-easyui.js
    &lt;/k:resources&gt;
    &lt;k:renderSection name="head"/&gt;
&lt;/head&gt;
&lt;k:body full="true" padding="5px"&gt;
    &lt;k:layout fit="true"&gt;
        &lt;k:dock region="center" style="padding: 10px 30px 10px 30px;"&gt;
            &lt;!-- 编辑内容区域 body --&gt;
            &lt;k:renderSection name="body"/&gt;
        &lt;/k:dock&gt;
        &lt;k:dock region="south" border="false" style="text-align:right;padding:5px 0 0;"&gt;
            &lt;!-- 工具栏区域 tool --&gt;
            &lt;k:renderSection name="tool"/&gt;
        &lt;/k:dock&gt;
    &lt;/k:layout&gt;
&lt;/k:body&gt;
&lt;/html&gt;</pre>
<h2> 编辑页面（edit.jsp）</h2>
<pre class="EnlighterJSRAW">&lt;%@ page language="java" contentType="text/html; charset=UTF-8"%&gt;
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %&gt;

&lt;k:section name="title"&gt;用户管理&lt;/k:section&gt;
&lt;k:section name="head"&gt;&lt;/k:section&gt;

&lt;!-- 编辑内容区域 body --&gt;
&lt;k:section name="body"&gt;
&lt;k:form id="ff" url="${root}/admin/user/save.json" success="function(data){ juasp.closeWin(1) }"&gt;
    &lt;k:hidden id="userId" value="${model.userId}"/&gt;
    &lt;table cellpadding="5"&gt;
        &lt;tr&gt;
            &lt;td&gt;登录名&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="userName" width="180px" value="${model.userName}" required="true" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;显示名:&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="displayName" width="180px" value="${model.displayName}" required="true" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;c:if test="${empty model.userId}"&gt;
        &lt;tr&gt;
            &lt;td&gt;初始密码:&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="password" width="180px" required="true" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;/c:if&gt;
        &lt;tr&gt;
            &lt;td&gt;电子邮件:&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="email" width="180px" value="${model.email}" required="true" validType="email" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;手机号:&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="mobileNo" width="180px" value="${model.mobileNo}" required="true" validType="length[11,11]" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;关键字:&lt;/td&gt;
            &lt;td&gt;&lt;k:textbox id="keyword" width="180px" value="${model.keyword}" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;过期时间:&lt;/td&gt;
            &lt;td&gt;&lt;k:databox id="expireTime" width="180px" value="${model.expireTime}" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;所属角色:&lt;/td&gt;
            &lt;td&gt;&lt;k:combobox id="roles" width="180px" height="auto" value="${model.roles}" multiple="true" required="true"&gt;
                    &lt;k:option&gt;ROOT&lt;/k:option&gt;
                    &lt;k:option&gt;ADMIN&lt;/k:option&gt;
                    &lt;k:option&gt;USER&lt;/k:option&gt;
                &lt;/k:combobox&gt;
            &lt;/td&gt;
            &lt;td&gt;可选：ROOT,ADMIN,USER。默认为USER&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;是否启用:&lt;/td&gt;
            &lt;td&gt;&lt;k:switchbutton id="isEnabled" checked="${model.isEnabled}" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr&gt;
            &lt;td&gt;是否锁定:&lt;/td&gt;
            &lt;td&gt;&lt;k:switchbutton id="isLocked" checked="${model.isLocked}" /&gt;&lt;/td&gt;
            &lt;td&gt;&lt;/td&gt;
        &lt;/tr&gt;
    &lt;/table&gt;
&lt;/k:form&gt;
&lt;/k:section&gt;

&lt;!-- 工具栏区域 tool --&gt;
&lt;k:section name="tool"&gt;
    &lt;k:linkbutton style="width:80px" iconCls="icon-ok" onClick="$('#ff').form('submit')" text="提交" /&gt;
    &lt;k:linkbutton style="width:80px" iconCls="icon-cancel" onClick="juasp.closeWin(0)" text="取消" /&gt;
&lt;/k:section&gt;

&lt;%@ include file="/views/shared/_dialog.jsp"%&gt;</pre>
<h2>最终显示效果</h2>
<img class="alignnone wp-image-50" src="http://kayura.org/blog/wp-content/uploads/2016/03/编辑页面示例-300x180.jpg" alt="编辑页面示例" width="413" height="248" />

使用模板页，可以更多容易的控制页面的布局，让开发者更关系业务表单的内容。

标签库 Github 地址：https://github.com/KayuraTeam/kayura-tags
