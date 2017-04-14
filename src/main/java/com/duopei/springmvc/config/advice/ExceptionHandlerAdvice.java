package com.duopei.springmvc.config.advice;

import com.duopei.springmvc.domain.result.ResponseData;
import com.duopei.springmvc.model.base.ErrorLog;
import com.duopei.springmvc.web.base.service.ErrorLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@ControllerAdvice // @ControllerAdvice声明一个控制器建言，
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    @Autowired
    private ErrorLogService errorLogService;


//  跳转至错误页面
//	@ExceptionHandler(value = Exception.class) // @ExceptionHandler此处定义为全局变量，通过value可以过滤拦截条件，可以拦截所有的Exception
//	public ModelAndView exception(Exception exception , WebRequest request ){
//		ModelAndView modelAndView = new ModelAndView("error");
//		modelAndView.addObject("errorMsg", exception.getMessage());
//		return modelAndView;
//	}

    // 直接拦截异常，并返回错误信息
    @ResponseBody
    @ExceptionHandler(value = MyThrowException.class) // @ExceptionHandler此处定义为全局变量，通过value可以过滤拦截条件，可以拦截指定的Exception
    public ResponseData exception(Exception exception , WebRequest request ){

        /* 日志记录 */
        this.insertErrorExceptionLog(exception,"MyThrowException");

        return new ResponseData("999999",exception.getMessage());
    }

    // 直接拦截异常，并返回错误信息
    @ResponseBody
    @ExceptionHandler(value = SQLException.class) // @ExceptionHandler此处定义为全局变量，通过value可以过滤拦截条件，可以拦截指定的Exception
    public ResponseData sqlException(Exception exception , WebRequest request ){

        /* 日志记录 */
        this.insertErrorExceptionLog(exception,"SQLException");

        return new ResponseData("999999",exception.getMessage());
    }

	@ModelAttribute // @ModelAttribute注解将键值对添加到全局，所有注解@RequestMapping的方法都可以获得此键
	public void addAttribute(Model model){
		//model.addAttribute("msg", "附加信息>>>>>>>>>");
	}

	@InitBinder // @InitBinder 定制WebDataBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields("id");
	}


    /**
     * 异常日志储存
     * @param exception
     */
	public void insertErrorExceptionLog(Exception exception,String errType){
         /* 日志记录 */
        ErrorLog err = new ErrorLog();
        err.setErrName(exception.getMessage().substring(0,250));
        err.setErrException(exception.toString().substring(0,250));
        err.setErrMsg(getExceptionInfo(exception).substring(0,5000));
        err.setErrorClass(exception.getClass().toString());
        err.setErrType(errType);
        try {
            errorLogService.insertErrorLogService(err); // 第一次
        }catch (Exception ex){
            try {
                errorLogService.insertErrorLogService(err); //第二次
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        logger.error("ERROR========ID=[["+ err.getErrId() + "]],MSG=[[" + exception.toString()+"]]========ERROR");
    }

    /**
     * 获取异常的详细信息
     * @param ex
     * @return
     */
    public String getExceptionInfo(Exception ex){
        StringBuffer out = new StringBuffer();
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            out.append( "\tat " + s + "\r\n");
        }
        return out.toString();
    }

}
