package com.example.appeventos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sing_up extends AppCompatActivity {

	private Button button;
	private EditText EdtEmail, EdtPass, EdtPass2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_sing_up2);

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});

		button = findViewById(R.id.button_registrar);
		EdtEmail = findViewById(R.id.edtEmail);
		EdtPass = findViewById(R.id.edtSenhaConf);
		EdtPass2 = findViewById(R.id.EdtSenha);

		button.setOnClickListener(v -> {
			String email = EdtEmail.getText().toString().trim();
			String password = EdtPass.getText().toString().trim();
			String password2 = EdtPass2.getText().toString().trim();

			if (email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
				Toast.makeText(Sing_up.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
				return;
			}

			if (!password.equals(password2)) {
				Toast.makeText(Sing_up.this, "As senhas não correspondem", Toast.LENGTH_SHORT).show();
				return;
			}

			// Here, you would add logic to save the user data (e.g., to a database or shared preferences)
			Toast.makeText(Sing_up.this, "Usuário registrado com sucesso", Toast.LENGTH_SHORT).show();
			// Optionally, navigate to another activity
		});


	}
}
