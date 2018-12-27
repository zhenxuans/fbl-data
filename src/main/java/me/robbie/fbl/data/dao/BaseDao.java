package me.robbie.fbl.data.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseDao {
    protected SqlSession session;

    @Autowired
    public void setSession(SqlSession session) {
        this.session = session;
    }
}
