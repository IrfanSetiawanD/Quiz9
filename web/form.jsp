<%-- 
    Document   : form
    Created on : 30 May 2025, 21.17.52
    Author     : setia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <form action="transaksi" method="post">
            <fieldset>
                <p>Master Pelanggan</p>
                <hr />
                <table>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input
                                type="text"
                                name="kode"
                                value="${kode}"
                                title="This field is required"
                                />
                        </td>
                        <td>
                            <label for="status">status:</label>
                        </td>
                        <td>
                            <select id="status" name="status">
                                <option value="aktif">Aktif</option>
                                <option value="tidak aktif">Tidak aktif</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input type="text" name="nama" value="${nama}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Alamat</td>
                        <td>
                            <textarea name="alamat" id="" cols="50" rows="3">${alamat}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>Telp</td>
                        <td>
                            <input type="text" name="telp" value="${telp}" />
                        </td>
                        <td>e-mail</td>
                        <td>
                            <input type="text" name="email" value="${email}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="crBayar">Cara Bayar</label>
                        </td>
                        <td>
                            <select id="crBayar" name="cara_bayar">
                                <c:choose>
                                    <c:when test="${caraBayar}=='cash'">
                                        <option value="cash">Cash</option>
                                        <option value="tf">TF</option>
                                    </c:when>
                                    <c:when test="${caraBayar=='tf'}">
                                        <option value="tf">TF</option>
                                        <option value="cash">Cash</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="cash">Cash</option>
                                        <option value="tf">TF</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Lama Bayar</td>
                        <td>
                            <input type="text" name="lama_bayar" value="${lamaBayar}" /> hari
                        </td>
                    </tr>
                    <tr>
                        <td>Potongan</td>
                        <td>
                            <input type="text" name="potongan" value="${potongan}" /> %
                        </td>
                    </tr>
                    <tr>
                        <td>Nominal Plafon</td>
                        <td>
                            <input type="text" name="plafon" value="${plafon}" />
                        </td>
                    </tr>
                </table>
                <br />
                <table>
                    <p>COA</p>
                    <hr />
                    <tr>
                    <label for="noRek">Nomor Rekening </label>
                    <select id="noRek" name="no_rek">
                        <option value="17728199">17728199</option>
                        <option value="83698092">83698092</option>
                    </select>
                    </tr>
                </table>
                <input type="submit" name="" id="" />
            </fieldset>
        </form>
    </body>
</html>