package com.example.emailbatchdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
  Logger logger = LoggerFactory.getLogger(this.getClass());


  @Async("customThreadPool")
  @Override
  public List<String> sendBatchEmail() {
    logger.info("執行緒: {} 開始批次發送郵件", Thread.currentThread().getName());

    List<String> emailList = Arrays.asList("user1@example.com", "user2@example.com", "user3@example.com");

    List<String> sentEmails = new ArrayList<>();
    for (String email : emailList) {
      try {
        Thread.sleep(1000); // 模擬發送時間
        logger.info("[{}] 成功發送郵件至: {}", Thread.currentThread().getName(), email);
        sentEmails.add(email);
      } catch (InterruptedException e) {
        logger.error("發送郵件失敗: {}", email, e);
      }
    }

    logger.info("[{}] 批次郵件發送完成，共發送 {} 封郵件", Thread.currentThread().getName(), sentEmails.size());
    return sentEmails; // 回傳寄出的信件列表
  }

  @Async("customThreadPool")
  @Override
  public void voidSendBatchEmail() {
    logger.info("[{}] 開始批次發送郵件", Thread.currentThread().getName());

    List<String> emailList = Arrays.asList(
        "user1@example.com", "user2@example.com", "user3@example.com"
    );

    for (String email : emailList) {
      try {
        Thread.sleep(1000); // 模擬發送時間
        logger.info("[{}] 成功發送郵件至: {}", Thread.currentThread().getName(), email);
      } catch (InterruptedException e) {
        logger.error("發送郵件失敗: {}", email, e);
      }
    }

    logger.info("[{}] 批次郵件發送完成", Thread.currentThread().getName());
  }
}
