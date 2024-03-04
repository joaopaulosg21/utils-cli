package projeto.cli.utils.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TaskDTO(String id, String description, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime time,
        boolean everyDay, boolean completed, UserDTO user) {

}
