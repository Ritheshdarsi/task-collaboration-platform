@Service
public class AuthService {
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;
    public String login(LoginReq req) {
        User user = userRepo.findByUsername(req.getUsername()).orElseThrow();
        if (encoder.matches(req.getPassword(), user.getPasswordHash())) {
            return JwtUtil.generateToken(user.getUsername());  // Implement JwtUtil
        }
        throw new RuntimeException("Invalid creds");
    }
}

