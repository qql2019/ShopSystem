<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head> 
    <title></title>
  </head>
  
  <body>
    <table>
    <tr>
    <td>当前位置&nbsp;&nbsp;基础信息管理&gt;&gt;客户信息管理&gt;&gt;</td>
 
    </tr>
    </table>
       ${tip }
    <form action="${pageContext.request.contextPath}/Customerservlet" method="post">
    <table width="80%" align="center">
    <tr>
    <td colspan="4"><input type="hidden" name="reqfg" value="addcust"></td>
    </tr>
    <tr>
    <td>客户名称:</td>
    <td><input type="text" name="custname" value="${param.custname}" /></td>
    <td>地址：</td>
    <td><input type="text" name="custattr" value="${param.custattr}"/></td>
    </tr>
    <tr>
    <td>电话:</td>
    <td><input type="text"name="custtel" value="${param.custtel }" /></td>
    <td>联系人:</td>
    <td><input type="text" name="custpersion" value="${param.custpersion}"/> </td>
    </tr>
    <tr>
    <td>联系方式:</td>
    <td><input type="text" name="custpertel" value="${param.custpertel}"/> </td>
    <td>传真:</td>
    <td><input type="text" name="custfax" value="${param.custfax}"/> </td>
    </tr>
    <tr>
    <td>电子邮箱:</td>
    <td><input type="text" name="custemail" value="${param.custemail}"/> </td>
    <td>QQ:</td>
    <td><input type="text" name="custQQ" value="${param.custQQ }"/> </td>
    </tr>
    <tr>
    <td>开户银行：</td>
    <td><input type="text" name="custbank" value="${param.custbank }"/> </td>
    <td>银行账号:</td>
    <td><input type="text" name="custaccountno" value="${param.custaccountno }"/> </td>
    </tr>
    <tr>
    <td>邮编:</td>
    <td><input type="text" name="custmeno" value="${param.custmeno }"/> </td>
    <td>备注:</td>
    <td>
    <textarea rows="" cols="" name="custpostcod">${param.custpostcod }</textarea>
    </td>
    </tr>
    <tr>
    <td colspan="4" align="center">
    <input type="submit" value="保存">&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重置">
    </td>
    </tr>
    </table>
    </form>
  </body>
</html>
