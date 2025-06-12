package DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConDB extends HttpServlet {

    private final Connection conn;

    public ConDB() {
        conn = ConnectionDB.getConnectionDB();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (conn != null) {
            out.println("<h3 style='color:green;'>Koneksi ke database <b>hr</b> berhasil!</h3>");

            // Menyisipkan data BCA ke tabel m_bank
            String kdBank = "BCA";
            String nmBank = "Bank Central Asia";

            PreparedStatement prSt = null;

            String insertQuery = "INSERT INTO m_bank(KodeBank, NamaBank) VALUES (?, ?)";

            try {
                prSt = conn.prepareStatement(insertQuery);
                prSt.setString(1, kdBank);
                prSt.setString(2, nmBank);

                int result = prSt.executeUpdate();

                if (result > 0) {
                    out.println("<p style='color:blue;'>Data bank <b>" + kdBank + "</b> berhasil disimpan!</p>");
                } else {
                    out.println("<p style='color:red;'>Gagal menyimpan data bank.</p>");
                }

            } catch (SQLException e) {
                out.println("<p style='color:red;'>Error SQL: " + e.getMessage() + "</p>");
            } finally {
                try {
                    if (prSt != null) prSt.close();
                } catch (SQLException e) {
                    out.println("<p style='color:red;'>Gagal menutup statement: " + e.getMessage() + "</p>");
                }
            }

        } else {
            out.println("<h3 style='color:red;'>Koneksi gagal!</h3>");
        }
    }
}
