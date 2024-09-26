package com.example.appeventos;

// ... imports ...

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appeventos.data.forgot_password;

public class MainActivity extends AppCompatActivity {
	private Button loginButton;
	private EditText email, password;
	private TextView forgotPassword, signUp;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);

		loginButton = findViewById(R.id.login_button);
		email = findViewById(R.id.email);
		password = findViewById(R.id.password);
		forgotPassword = findViewById(R.id.forgot_password);
		signUp = findViewById(R.id.sign);

		loginButton.setOnClickListener(v -> handleLogin());
		signUp.setOnClickListener(v -> startActivity(new Intent(this, Sing_up.class)));
		forgotPassword.setOnClickListener(v -> startActivity(new Intent(this, forgot_password.class)));
	}

	private void handleLogin() {
		String emailText = email.getText().toString().trim();
		String passwordText = password.getText().toString().trim();

		if (!isValidEmail(emailText)) {
			showToast("Email inválido");
			return;
		}

		if (emailText.isEmpty() || passwordText.isEmpty()) {
			showToast("Por favor, preencha todos os campos");
			return;
		}

		if (isUserRegistered(emailText, passwordText)) {
			startActivity(new Intent(this, Home.class));
		} else {
			showToast("Email ou senha inválidos");
		}
	}

	private boolean isValidEmail(String email) {
		return Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private boolean isUserRegistered(String email, String password) {
		// Lógica de verificação no banco de dados
		return email.equals("john.mckinley@examplepetstore.com") && password.equals("password");
	}
}



