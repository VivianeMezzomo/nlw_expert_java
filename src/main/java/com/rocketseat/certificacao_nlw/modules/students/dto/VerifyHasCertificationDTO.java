package com.rocketseat.certificacao_nlw.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyHasCertificationDTO {

    private String email;
    private String technology;

    public String getEmail() {
        return email;
    }

    public String getTechnology() {
        return technology;
    }
}
