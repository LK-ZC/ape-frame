package com.jingdianjichi.threadpool.mdcable;

import com.jingdianjichi.trace.TraceIdContext;

/**
 * @author: Henrik.Zhou
 * @date: 2023/7/20 16:20
 */
public class MdcAbstract {

    protected String traceId;
    protected void beforeRun() {
        TraceIdContext.setTraceId(traceId);
    }

    protected void afterRun() {
        TraceIdContext.clearTraceId();
    }
}
