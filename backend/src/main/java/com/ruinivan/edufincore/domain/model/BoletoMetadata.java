package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class BoletoMetadata extends Base {
  private UUID tuitionId;
  private String nossoNumero;
  private String digitableLine;
  private String barcode;
  private String bankCode;
  private String documentNumber;
  private boolean registeredAtBank;

  public BoletoMetadata(UUID tuitionId, String nossoNumero, String digitableLine, String barcode, String bankCode,
      String documentNumber, boolean registeredAtBank) {
    super();
    this.tuitionId = tuitionId;
    this.nossoNumero = nossoNumero;
    this.digitableLine = digitableLine;
    this.barcode = barcode;
    this.bankCode = bankCode;
    this.documentNumber = documentNumber;
    this.registeredAtBank = registeredAtBank;
  }

  public static BoletoMetadata restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID tuitionId,
      String nossoNumero,
      String digitableLine, String barcode, String bankCode,
      String documentNumber, boolean registeredAtBank) {
    return new BoletoMetadata(id, createdAt, updatedAt, tuitionId, nossoNumero, digitableLine, barcode, bankCode,
        documentNumber, registeredAtBank);
  }

  private BoletoMetadata(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID tuitionId, String nossoNumero,
      String digitableLine, String barcode, String bankCode,
      String documentNumber, boolean registeredAtBank) {
    super(id, createdAt, updatedAt);
    this.tuitionId = tuitionId;
    this.nossoNumero = nossoNumero;
    this.digitableLine = digitableLine;
    this.barcode = barcode;
    this.bankCode = bankCode;
    this.documentNumber = documentNumber;
    this.registeredAtBank = registeredAtBank;
  }

  public UUID getTuitionId() {
    return this.tuitionId;
  }

  public String getNossoNumero() {
    return this.nossoNumero;
  }

  public String getDigitableLine() {
    return this.digitableLine;
  }

  public String getBarcode() {
    return this.barcode;
  }

  public String getBankCode() {
    return this.bankCode;
  }

  public String getDocumentNumber() {
    return this.documentNumber;
  }

  public boolean isRegisteredAtBank() {
    return this.registeredAtBank;
  }
}
