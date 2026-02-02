package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_BOLETO_METADATA", indexes = {
    @Index(name = "IDX_BOLETO_NOSSO_NUMERO", columnList = "nosso_numero", unique = true),
    @Index(name = "IDX_BOLETO_BARCODE", columnList = "barcode")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class BoletoMetadataEntity extends BaseEntity {

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tuition_id", nullable = false, unique = true)
  private TuitionEntity tuition;

  @Column(name = "nosso_numero", nullable = false, length = 20)
  private String nossoNumero; // Identificador único no banco

  @Column(name = "digitable_line", nullable = false, length = 60)
  private String digitableLine; // Linha digitável para o app do banco

  @Column(name = "barcode", nullable = false, length = 60)
  private String barcode; // Código de barras para leitor

  @Column(name = "bank_code", nullable = false, length = 3)
  private String bankCode; // 341 (Itaú), 001 (BB), etc.

  @Column(name = "document_number", length = 20)
  private String documentNumber; // Número do documento interno enviado na remessa

  @Column(name = "registered_at_bank")
  private boolean registeredAtBank; // True se o arquivo de remessa foi processado com sucesso
}