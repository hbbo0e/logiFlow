package kr.logiFlow.logi.logisticsInfo.partner.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {

  private String baseAddress; // 기본 주소 서울특별시 영등포구
  private String detailAddress; // 의사당대로 1
  private String zipCode; // 우편번호

  // 💭 생성자를 만들어서 이걸 다 넣는 방법 말고는 다른 어떤 방법이 있을까
  public Address(String baseAddress, String detailAddress, String zipCode) {
    this.baseAddress = baseAddress;
    this.detailAddress = detailAddress;
    this.zipCode = zipCode;
  }
}
