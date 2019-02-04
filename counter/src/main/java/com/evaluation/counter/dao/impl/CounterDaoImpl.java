package com.evaluation.counter.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evaluation.counter.dao.CounterDao;

@Transactional
@Repository
public class CounterDaoImpl implements CounterDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
    /**
     * Increment counter in DB using database isolation level lock
     *
     * @throws Exception - If necessary
     */
	@Override
	public void increaseCounter() throws Exception{
		try {
			// Delegate the concurrency to database and 
			// simply rely on the database isolation level lock on the currently modified row
			String sql = "UPDATE NumberTest nt set nt.hit_count = nt.hit_count + 1 WHERE nt.id = 1;";
			jdbcTemplate.update(sql);
		}catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			throw e;
		}

	}

}
