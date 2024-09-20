package com.example.appeventos;

// ... imports ...

import android.content.Intent;
import android.os.Bundle;
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

		loginButton.setOnClickListener(v -> {
			String emailText = email.getText().toString().trim();
			String passwordText = password.getText().toString().trim();

			if (emailText.isEmpty() || passwordText.isEmpty()) {
				Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
				return; // Exit early if fields are empty
			}

			if (isUserRegistered(emailText, passwordText)) { // Call the verification method
				// Login successful
				Intent intent = new Intent(MainActivity.this, Home.class);
				startActivity(intent);
			} else {
				// Invalid credentials
				Toast.makeText(MainActivity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
			}
		});




		signUp.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity.this, Sing_up.class); // Changed class name
			startActivity(intent);
		});

		forgotPassword.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity.this, forgot_password.class); // Changed class name
			startActivity(intent);
		});
	}
	private boolean isUserRegistered(String email, String password) {
		if (email.equals("john.mckinley@examplepetstore.com") && password.equals("password")) {
			return true;
			} else {
			return false;


			// Add your own logic to check if the user is registered
			// For example, you can check a database or shared preferences
			// Return true if the user is registered, false otherwise

		}
	}


}