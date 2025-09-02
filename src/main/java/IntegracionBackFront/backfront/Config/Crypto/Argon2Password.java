package IntegracionBackFront.backfront.Config.Crypto;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class Argon2Password {

    //configuracion recomendada para argon 2
    private static final int INTERATIONS = 10;
    private static final int MEMORY = 32768;
    private static final int PARALLELISM = 2;

    private Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    public String EncryptPassword(String password){
        return argon2.hash(INTERATIONS, MEMORY, PARALLELISM, password);
    }

    public boolean VerifyPassword(String passwordDB, String password){
        return argon2.verify(passwordDB, password);
    }

}
