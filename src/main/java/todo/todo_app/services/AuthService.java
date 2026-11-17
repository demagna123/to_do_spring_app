package todo.todo_app.services;

import todo.todo_app.dtos.AuthResponse;
import todo.todo_app.dtos.LoginRequest;
import todo.todo_app.dtos.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
