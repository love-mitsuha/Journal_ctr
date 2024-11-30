package com.ahu21.web;

import com.ahu21.mapper.ManagerMapper;
import com.ahu21.pojo.Manager;
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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");


        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        ManagerMapper managerMapper =sqlSession.getMapper(ManagerMapper.class);

        Manager user= managerMapper.select(username,password);

        response.setContentType("text/html;charset=utf-8");
        if(user!=null) {
            managerMapper.remove(username,password);
            sqlSession.commit();
//            响应
            ServletContext context = getServletContext(); // 获取ServletContext对象
            String htmlTemplate = readFile(context, "/userlist.html");
            List<Manager> users= managerMapper.selectall();
            sqlSession.close();
            // 插入用户数据
            StringBuilder usersHtml = new StringBuilder();
            for (Manager u : users) {
                usersHtml.append("<tr>")
                        .append("<td>").append(u.getMACCOUNT()).append("</td>")
                        .append("<td>").append(u.getMPASSWORD()).append("</td>")
                        .append("</tr>");
            }
            // 替换模板中的用户数据占位符
            String htmlContent = htmlTemplate.replace("<!-- 用户数据将在这里插入 -->", usersHtml.toString());
            // 写入响应
            response.getWriter().write(htmlContent);

//            提交事务（很重要）

            sqlSession.close();
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名不存在");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
