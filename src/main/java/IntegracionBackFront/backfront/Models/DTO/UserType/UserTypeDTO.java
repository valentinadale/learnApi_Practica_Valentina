package IntegracionBackFront.backfront.Models.DTO.UserType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserTypeDTO {

    private Long id;
    private String nombreTipo;
    private String descripcion;

}
