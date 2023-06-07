package thatdz.assignment.assigmentjava5.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Login {
    @NotBlank(message = "Mã không được trống!!!")
    private String ma;
    @NotBlank(message = "Tên không được trống!!!")
    private String password;
}
