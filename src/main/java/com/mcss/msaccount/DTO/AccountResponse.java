package com.mcss.msaccount.DTO;

import java.util.List;

public record AccountResponse(
        String name,
        String surname,
        Double balance,
        List<Long> tickets
) {
}
