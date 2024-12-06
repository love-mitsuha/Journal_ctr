package com.ahu21.web;

import com.ahu21.mapper.ManagerMapper;
import com.ahu21.mapper.UserMapper;
import com.ahu21.pojo.Manager;
import com.ahu21.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@WebServlet("/userloginServlet")
public class UserloginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession = sqlSessionFactory.openSession();
////		3.
//        ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
////		4.
//        Manager user = managerMapper.select(username, password);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		4.
        User user = userMapper.select(username, password);
//		 5.
        sqlSession.close();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (user != null) {
            ServletContext context = getServletContext(); // 获取ServletContext对象
            String htmlTemplate = readFile(context, "/login.html");
            String htmlContent = htmlTemplate.replace("<!--警告-->", "location.href=\"./J.html\"");
            response.getWriter().write(htmlContent);
        }
        else{
            ServletContext context = getServletContext(); // 获取ServletContext对象
            String htmlTemplate = readFile(context, "/login.html");
            String htmlContent = htmlTemplate.replace("<!--警告-->", "alert(\"登陆失败\")");
            response.getWriter().write(htmlContent);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }

    private String readFile(ServletContext context, String filePath) throws IOException {
        String realPath = context.getRealPath(filePath);
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(realPath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        return contentBuilder.toString();
    }
}

// 辅助方法：读取文件内容


