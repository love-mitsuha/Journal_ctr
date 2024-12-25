package com.ahu21.web;

import com.ahu21.mapper.ReturnMapper;
import com.ahu21.pojo.Returnaccept;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet("/joureturnSevlet")
public class JoureturnSevlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String flag=request.getParameter("flag");

        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        ReturnMapper returnMapper=sqlSession.getMapper(ReturnMapper.class);

        List<Returnaccept> Rinfo=returnMapper.selectr();
        List<Returnaccept> Rinfo1= new ArrayList<>();
        if (flag.equals("false"))
         Rinfo1=Rinfo.stream().filter(s-> !Objects.equals(s.getAccept(), "已归还")).collect(Collectors.toList());
        else
            Rinfo1=Rinfo.stream().filter(s-> !Objects.equals(s.getAccept(), "未归还")).collect(Collectors.toList());
        String json = JSON.toJSONString(Rinfo1);
      
        response.setContentType("text/html;charset=utf-8");
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
