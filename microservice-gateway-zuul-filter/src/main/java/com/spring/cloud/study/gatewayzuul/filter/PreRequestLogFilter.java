package com.spring.cloud.study.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreRequestLogFilter extends ZuulFilter {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
  
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    String msg = String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString());
    log.info("slf4j: " + msg);
    LOGGER.info("LOGGER: " + msg);
    return null;
  }
}
