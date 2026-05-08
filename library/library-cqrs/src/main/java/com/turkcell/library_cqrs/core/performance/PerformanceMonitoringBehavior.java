package com.turkcell.library_cqrs.core.performance;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(10)
public class PerformanceMonitoringBehavior implements PipelineBehavior {

    private static final long WARNING_THRESHOLD_MS = 3000;

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        long start = System.currentTimeMillis();

        R response = next.invoke();

        long elapsed = System.currentTimeMillis() - start;

        if (elapsed > WARNING_THRESHOLD_MS) {
            System.out.println("[PERFORMANCE WARNING] "
                    + request.getClass().getSimpleName()
                    + " -> " + elapsed + "ms sürdü! (Eşik: " + WARNING_THRESHOLD_MS + "ms)");
        } else {
            System.out.println("[PERFORMANCE] "
                    + request.getClass().getSimpleName()
                    + " -> " + elapsed + "ms");
        }

        return response;
    }
}