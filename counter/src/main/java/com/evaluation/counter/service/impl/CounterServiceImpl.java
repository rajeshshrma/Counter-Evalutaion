/**
 * 
 */
package com.evaluation.counter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.counter.dao.CounterDao;
import com.evaluation.counter.service.CounterService;

@Service
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterDao counterDao;
	
	@Override
	public void increaseCounter() throws Exception {
		counterDao.increaseCounter();
		
	}


}
