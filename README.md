已经完成 初版 Easyui Tag 标签的开发、以下是已经支持的标签：
<ul>
	<li>基本标签：RenderSection、Section、Resources、Resource、Hidden；</li>
	<li>EasyUI 基础：Pagination、ProgressBar、SearchBox、Tooltip；</li>
	<li>EasyUI 布局：Body、Panel、Tabs（TagPage）、Accordion（Sheet）、Layout（Dock）；</li>
	<li>EasyUI 窗口：Window、Dialog；</li>
	<li>EasyUI 表格与树：DataGrid（Columns、Column）、DataList、Tree、TreeGrid、PropertyGrid；</li>
	<li>EasyUI 表单：Form、ValidateBox、TextBox、Combo、ComboBox、ComboTree、ComboGrid、NumberBox、DateBox、DateTimeBox、DateTimeSpinner、Calendar、NumberSpinner、TimeSpinner、Slider、FileBox；</li>
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
<h2>编辑模板页（_dialog.jsp）</h2>
```javascript
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title><k:renderSection name="title"/></title>
    <k:resources location="res">
        easyui/themes/${theme}/easyui.css
        easyui/themes/icon.css
        js/juasp.css
        js/jquery.min.js
        easyui/jquery.easyui.min.js
        easyui/easyui-lang-zh_CN.js
        js/juasp-core.js
        js/juasp-easyui.js
    </k:resources>
    <k:renderSection name="head"/>
</head>
<k:body full="true" padding="5px">
    <k:layout fit="true">
        <k:dock region="center" style="padding: 10px 30px 10px 30px;">
            <!-- 编辑内容区域 body -->
            <k:renderSection name="body"/>
        </k:dock>
        <k:dock region="south" border="false" style="text-align:right;padding:5px 0 0;">
            <!-- 工具栏区域 tool -->
            <k:renderSection name="tool"/>
        </k:dock>
    </k:layout>
</k:body>
</html>
```
<h2> 编辑页面（edit.jsp）</h2>
```javascript
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<k:section name="title">数据词典管理</k:section>
<k:section name="head">
</k:section>

<k:section name="body">
    <k:form id="ff" url="${root}/admin/dict/save.json" success="function(data){ juasp.closeWin(1) }">
        <k:hidden id="id" value="${model.id}" />
        <k:hidden id="dictId" value="${model.dictId}" />
        <k:hidden id="parentId" value="${model.parentId}" />
        <table cellpadding="5">
            <tr>
                <td>所属词典:</td>
                <td>${model.dictName}</td>
            </tr>
            <c:if test="${treeType}">
            <tr>
                <td>上级词典:</td>
                <td>${model.parentName}</td>
            </tr>
            </c:if>
            <tr>
                <td>词典名称:</td>
                <td><k:textbox name="name" width="180px" value="${model.name}" required="true" validType='length[1,32]' /></td>
            </tr>
            <tr>
                <td>词典值:</td>
                <td><k:textbox name="value" width="180px" value="${model.value}" required="true" validType='length[1,1024]' /></td>
            </tr>
            <tr>
                <td>排序值:</td>
                <td><k:numberbox name="serial" style="width:180px" value="${model.serial}" required="true" min="0" precision="0" /></td>
            </tr>
        </table>
    </k:form>
</k:section>

<k:section name="tool">
    <k:linkbutton style="width:80px" iconCls="icon-ok" onClick="$('#ff').form('submit')" text="提交" />
    <k:linkbutton style="width:80px" iconCls="icon-cancel" onClick="juasp.closeWin(0)" text="取消" />
</k:section>

<%@ include file="/views/shared/_dialog.jsp"%>
```
<h2>最终显示效果</h2>
<img class="alignnone wp-image-50" src="http://kayura.org/blog/wp-content/uploads/2016/03/编辑页面示例-300x180.jpg" alt="编辑页面示例" width="413" height="248" />

使用模板页，可以更多容易的控制页面的布局，让开发者更关系业务表单的内容。

标签库 Github 地址：<a href="https://github.com/KayuraTeam/kayura-tags" target="_blank">https://github.com/KayuraTeam/kayura-tags</a>
