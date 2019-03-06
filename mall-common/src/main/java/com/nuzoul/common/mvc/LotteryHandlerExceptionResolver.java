package com.nuzoul.common.mvc;


import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.nuzoul.common.model.JsonModel;
import com.nuzoul.common.service.RespCode;
import com.nuzoul.common.service.RespMsg;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



public class LotteryHandlerExceptionResolver extends ExceptionHandlerExceptionResolver {

    private View fastJsonView = new FastJsonJsonView();


	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //记录异常信息
        if (e != null) {
            e.printStackTrace();
//            Log.error("error", e.getMessage(), e);
        }
        
        long errCode = RespCode.FAIL;
        String errMsg = RespMsg.SYSTEM_ERROR;
        errMsg += e.getClass().getName();

        boolean isAjax = getJsonMediaType(httpServletRequest)!=null?true:false;
        if (isAjax) {
            String dtag = httpServletRequest.getParameter("dtag");
            JsonModel failJson = JsonModel.createFail(errCode, 0, errMsg, dtag);
            return new ModelAndView(fastJsonView, failJson.toMapModel());
        }
		ModelAndView view = new ModelAndView();
        view.setViewName("/error/common-error");
        view.addObject("errCode", errCode);
        view.addObject("errMsg", errMsg);
        view.addObject("exception:", e.getMessage());
        e.printStackTrace();
        return view;
	}

    private MediaType getJsonMediaType(HttpServletRequest request) {
        List<MediaType> acceptedMediaTypes = new ServletServerHttpRequest(request).getHeaders().getAccept();
        if (acceptedMediaTypes != null) {
            for (MediaType mediaType : acceptedMediaTypes) {
                if ("json".equalsIgnoreCase(mediaType.getSubtype()) || "text/html".equalsIgnoreCase(mediaType.getSubtype())) {
                    return mediaType;
                }
            }
        }
        return MediaType.APPLICATION_JSON;
    }
	
    public View getFastJsonView() {
        return fastJsonView;
    }

    public void setFastJsonView(View fastJsonView) {
        this.fastJsonView = fastJsonView;
    }
}
