package com.example.emailbatchdemo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {

  List<String> sendBatchEmail();

  void voidSendBatchEmail();
}
