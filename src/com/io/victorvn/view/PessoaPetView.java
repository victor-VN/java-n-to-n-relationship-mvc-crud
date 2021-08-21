package com.io.victorvn.view;

import com.io.victorvn.controller.PessoaController;
import com.io.victorvn.controller.PessoaPetController;
import com.io.victorvn.controller.PetController;
import com.io.victorvn.model.Pessoa;
import com.io.victorvn.model.PessoaPet;
import com.io.victorvn.model.Pet;
import org.apache.commons.beanutils.MethodUtils;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PessoaPetView {

    PessoaPetController pessoaPetController = new PessoaPetController();
    PessoaController pessoaController = new PessoaController();
    PetController petController = new PetController();

    public void showMenuCadastrar(){

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - LISTAR, 3 - EXCLUIR"));
        if (ops == 1) inserir();
        if (ops == 2) listar();
        if (ops == 3) excluir();

        //System.exit(0);

    }

    private void inserir() {

        JOptionPane.showMessageDialog(
                null,
                pessoaPetController.adicionarPet(montarPessoaPet()));

        showMenuCadastrar();
    }

    private void listar() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA"));
        JFrame jFrame = new JFrame();
        List<Pet> pet = pessoaPetController.buscarPetDaPessoaPoId(id);

        if(pet.size() < 1){
            JOptionPane.showMessageDialog(null, "Este usuário não possui nenhum pet cadastrado!");
            showMenuCadastrar();
        }
        String[] columns = {"ID", "NOME", "TIPO", "IDADE"};
        JTable jTable = new JTable(getTableData(pet), columns);
        jTable.setBounds(30,40,200,300);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jFrame.add(jScrollPane);
        jFrame.setSize(300,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void excluir() {
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA"));
        int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID PET"));
        JOptionPane.showMessageDialog(
                null,
                pessoaPetController.excluirPet(idPessoa, idPet));

        showMenuCadastrar();
    }

    private PessoaPet montarPessoaPet(){


        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA"));
        int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID PET"));
        String obs = JOptionPane.showInputDialog("OBSERVAÇÃO");

        Pessoa tempPessoa = pessoaController.buscarPessoaPorId(idPessoa);
        Pet tempPet = petController.buscarPetPorId(idPet);

        PessoaPet pessoaPet = new PessoaPet(
                0,
                idPessoa,
                idPet,
                obs,
                tempPessoa,
                tempPet
        );

        return pessoaPet;
    }

    private Object[][] getTableData(List<Pet> pets){

        int qtdCampos = pets.get(0).getClass().getDeclaredFields().length;
        int qtdItens = pets.size();
        String[] fieldNames = getTableColumnIndex(pets.get(0));

        Object[][] data = new Object[qtdItens][qtdCampos];

        for (int i = 0; i < qtdItens; i++){
            for(int j = 0; j < qtdCampos; j++){
                try {
                    data[i][j] = MethodUtils.invokeExactMethod(pets.get(i), "get"+fieldNames[j],null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }

    private String[] getTableColumnIndex(Pet pet){
        Field[] fields = Pet.class.getDeclaredFields();
        String[] fieldsNames = new String[fields.length];
        int i = 0;

        for (Field field : fields){
            fieldsNames[i] =  field.getName().substring(0,1).toUpperCase() + field.getName().substring(1).toLowerCase();
            i++;
        }
        return fieldsNames;
    }
}
