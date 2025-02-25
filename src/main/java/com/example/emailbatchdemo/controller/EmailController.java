package com.example.emailbatchdemo.controller;

import com.example.emailbatchdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/email")
public class EmailController {
  @Autowired
  private EmailService emailService;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/sendBatchEmail")
  public ResponseEntity<String> sendBatchEmail() {
    logger.info("執行緒: {} Controller接收請求", Thread.currentThread().getName());

    try{
      emailService.sendBatchEmail();
      logger.info("執行緒: {} Controller立即回應", Thread.currentThread().getName());
      return ResponseEntity.ok("批次郵件發送已啟動，稍後查看結果");

    } catch (Exception e) {
      return ResponseEntity.status(500).body("批次郵件發送失敗");
    }
  }

  @GetMapping("/voidSendBatchEmail")
  public ResponseEntity<String> voidSendBatchEmail() {
    logger.info("執行緒: {} Controller接收請求", Thread.currentThread().getName());

    try{
      emailService.voidSendBatchEmail();
      logger.info("執行緒: {} Controller立即回應", Thread.currentThread().getName());
      return ResponseEntity.ok("批次郵件發送已啟動，稍後查看結果");

    } catch (Exception e) {
      return ResponseEntity.status(500).body("批次郵件發送失敗");
    }
  }

}
