package com.ruinivan.edufincore.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CnabFileControl extends Base {
  private String fileName;
  private String fileType;
  private CnabFileControlStatus status;
  private String bankCode;
  private Integer totalRecords;
  private BigDecimal totalAmount;
  private LocalDateTime processedAt;
  private String errorMessage;
  private String fileContentSample;

  public CnabFileControl(String fileName, String fileType, String bankCode, Integer totalRecords,
      BigDecimal totalAmount, String fileContentSamble) {

    if (totalAmount == null) {
      throw new IllegalArgumentException("Total amount cannot be null");
    }
    if (totalAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Total amount cannot be negative");
    }
    super();
    this.fileName = fileName;
    this.fileType = fileType;
    this.bankCode = bankCode;
    this.totalRecords = totalRecords;
    this.totalAmount = totalAmount;
    this.fileContentSample = fileContentSamble;
    this.status = CnabFileControlStatus.PENDING;
  }

  public static CnabFileControl restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String fileName,
      String fileType,
      CnabFileControlStatus status, String bankCode, Integer totalRecords,
      BigDecimal totalAmount, String fileContentSamble) {
    return new CnabFileControl(id, createdAt, updatedAt, fileName, fileType, status, bankCode, totalRecords,
        totalAmount, fileContentSamble);
  }

  private CnabFileControl(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String fileName, String fileType,
      CnabFileControlStatus status, String bankCode, Integer totalRecords,
      BigDecimal totalAmount, String fileContentSamble) {
    super(id, createdAt, updatedAt);
    this.fileName = fileName;
    this.fileType = fileType;
    this.status = status;
    this.bankCode = bankCode;
    this.totalRecords = totalRecords;
    this.totalAmount = totalAmount;
    this.fileContentSample = fileContentSamble;
  }

  public String getFileName() {
    return this.fileName;
  }

  public String getFileType() {
    return this.fileType;
  }

  public CnabFileControlStatus getStatus() {
    return this.status;
  }

  public String getBankCode() {
    return this.bankCode;
  }

  public Integer getTotalRecords() {
    return this.totalRecords;
  }

  public java.math.BigDecimal getTotalAmount() {
    return this.totalAmount;
  }

  public LocalDateTime getProcessedAt() {
    return this.processedAt;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public String getFileContentSample() {
    return this.fileContentSample;
  }
}
