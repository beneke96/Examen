package cip.ruben.examen;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	private EditText et_altura,et_peso,et_imc;
	private Button b_calcular;
	private CheckBox cb_mostrar;
	final DecimalFormat df=	 new DecimalFormat(".##");

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et_altura = (EditText) findViewById(R.id.et_altura);
        et_peso = (EditText) findViewById(R.id.et_peso);
        et_imc = (EditText) findViewById(R.id.et_IMC);
        
        cb_mostrar =(CheckBox) findViewById(R.id.checkBox1);
        
        b_calcular = (Button) findViewById(R.id.button1);
        b_calcular.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				calcularIMC();
			}
		});
        
    }
    
    public void calcularIMC(){
    	double peso = Double.parseDouble(et_peso.getText().toString());
    	double altura = Double.parseDouble(et_altura.getText().toString());
    	
    	double imc = peso / (altura*altura);
    	
    	if (cb_mostrar.isChecked()==true) {

    		if (imc < 16.00) {
    			Toast.makeText(getApplicationContext(), "Infrapeso:Delgadez Severa", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>16.00 && imc<16.99 ) {
    			Toast.makeText(getApplicationContext(), "Infrapeso:Delgadez Moderada", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>17.00 && imc<18.49) {
    			Toast.makeText(getApplicationContext(), "Infrapeso:Delgadez Aceptable", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>18.50 && imc<24.99) {
    			Toast.makeText(getApplicationContext(), "Peso normal", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>25.00 && imc<29.99) {
    			Toast.makeText(getApplicationContext(), "Sobrepeso", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>30.00 &&  imc<34.99) {
    			Toast.makeText(getApplicationContext(), "Obeso:Tipo I", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>35.00 && imc<40.00) {
    			Toast.makeText(getApplicationContext(), "Obeso: Tipos II", Toast.LENGTH_SHORT).show();
    		}
        	if (imc>40.00) {
    			Toast.makeText(getApplicationContext(), "Obeso:Tipo III", Toast.LENGTH_SHORT).show();
    		}
		
		}
    	
    	et_imc.setText(String.valueOf(df.format(imc)));
    }

}
