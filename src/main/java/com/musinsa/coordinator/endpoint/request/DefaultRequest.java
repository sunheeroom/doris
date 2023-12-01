package com.musinsa.coordinator.endpoint.request;

public interface DefaultRequest {

    // TODO entity의 비즈니스 로직에 대한 검증(값 범위 문자열 등등..)
    boolean validate();
}
