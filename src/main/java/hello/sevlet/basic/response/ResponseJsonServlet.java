package hello.sevlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.sevlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("hong");
        helloData.setAge("29");

        //{"username":"hong", "age":29}
        //Jackson 라이브러리
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
