<%-- 
    Document   : latihan1
    Created on : 30 May 2025, 20.33.17
    Author     : setia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Kelas PBO!</h1>
        <form id="sfm" method="post" action="BankCRUD" novalidate>
            <div class="fitem">
                <label>Kode Bank</label>
                <input type="text" name="txtIdBank" id="txtIdBank">
            </div>
            <div class="fitem">
                <label>Nama Bank</label>
                <input type="text" name="txtBankName" id="txtBankName">
            </div>
            <div class="fitem">
                <input type="submit" name="btnSimpan" id="btnSimpan">
            </div>
        </form>
    </body>
</html>
