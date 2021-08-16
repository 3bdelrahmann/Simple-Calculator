package com.example.simplecalculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.simplecalculator.R;
import com.example.simplecalculator.databinding.ActivityMainBinding;
import com.example.simplecalculator.pojo.DataBase;
import com.example.simplecalculator.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements NumPresenterView {

    ActivityMainBinding binding;
    NumbersPresenter presenter;
    NumbersModelView modelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter = new NumbersPresenter(this);
        modelView = ViewModelProviders.of(this).get(NumbersModelView.class);
        modelView.numMutableLiveData.observe(this , new Observer<String>() {
            @Override
            public void onChanged(String s) {

                binding.mulResultTextView.setText(s);

            }
        });



        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String plusResult = Integer.toString(getPlusResult());
                binding.plusResultTextView.setText(plusResult);

            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.getDivResult();
            }
        });

        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                modelView.getMulResult();

            }
        });
    }



    public int getPlusResult(){
        NumberModel numberModel = new DataBase().getNumbers();
        return numberModel.getFirstNum() + numberModel.getSecondNum();
    }

    @Override
    public void onGetDivResult(String result) {
        binding.divResultTextView.setText(result);
    }
}