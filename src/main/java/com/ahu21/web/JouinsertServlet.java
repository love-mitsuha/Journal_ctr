package com.ahu21.web;

import com.ahu21.mapper.JournalMapper;
import com.ahu21.pojo.Journal;
import com.alibaba.fastjson.JSON;
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
@WebServlet("/jouinsertServlet")
public class JouinsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        获取请求体数据
        String json1=request.getReader().readLine();
        Journal Js1 = JSON.parseObject(json1,Journal.class);
        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        JournalMapper journalMapper = sqlSession.getMapper(JournalMapper.class);

        Journal flag=journalMapper.select(Js1.getJNO());
        Journal flag1=journalMapper.selectname(Js1.getJNAME());

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        if(flag==null&&flag1==null) {
            journalMapper.insert(Js1);
            sqlSession.commit();

            response.getWriter().write("成功");
            sqlSession.close();
        }
        else {response.getWriter().write("失败");sqlSession.close();}
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
