package com.io.victorvn;

import com.io.victorvn.controller.PessoaController;
import com.io.victorvn.model.Pessoa;
import com.io.victorvn.view.PessoaPetView;
import com.io.victorvn.view.PessoaView;
import com.io.victorvn.view.PetView;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        Object[][] data = {
//                {"Kathy", "Smith",
//                        "Snowboarding", new Integer(5), new Boolean(false)},
//                {"John", "Doe",
//                        "Rowing", new Integer(3), new Boolean(true)},
//                {"Sue", "Black",
//                        "Knitting", new Integer(2), new Boolean(false)},
//                {"Jane", "White",
//                        "Speed reading", new Integer(20), new Boolean(true)},
//                {"Joe", "Brown",
//                        "Pool", new Integer(10), new Boolean(false)}
//        };
//
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("jaja");
//
//        Field[] fields = Pessoa.class.getDeclaredFields();
        //PessoaView pessoaView = new PessoaView();
        //pessoaView.showMenuCadastrar();
        //pessoaView.showMenuCadastrar();

//        PetView petView = new PetView();
//        petView.showMenuCadastrar();

        PessoaPetView pessoaPetView = new PessoaPetView();

        pessoaPetView.showMenuCadastrar();


    }
}
