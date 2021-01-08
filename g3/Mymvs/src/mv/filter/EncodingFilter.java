package mv.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        HttpServletResponse resp = (HttpServletResponse) response;
//        //当**Credentials为true时，**Origin不能为星号，需为具体的ip地址【如果接口不带cookie,**Origin无需设成具体ip】
//        resp.setHeader("Access-Control-Allow-Origin", "http://IPv4:端口");
//        resp.setHeader("Access-Control-Allow-Credentials", "true");
//        resp.setHeader("Access-Control-Allow-Methods", "GET,POST,PATCH,PUT,OPTIONS,DELETE");
//        resp.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Cookie,Accept,Token");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void destroy() {
    }
}

