package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.EspecialidadeEnum;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        @JsonAlias({"data_agendamento", "data_consulta"})
        LocalDateTime data,

        EspecialidadeEnum especialidade) {
}
