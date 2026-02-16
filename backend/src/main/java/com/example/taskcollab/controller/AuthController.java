@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginReq req) {
        String token = authService.login(req);
        Map<String, String> response = Map.of("token", token);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterReq req) {
        // hash pw, save, return user
    }
}

