/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import DB.ConnectionDB;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author setia
 */
public class Transaksi extends HttpServlet {
    private final Connection conn;
    
    public Transaksi (){
        conn = ConnectionDB.getConnectionDB();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String txtKode = request.getParameter("kode");
        String txtStatus = request.getParameter("status");
        String txtNama = request.getParameter("nama");
        String txtAlamat = request.getParameter("alamat");
        String txtTelp = request.getParameter("telp");
        String txtEmail = request.getParameter("email");
        String txtCaraBayar = request.getParameter("cara_bayar");
        String txtLamaBayar = request.getParameter("lama_bayar");
        String txtPotongan = request.getParameter("potongan");
        String txtPlafon = request.getParameter("plafon");
        String txtNoRek = request.getParameter("no_rek");
        
        PreparedStatement prst = null;
        String insertQuery = "insert into m_bank(KodeBank, NamaBank) " + "values ('"+txtKode+"','"+txtStatus+"')";
        try {
            prst = conn.prepareStatement(insertQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            prst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("kode", txtKode);
        request.setAttribute("status", txtStatus);
        request.setAttribute("nama", txtNama);
        request.setAttribute("alamat", txtAlamat);
        request.setAttribute("telp", txtTelp);
        request.setAttribute("caraBayar", txtCaraBayar);
        request.setAttribute("lamaBayar", txtLamaBayar);
        request.setAttribute("potongan", txtPotongan);
        request.setAttribute("plafon", txtPlafon);
        request.setAttribute("email", txtEmail);
        request.setAttribute("noRek", txtNoRek);
        
        request.getRequestDispatcher("form.jsp").forward(request, response);
// response.getWriter().println(txtBank);
    }

}
