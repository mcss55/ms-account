package com.mcss.msaccount.DTO;

import lombok.Builder;

import java.util.List;

public record AccountUpdate(
        String name,
        String surname,
        Double balance,
        List<Long> tickets
)  {
}
