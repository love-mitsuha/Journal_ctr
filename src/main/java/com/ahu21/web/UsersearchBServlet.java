package com.ahu21.web;

import com.ahu21.mapper.BorrowMapper;
import com.ahu21.mapper.JournalMapper;
import com.ahu21.pojo.Borrowaccept;
import com.ahu21.pojo.Borrowinfo;
import com.ahu21.pojo.Journal;
import com.alibaba.fastjson.JSON;
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
import java.util.List;

@WebServlet("/usersearchbServlet")
public class UsersearchBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String  username= request.getParameter("username");

        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        JournalMapper journalMapper = sqlSession.getMapper(JournalMapper.class);

        List<Borrowinfo> Binfo1 = borrowMapper.userselectb(username);

        response.setContentType("text/html;charset=utf-8");
        String json = JSON.toJSONString(Binfo1);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        sqlSession.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
