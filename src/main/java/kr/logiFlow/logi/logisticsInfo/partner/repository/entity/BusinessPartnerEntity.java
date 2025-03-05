package kr.logiFlow.logi.logisticsInfo.partner.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.logiFlow.logi.logisticsInfo.partner.domain.Address;
import kr.logiFlow.logi.logisticsInfo.partner.domain.BusinessPartner;
import kr.logiFlow.logi.logisticsInfo.partner.domain.BusinessType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 💭 추후에 리패고링 할 때 빌더를 사용하는 방법을 생각해보도록 하자
 */
@Entity
@Table(name = "business_partners")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // ❓ 이거 왜 이렇게 설정해야 해?
public class BusinessPartnerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String partnerName;

  @Column
  private String partnerCode;

  @Column
  private String partnerTelNumber;

  @Column
  private String partnerFaxNumber;

  @Embedded
  private Address partnerAddress;

  @Enumerated(EnumType.STRING)
  @Column
  private BusinessType type;

  @Column
  private String productCategory;

  public BusinessPartnerEntity(String partnerName, String partnerCode,
      String partnerTelNumber, String partnerFaxNumber, Address partnerAddress, BusinessType type,
      String productCategory) {
    this.partnerName = partnerName;
    this.partnerCode = partnerCode;
    this.partnerTelNumber = partnerTelNumber;
    this.partnerFaxNumber = partnerFaxNumber;
    this.partnerAddress = partnerAddress;
    this.type = type;
    this.productCategory = productCategory;
  }

  // ✅ 도메인 객체 -> 엔티티 변환 메서드
  public static BusinessPartnerEntity from(BusinessPartner businessPartner) {
    return new BusinessPartnerEntity(
        businessPartner.partnerName(),
        businessPartner.partnerCode(),
        businessPartner.partnerTelNumber(),
        businessPartner.partnerFaxNumber(),
        businessPartner.partnerAddress(),
        businessPartner.type(),
        businessPartner.productCategory()
    );
  }

  // ✅ 엔티티 -> 도메인 객체 변환 메서드
  public BusinessPartner toDomain() {
    return new BusinessPartner(partnerName, partnerCode, partnerTelNumber, partnerFaxNumber, partnerAddress, type, productCategory);
  }
}
