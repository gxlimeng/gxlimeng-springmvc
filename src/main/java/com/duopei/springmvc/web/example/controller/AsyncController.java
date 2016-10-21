package com.duopei.springmvc.web.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.duopei.springmvc.web.example.service.AsyncPushService;

@Controller
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	AsyncPushService asyncPushService ;
	
	@RequestMapping(value="/defer")
	public @ResponseBody DeferredResult<String> deferredCall(){
		 return asyncPushService.getAsyncUpdate();
	}
	
}
