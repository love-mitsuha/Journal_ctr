package com.ahu21.web;

import com.ahu21.mapper.BorrowMapper;
import com.ahu21.mapper.JournalMapper;
import com.ahu21.pojo.Borrowaccept;
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

@WebServlet("/borinsertServlet")
public class BorinsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String json1=request.getReader().readLine();
        Borrowaccept Bs1 = JSON.parseObject(json1,Borrowaccept.class);
        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);

        Borrowaccept flag = borrowMapper.selectnull(Bs1.getJNO(),Bs1.getUACCOUNT());
        response.setContentType("text/html;charset=utf-8");
        System.out.println(flag);
        if(flag==null){
            borrowMapper.insertba(Bs1);
            response.getWriter().write("成功");
        }
        else{
            response.getWriter().write("失败");
        }
        sqlSession.commit();
//            响应
        ServletContext context = getServletContext(); // 获取ServletContext对象

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        sqlSession.close();
//            提交事务（很重要）

        sqlSession.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
