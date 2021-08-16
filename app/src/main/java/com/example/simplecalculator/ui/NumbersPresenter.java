package com.example.simplecalculator.ui;

import com.example.simplecalculator.pojo.DataBase;
import com.example.simplecalculator.pojo.NumberModel;

public class NumbersPresenter {

    NumPresenterView view;

    public NumbersPresenter(NumPresenterView view) {
        this.view = view;
    }

    public int getNumFromDB(){
        NumberModel numberModel = new DataBase().getNumbers();
        return numberModel.getFirstNum() / numberModel.getSecondNum();
    }

    public void getDivResult(){
        String result = Integer.toString(getNumFromDB());
        view.onGetDivResult(result);
    }


}
