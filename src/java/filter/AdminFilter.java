/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*") // Filter áp dụng cho mọi request bắt đầu bằng "/admin/"
public class AdminFilter implements Filter {

    public AdminFilter() {}

    public void init(FilterConfig fConfig) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) { // Kiểm tra xem có phiên đăng nhập hay không
            res.sendRedirect(req.getContextPath() + "/account.jsp"); // Nếu không, chuyển hướng đến trang đăng nhập
        } else {
            String username = (String) session.getAttribute("username");
            // Kiểm tra xem người dùng có phải là admin hay không
            if (!isAdmin(username)) {
                res.sendRedirect(req.getContextPath() + "/default.jsp"); // Nếu không, chuyển hướng đến trang lỗi
            } else {
                chain.doFilter(request, response); // Nếu là admin, tiếp tục cho request đi tiếp
            }
        }
    }

    private boolean isAdmin(String username) {
        // Viết code kiểm tra xem username có phải là admin hay không
        // Đây là nơi bạn cần xác định logic để xác định người dùng có phải là admin hay không
        // Trong trường hợp này, bạn có thể kiểm tra trong CSDL hoặc có một danh sách các người dùng admin cố định
        // Trong trường hợp đơn giản, bạn có thể kiểm tra tên người dùng có "admin" hay không
        return username != null && username.equals("admin@gmail.com")||username != null && username.equals("2@gmail.com");
    }
}
