package com.example.simplecalculator.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simplecalculator.pojo.DataBase;
import com.example.simplecalculator.pojo.NumberModel;

public class NumbersModelView extends ViewModel {

    public MutableLiveData<String> numMutableLiveData = new MutableLiveData<>();


    public int getNumFromDB(){
        NumberModel numberModel = new DataBase().getNumbers();
        return numberModel.getFirstNum() * numberModel.getSecondNum();
    }

    public void getMulResult(){
        String result = Integer.toString(getNumFromDB());
        numMutableLiveData.setValue(result);
    }


}
