package com.io.victorvn.view;

import com.io.victorvn.controller.PessoaController;
import com.io.victorvn.controller.PetController;
import com.io.victorvn.model.Pessoa;
import com.io.victorvn.model.Pet;
import org.apache.commons.beanutils.MethodUtils;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PetView {

    PetController petController = new PetController();

    public void showMenuCadastrar(){

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();

        //System.exit(0);

    }

    private void inserir() {

        JOptionPane.showMessageDialog(
                null,
                petController.cadastrarPet(montarPet("cadastrar")));

        showMenuCadastrar();
    }

    private void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

        JOptionPane.showMessageDialog(null,petController.buscarPetPorId(id));
        showMenuCadastrar();
    }

    private void listar() {

        JFrame jFrame = new JFrame();
        List<Pet> pet = petController.buscarTodosPets();
        String[] columns = {"ID", "NOME", "TIPO", "IDADE"};
        JTable jTable = new JTable(getTableData(pet), columns);
        jTable.setBounds(30,40,200,300);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jFrame.add(jScrollPane);
        jFrame.setSize(300,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void alterar() {
        JOptionPane.showMessageDialog(
                null,
                petController.atualizarPet(montarPet("update")));

        showMenuCadastrar();
    }

    private void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        JOptionPane.showMessageDialog(
                null,
                petController.deletarPet(id));

        showMenuCadastrar();
    }

    private Pet montarPet(String action){

        int id = 0;
        if (action.equalsIgnoreCase("update")){
            id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        }

        String nome = JOptionPane.showInputDialog("NOME");
        String tipo = JOptionPane.showInputDialog("TIPO");
        String idade = JOptionPane.showInputDialog("IDADE");
        Pet pet = new Pet(
                id,
                nome,
                tipo,
                idade
        );

        return pet;
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
