package com.turkcell.library_cqrs.core.transaction;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(15)
public class TransactionBehavior implements PipelineBehavior {

    private final PlatformTransactionManager transactionManager;

    public TransactionBehavior(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public boolean supports(Object request) {
        return request instanceof TransactionalRequest;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            System.out.println("[TRANSACTION] Başladı: " + request.getClass().getSimpleName());
            R response = next.invoke();
            transactionManager.commit(status);
            System.out.println("[TRANSACTION] Commit: " + request.getClass().getSimpleName());
            return response;
        } catch (Exception e) {
            transactionManager.rollback(status);
            System.out.println("[TRANSACTION] Rollback: " + request.getClass().getSimpleName() + " -> " + e.getMessage());
            throw e;
        }
    }
}