package com.example.bankcards.entity.enums;

import lombok.Getter;

@Getter
public enum CardType {
    VISA(1, "Visa", "411111", "4[0-9]{12,15}", 16),

    MASTERCARD(2, "MasterCard", "511111", "5[1-5][0-9]{14}", 16);


    public static final String MASKED_CARD_PATTERN = "^(\\*{4} ?)*\\d{4}$";
    public static final int DIGIT_IN_ONE_SECTION = 4;

    private final int typeCode;
    private final String CardName;
    private final String prefix;
    private final String regex;
    private final int length;

    CardType(int typeCode, String CardName, String prefix, String regex, int length) {
        this.typeCode = typeCode;
        this.CardName = CardName;
        this.prefix = prefix;
        this.regex = regex;
        this.length = length;
    }
}
