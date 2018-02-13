package com.escobar.j0e009t.squareortriangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findIfTriangleOrSquare(View view){
        EditText editText = findViewById(R.id.entered_number);
        int entered_num = Integer.parseInt(editText.getText().toString());

        boolean isSquare = isNumASquare(entered_num);
        boolean isTriangular = isNumTriangular(entered_num);

        if(isTriangular && isSquare){
            createToast("Both");
        }
        else if(isTriangular){
            createToast( "Triangular");
        }
        else if(isSquare){
            createToast( "Perfect Square");
        }
        else{
            createToast( "Neither");
        }
    }

    private boolean isNumASquare(int enteredNum){
        boolean isSquare = false;

        int squareRoot = (int) Math.sqrt(enteredNum);

        if(squareRoot*squareRoot == enteredNum){
            isSquare = true;
        }
        return isSquare;
    }

    private boolean isNumTriangular(int enteredNum){
        int num = (8 * enteredNum) + 1;
        return isNumASquare(num);
    }

    private void createToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
