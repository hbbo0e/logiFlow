package kr.logiFlow.logi.logisticsInfo.partner.domain;

public record BusinessPartner(
    String partnerName,
    String partnerCode,
    String partnerTelNumber,
    String partnerFaxNumber,
    Address partnerAddress,
    BusinessType type,
    String productCategory
){}
