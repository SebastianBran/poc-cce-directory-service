package com.cce.transaction.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTransactionRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String senderPhoneNumber;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String receiverPhoneNumber;

    @NotNull
    private Long amount;

    @NotNull
    private Long currency;

    @NotNull
    @NotBlank
    private String entityId;

    public CreateTransactionRequestDto() {}

    public CreateTransactionRequestDto(String senderPhoneNumber, String receiverPhoneNumber, Long amount, Long currency, String entityId) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.amount = amount;
        this.currency = currency;
        this.entityId = entityId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
