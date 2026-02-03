package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ruinivan.edufincore.domain.model.CnabFileControlStatus;

@Entity
@Table(name = "TB_CNAB_FILE_CONTROL", indexes = {
    @Index(name = "IDX_CNAB_FILENAME", columnList = "file_name", unique = true),
    @Index(name = "IDX_CNAB_PROCESS_DATE", columnList = "processed_at")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CnabFileControlEntity extends BaseEntity {

  @Column(name = "file_name", nullable = false, length = 255)
  private String fileName;

  @Column(name = "file_type", nullable = false, length = 10)
  private String fileType; // REMESSA (Envio), RETORNO (Recebimento)

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, length = 20)
  private CnabFileControlStatus status; // PENDING, PROCESSED, ERROR

  @Column(name = "bank_code", nullable = false, length = 3)
  private String bankCode;

  @Column(name = "total_records")
  private Integer totalRecords;

  @Column(name = "total_amount", precision = 18, scale = 2)
  private BigDecimal totalAmount;

  @Column(name = "processed_at")
  private LocalDateTime processedAt;

  @Column(name = "error_message", length = 4000)
  private String errorMessage;

  // Opcional: Armazenar o conteúdo do arquivo (CLOB) para debug,
  // mas em produção geralmente salvamos no S3 e guardamos o link aqui.
  @Lob
  @Column(name = "file_content_sample")
  private String fileContentSample;
}