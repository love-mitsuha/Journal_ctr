package com.ahu21.web;

import com.ahu21.mapper.JournalMapper;
import com.ahu21.pojo.Journal;
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

@WebServlet("/journalServlet")
public class JournalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

//		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession = sqlSessionFactory.openSession();
//		3.
        JournalMapper journalMapper = sqlSession.getMapper(JournalMapper.class);
//		4.
        List<Journal> journals = journalMapper.selectall();
//		 5.

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        ServletContext context = getServletContext(); // 获取ServletContext对象
        String htmlTemplate = readFile(context, "/J.html");
        sqlSession.close();
        // 插入用户数据
        StringBuilder journalHtml = new StringBuilder();
        for (Journal j : journals) {
            journalHtml.append("<img src=\"").append(j.getJPATH()).append("\" alt=\"\">");
        }
        // 替换模板中的用户数据占位符
        String htmlContent = htmlTemplate.replace(" <!-- 图片插入在这 -->", journalHtml.toString());
        System.out.println(htmlContent);
        // 写入响应
        writer.write(htmlContent);

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