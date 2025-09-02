package IntegracionBackFront.backfront.Services.Auth;

import IntegracionBackFront.backfront.Config.Crypto.Argon2Password;
import IntegracionBackFront.backfront.Entities.Users.UserEntity;
import IntegracionBackFront.backfront.Repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public Boolean Login(String correo, String contrasena) {
        Argon2Password objHash = new Argon2Password();
        //invocar un metodo que permita buscar al usuario por su correo
        Optional<UserEntity> list = repo.findByCorreo(correo);
        if (list.isPresent()) {
            UserEntity usuario = list.get();
            String nombreTipoUsuario = usuario.getTipoUsuario().getNombreTipo();
            System.out.println("Usuario encontrado ID: " + usuario.getId() +
                    ", emial: " + usuario.getCorreo() +
                    ", rol: " + nombreTipoUsuario);
            String HashDB = usuario.getContrasena();
            return objHash.VerifyPassword(HashDB, contrasena);
        }
        return false;
    }

    public Optional<UserEntity> obtenerUsuario(String correo) {
        // Buscar usuario completo en la base de datos
        Optional<UserEntity> userOpt = repo.findByCorreo(correo);
        return (userOpt != null) ? userOpt : null;
    }
}
