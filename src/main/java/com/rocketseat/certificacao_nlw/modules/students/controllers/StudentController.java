package com.rocketseat.certificacao_nlw.modules.students.controllers;

import com.rocketseat.certificacao_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certificacao_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certificacao_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certificacao_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import com.rocketseat.certificacao_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
public class StudentController {
    //Preciso usar o meu USECASE
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    /*Método para verificar se o usuário possui alguma certificação*/
    @PostMapping("verifyIfHasVerification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){
        //Email
        //Technology
        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if (result){
            return "Usuário já fez a prova";
        }
        return "Usuário pode fazer a prova";
        //System.out.println(verifyHasCertificationDTO);
        //return "Usuário pode fazer a prova.";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {
            var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
