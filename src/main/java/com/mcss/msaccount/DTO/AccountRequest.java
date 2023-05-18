package com.mcss.msaccount.DTO;

public record AccountRequest(
        String name,
        String surname,
        Double balance
) {
}
