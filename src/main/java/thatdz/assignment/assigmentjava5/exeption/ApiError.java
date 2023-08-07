package thatdz.assignment.assigmentjava5.exeption;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
  private String message;
  private HttpStatusCode statusCode;
  private List<String> errors;

  ApiError(String message, HttpStatusCode statusCode, String error) {
    this.message = message;
    this.statusCode = statusCode;
    this.errors = Arrays.asList(error);
  }
}
