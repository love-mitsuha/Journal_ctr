package com.ahu21.web;

import com.ahu21.mapper.BorrowMapper;
import com.ahu21.mapper.ReturnMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/retdealServlet")
public class RetdealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String  UACCOUNT= request.getParameter("UACCOUNT");
        String  JNO= request.getParameter("JNO");
        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        ReturnMapper returnMapper=sqlSession.getMapper(ReturnMapper.class);
        BorrowMapper borrowMapper=sqlSession.getMapper(BorrowMapper.class);
        returnMapper.update(UACCOUNT,JNO);
        borrowMapper.delete(JNO,UACCOUNT);
        sqlSession.commit();
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("OK");
        sqlSession.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
