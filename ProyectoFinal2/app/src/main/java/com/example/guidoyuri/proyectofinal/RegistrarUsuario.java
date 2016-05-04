package com.example.guidoyuri.proyectofinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class RegistrarUsuario extends AppCompatActivity {
    public static final String PARAMETRO1="guidoyuri.PARAMETRO1";
    public static final String PARAMETRO2="guidoyuri.PARAMETRO2";
    public static final String PARAMETRO3="guidoyuri.PARAMETRO3";
    EditText edtUser;
    EditText edtContrasena;
    EditText edtConf;
    EditText edtMail;
    TextView txtError;
    Button btnIngresar;
    TextView txtUsuario;
    TextView txtContra;
    TextView txtConfi;
    TextView txtMail;
    public int ValidarMail (String mail)
    {
        int estado;
        if (mail.contains("@") && mail.contains("."))
        {
            estado=0;
        }
        else
        {
            estado=1;
        }
        return estado;
    }
    public void MandarDatos(String usuario, String contrasena,String email)
    {
        // Intent nuevaActivity = new Intent(this, IngresarDireccion.class);

        Bundle datos = new Bundle();
        datos.putString(RegistrarUsuario.PARAMETRO1, usuario);
        datos.putString(RegistrarUsuario.PARAMETRO2, contrasena);
        datos.putString(RegistrarUsuario.PARAMETRO3, email);

        //nuevaActivity.putExtras(datos);

        //startActivity(nuevaActivity);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        edtUser = (EditText) findViewById(R.id.edtUsuario);
        edtContrasena = (EditText) findViewById(R.id.edtContra);
        edtConf = (EditText) findViewById(R.id.edtConfi);
        edtMail = (EditText) findViewById(R.id.edtMail);
        txtError = (TextView) findViewById(R.id.txtError);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        txtContra = (TextView) findViewById(R.id.txtContra);
        txtConfi = (TextView) findViewById(R.id.txtConfi);
        txtMail = (TextView) findViewById(R.id.txtMail);
    }


    public void Ingresar(View vista)
    {
        int errores = 0;
        String strUser = edtUser.getText().toString();
        String strContra = edtContrasena.getText().toString();
        String strConfirm = edtConf.getText().toString();
        String strMail = edtMail.getText().toString();
        if (strContra.compareTo(strConfirm)!=0) {
            errores = 1;
            txtUsuario.setTextColor(Color.GRAY);
            txtMail.setTextColor(Color.GRAY);
            txtContra.setTextColor(Color.RED);
            txtConfi.setTextColor(Color.RED);
        }
        if (strContra.length() < 8) {
            txtConfi.setTextColor(Color.GRAY);
            txtUsuario.setTextColor(Color.GRAY);
            txtMail.setTextColor(Color.GRAY);
            txtContra.setTextColor(Color.RED);
            errores = 1;
        }
        int est = ValidarMail(strMail);
        if (est == 1) {
            txtContra.setTextColor(Color.GRAY);
            txtConfi.setTextColor(Color.GRAY);
            txtUsuario.setTextColor(Color.GRAY);
            txtMail.setTextColor(Color.RED);
            errores = 1;
        }
        if (strUser==""||strContra==""||strConfirm==""||strMail=="")
        {
            errores=1;
            txtContra.setTextColor(Color.GRAY);
            txtConfi.setTextColor(Color.GRAY);
            txtUsuario.setTextColor(Color.GRAY);
            txtMail.setTextColor(Color.GRAY);
        }
        if (errores == 1) {
            edtContrasena.setText("");
            edtConf.setText("");
            txtError.setText("*Ingrese correctamente los datos");
        }
        else
        {
            txtContra.setTextColor(Color.GRAY);
            txtConfi.setTextColor(Color.GRAY);
            txtUsuario.setTextColor(Color.GRAY);
            txtMail.setTextColor(Color.GRAY);
            txtError.setText("");
            Toast.makeText(getApplicationContext(), "esta ok", Toast.LENGTH_SHORT).show();
            MandarDatos(strUser, strContra, strMail);
        }
    }
}

