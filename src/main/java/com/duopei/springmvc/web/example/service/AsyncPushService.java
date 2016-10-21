package com.duopei.springmvc.web.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class AsyncPushService {

	private DeferredResult<String> deferredResult;

	public DeferredResult<String> getAsyncUpdate() {
		deferredResult = new DeferredResult<String>();
		return deferredResult;
	}

	@Scheduled(fixedDelay = 5000)
	public void refresh() {
		if (null != deferredResult) {
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}
	
}
