<script type="text/javascript">


$(function () {
    laydate.render({
        elem: '[name=inputTime]',
        max: 0
    });
    var $employeeForm = $("#employee_form");
    var $employeeDialog = $("#employee_dialog");
    var $employeeDatagrid = $("#employee_datagrid");
    //主界面
    $employeeDatagrid.datagrid({
        fit: true,
        fitColumns: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/list',
        toolbar: "#employee_toolbar",
        columns: [[
            {field: 'username', title: '账号', width: 10, align: 'center'},
            {field: 'realname', title: '姓名', width: 10, align: 'center'},
            {field: 'tel', title: '电话', width: 10, align: 'center'},
            {field: 'email', title: '邮箱', width: 10, align: 'center'},
            {field: 'inputTime', title: '入职时间', width: 10, align: 'center'},
            {
                field: 'admin',
                title: '超管',
                width: 10,
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "是";
                    } else {
                        return "否";
                    }
                }
            },
            {
                field: 'state',
                title: '状态',
                width: 10,
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == 0) {
                        return "<span style='color: #00ee00'>在职</span>";
                    } else  if (value == 1){
                        return "<span style='color: red'>离职</span>";
                    }
                }
            }
        ]],
        onClickRow: function (rowIndex, rowData) {
            $("#employee_edit,#employee_leave").linkbutton(rowData.state == 1 ? "disable" : "enable");
        }
    });

    //编辑窗口
    $employeeDialog.dialog({
        width: 420,
        height: 320,
        closed: true,
        buttons: "#employee_button"
    });

    //高级查询搜索框
    $("#employee_search").click(function () {
        var keyword = $("[name=keyword]").val();
        $employeeDatagrid.datagrid("load", { //参数为json字符串类型
            //load:加载和显示第一页的所有行,相当于提交功能
            keyword: keyword
        })
    })

    //a标签统一绑定点击事件
    $("a").click(function () {
        var cmd = $(this).data('cmd');
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    var cmdObj = {
        //新增
        add: function () {
            $employeeForm.form("clear");
            $employeeDialog.dialog("setTitle", "新增");
            $employeeDialog.dialog("open");

        },
        //编辑
        edit: function () {
            var row = $employeeDatagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要编辑的数据", "info");
                return;
            }
            $employeeForm.form("load", row);//同名回显操作
            $employeeDialog.dialog("setTitle", "编辑");
            $employeeDialog.dialog("open");
        },
        //删除
        delete: function () {
            var row = $employeeDatagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的数据", "info");
                return;
            }
            $.messager.confirm("温馨提示", "你确定要删除吗", function (y) {
                if (y) {
                    $.post("/delete", {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", "删除成功","info", function () {
                                $employeeDialog.dialog("close");
                                $employeeDatagrid.datagrid("reload", true);
                            })
                        } else {
                            $.messager.alert("温馨提示", data.msg, "error");
                        }
                    }, 'json')
                }
            })

        },
        //离职
        leave: function () {
            var row = $employeeDatagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要离职的员工", "info");
                return;
            }
            $.messager.confirm("温馨提示", "你确定要离职该员工吗", function (y) {
                if (y) {
                    $.post("/leave", {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", "离职成功","info", function () {
                                $employeeDialog.dialog("close");
                                $employeeDatagrid.datagrid("reload", true);
                            })
                        } else {
                            $.messager.alert("温馨提示", data.msg, "error");
                        }
                    }, 'json')
                }
            })
        },
        //取消操作
        cancel: function () {
            $employeeDialog.dialog("close");
        },
        //保存操作
        save: function () {
            //根据id的值来判断是修改还是新增
            var id = $("[name=id]").val();
            var url = "/saveOrUpdate";
            $employeeForm.form('submit', {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //1 关闭对话框
                            $employeeDialog.dialog("close", true);
                            //2 刷新页面
                            $employeeDatagrid.datagrid("reload", true);
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                }
            });
        }
    }

})

</script>



