package kr.logiFlow.logi.logisticsInfo.partner.domain;

public record BusinessPartner(
    String cutName,
    String cutCode,
    String cutTelNumber,
    String cutFaxNumber,
    Address address,
    Business type,
    String productCategory
){}
