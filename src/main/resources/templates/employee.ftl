<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>林氏-员工管理</title>
	<#include "common.ftl"/>
	<#include "emp_js.ftl"/>
</head>
<body>

<table id="employee_datagrid"></table>

<%--左上角按钮--%>
<div id="employee_toolbar">
    <shiro:hasPermission name="employee:save">
        <a data-cmd="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="employee:saveOrUpdate">
        <a data-cmd="edit" id="employee_edit" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">编辑</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="employee:leave">
        <a data-cmd="leave" id="employee_leave" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">离职</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="employee:delete">
        <a data-cmd="delete" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</a>
    </shiro:hasPermission>
    <div><input name="keyword"><a id="employee_search" class="easyui-linkbutton"
                                  data-options="iconCls:'icon-search',plain:true"></a></div>
</div>

<%--编辑窗口--%>
<div id="employee_dialog">
    <!--form表单-->
    <form id="employee_form" method="post">
        <input name="id" type="hidden">
        <table align="center" style="margin-top: 30px">
            <tr>
                <td>账号:</td>
                <td><input class="easyui-validatebox" type="text" name="username"/>
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input class="easyui-validatebox" type="text" name="realname"/></td>
            </tr>
            <tr>
                <td>入职时间:</td>
                <td><input class="easyui-validatebox" type="text" name="inputTime"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input class="easyui-validatebox" type="text" name="password"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-validatebox" type="text" name="tel"/></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input class="easyui-validatebox" type="text" name="email"/></td>
            </tr>
        </table>
    </form>
</div>
<!--编辑底部按钮-->
<div id="employee_button">
    <a data-cmd="save" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存</a>
    <a data-cmd="cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">取消</a>
</div>

</body>
</html>