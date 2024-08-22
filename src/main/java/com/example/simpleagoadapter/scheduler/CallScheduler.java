package com.example.simpleagoadapter.scheduler;

import com.example.simpleagoadapter.service.AgoService;
import example.ago.simple.Juridical;
import example.ago.simple.NotificationTypeEnum;
import example.ago.simple.StartCallRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@RequiredArgsConstructor
@Slf4j
public class CallScheduler {
    private final AgoService service;

    @Scheduled(cron = "${application.scheduled-task.retry.schedule}")
    public void retry() {
        log.info("Scheduled task has STARTED");
        service.startCall(makeStartCallRequest());
        log.info("Scheduled task has FINISHED");
    }


    private StartCallRequest makeStartCallRequest() {
        StartCallRequest request = new StartCallRequest();
        request.setDebt(5454);
        request.setReason("test");
        request.setPaymentDate(Calendar.getInstance());
        request.setTerminationDate(Calendar.getInstance());
        request.setAccount("111111");
        request.setAppPkId(12);
        request.setASRClientId(545);
        request.setJuridical(Juridical.HUMAN);
        request.setMsisdn("151115");
        request.setNotificationType(NotificationTypeEnum.INFO);
        return request;
    }
}
